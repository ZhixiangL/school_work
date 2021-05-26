package mr

import "fmt"
import "log"
import "net/rpc"
import "hash/fnv"
import "os"
import "io/ioutil"
import "sort"
import "strconv"
import "encoding/json"
import "path/filepath"
import "time"

//
// Map functions return a slice of KeyValue.
//
type KeyValue struct {
	Key   string
	Value string
}


// for sorting by key.
type ByKey []KeyValue

// for sorting by key.
func (a ByKey) Len() int           { return len(a) }
func (a ByKey) Swap(i, j int)      { a[i], a[j] = a[j], a[i] }
func (a ByKey) Less(i, j int) bool { return a[i].Key < a[j].Key }

//
// use ihash(key) % NReduce to choose the reduce
// task number for each KeyValue emitted by Map.
//
func ihash(key string) int {
	h := fnv.New32a()
	h.Write([]byte(key))
	return int(h.Sum32() & 0x7fffffff)
}


//
// main/mrworker.go calls this function.
//
func Worker(mapf func(string, string) []KeyValue,
	reducef func(string, []string) string) {
	//map part
	reply :=Call(-1, -1, -1)
	for reply.Wait {
		time.Sleep(2*time.Second)
		reply = Call(-1, -1, -1)
	}
	var filename string
	var id int = -1
	if(!reply.MapStop && !reply.Stop) {
		id = reply.MapId
		lastFileId := reply.FileId
		filename = reply.FileName
		nReduce := reply.NReduce
		files := make([]*os.File, nReduce)
	
		for i :=0; i<nReduce; i++ {
			nf, _ := os.Create("mr-"+strconv.Itoa(id)+"-"+strconv.Itoa(i))
			files[i] = nf
		}	
		for (!reply.MapStop && !reply.Stop) {
			filename = reply.FileName
			lastFileId = reply.FileId
			file, err := os.Open(filename)
			if err != nil {
				log.Fatalf("cannot open %v", filename)
			}
			content, err := ioutil.ReadAll(file)
			if err != nil {
				log.Fatalf("cannot read %v", filename)
			}
			file.Close()
			kva := mapf(filename, string(content))
			for _, ele := range kva {
				bucket := ihash(ele.Key) % nReduce
				enc := json.NewEncoder(files[bucket])
				enc.Encode(&ele)
			}
			reply = Call(lastFileId, -1, id)
			for reply.Wait {
				time.Sleep(2*time.Second)
				reply = Call(lastFileId, -1, id)
			}
			
		}
	}

	time.Sleep(2*time.Second)
	lastReduceId := reply.NReduceId
	for !reply.Stop {

		matches, err := filepath.Glob("./mr-*-"+ strconv.Itoa(lastReduceId) )
		if err != nil {
				fmt.Println(err)
		}
		intermediate := []KeyValue{}
		if len(matches) != 0 {
			kva := []KeyValue{}
			for _, f := range matches {
				fi, _ := os.Open(f)
				dec := json.NewDecoder(fi)
				for {
					var kv KeyValue
					if err := dec.Decode(&kv); err != nil {
					break
					}
					kva = append(kva, kv)
				}
				fi.Close()
			}
			intermediate = append(intermediate, kva...)
		}
		sort.Sort(ByKey(intermediate))

		oname := "mr-out-" + strconv.Itoa(lastReduceId)
		
		outputs := []KeyValue{}
		i := 0
		for i < len(intermediate) {
			j := i + 1
			for j < len(intermediate) && intermediate[j].Key == intermediate[i].Key {
				j++
			}
			values := []string{}
			for k := i; k < j; k++ {
				values = append(values, intermediate[k].Value)
			}
			output := reducef(intermediate[i].Key, values)
			outputs = append(outputs, KeyValue{intermediate[i].Key, output})

			i = j
		}
		ofile, _ := os.Create(oname)
		for _, v := range outputs {
			fmt.Fprintf(ofile, "%v %v\n", v.Key, v.Value)
		}
		ofile.Close()

		reply = Call(0, lastReduceId, id)
		for reply.Wait {
			time.Sleep(2*time.Second)
			reply = Call(0, lastReduceId, id)
		}
		filename = reply.FileName
		lastReduceId = reply.NReduceId

	
	}

	return

	//

}

//
// example function to show how to make an RPC call to the master.
//
// the RPC argument and reply types are defined in rpc.go.
//
func Call(lastFileId int, lastReduceId int, id int) Reply{

	args := Args{}
	args.LastFileId = lastFileId
	args.LastReduceId = lastReduceId
	args.Id = id
	// declare a reply structure.
	reply := Reply{}

	// send the RPC request, wait for the reply.
	call("Master.Example", &args, &reply)

	// reply.Y should be 100.
	return reply
}

//
// send an RPC request to the master, wait for the response.
// usually returns true.
// returns false if something goes wrong.
//
func call(rpcname string, args interface{}, reply interface{}) bool {
	// c, err := rpc.DialHTTP("tcp", "127.0.0.1"+":1234")
	sockname := masterSock()
	c, err := rpc.DialHTTP("unix", sockname)
	if err != nil {
		log.Fatal("dialing:", err)
	}
	defer c.Close()

	err = c.Call(rpcname, args, reply)
	if err == nil {
		return true
	}

	fmt.Println(err)
	return false
}
