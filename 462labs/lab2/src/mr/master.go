package mr

import "log"
import "net"
import "os"
import "net/rpc"
import "net/http"
import "time"
//import "fmt"
import "sync"

type Master struct {
	// Your definitions here.
	mu sync.Mutex 
	files []string
	fileStatus []int
	reduceId int
	nReduceStatus []int
	countDown []time.Time
	nReduce int
	mapDone bool
	reduceDone bool 
	mapId int
}

// Your code here -- RPC handlers for the worker to call.

//
// an example RPC handler.
//
// the RPC argument and reply types are defined in rpc.go.
//
func (m *Master) allFilesMapped() bool {
	ret := true
	for _, v := range m.fileStatus {
		if v!= 2 {
			return false
		}
	} 
	return ret
}

func (m *Master) allReducesDone() bool {
	ret := true
	for _, v := range m.nReduceStatus {
		if v!= 2 {
			return false
		}
	} 
	return ret
}

func (m *Master) assignNReduce(reply *Reply) {
	for i := 0; i < m.nReduce; i++ {
		if (m.nReduceStatus[i]==0) || (m.nReduceStatus[i]==1 && m.countDown[i].Add(10*time.Second).Before(time.Now())) {
			m.nReduceStatus[i] = 1
			m.countDown[i] = time.Now()
			reply.NReduceId = i
			reply.MapStop = true
			return 
		}
	}
	if !m.reduceDone {
		reply.Wait = true
		reply.MapStop = true
	} else {
		reply.Stop = true
	}
}

func (m *Master) assignMap(args *Args, reply *Reply) {
	for i, file := range m.files {
		if (m.fileStatus[i]==0) || (m.fileStatus[i]==1 && m.countDown[i].Add(10*time.Second).Before(time.Now())) {
			m.countDown[i] = time.Now()
			m.fileStatus[i] = 1
			reply.FileName = file
			reply.FileId = i
			if(args.Id == -1){
				reply.MapId = m.mapId
				m.mapId += 1
			}
			reply.NReduce = m.nReduce
			return
		}
	}
	if !m.mapDone {
		reply.Wait = true
	} else {
		reply.MapStop = true
		m.assignNReduce(reply)
	}
}

func (m *Master) Example(args *Args, reply *Reply) error {
	m.mu.Lock()
	if args.LastFileId == -1 && !m.mapDone {
		m.assignMap(args, reply)
	} else if !m.mapDone {
		if m.fileStatus[args.LastFileId] != 2  {
			m.fileStatus[args.LastFileId] = 2
		}
		if m.allFilesMapped() {
			m.mapDone = true
			reply.MapStop = true
			m.countDown = make([]time.Time, m.nReduce)
			m.assignNReduce(reply)
			defer m.mu.Unlock()
			return nil
		}
		m.assignMap(args, reply)
	} else if !m.reduceDone {
		if (args.LastReduceId != -1) {
			m.nReduceStatus[args.LastReduceId] = 2
			if m.allReducesDone(){
				m.reduceDone = true
				defer m.mu.Unlock()
				return nil
			}
		}
		m.assignNReduce(reply)
	} else {
		reply.Stop = true
	}
	defer m.mu.Unlock()
	return nil
}


//
// start a thread that listens for RPCs from worker.go
//
func (m *Master) server() {
	rpc.Register(m)
	rpc.HandleHTTP()
	//l, e := net.Listen("tcp", ":1234")
	sockname := masterSock()
	os.Remove(sockname)
	l, e := net.Listen("unix", sockname)
	if e != nil {
		log.Fatal("listen error:", e)
	}
	go http.Serve(l, nil)
}

//
// main/mrmaster.go calls Done() periodically to find out
// if the entire job has finished.
//
func (m *Master) Done() bool {

	return m.mapDone && m.reduceDone
}

//
// create a Master.
// main/mrmaster.go calls this function.
// nReduce is the number of reduce tasks to use.
//
func MakeMaster(files []string, nReduce int) *Master {
	m := Master{}

	// Your code here.
	m.files = make([]string, len(files))
	copy(m.files, files)
	m.fileStatus = make([]int, len(files))
	m.nReduceStatus = make([]int, nReduce)
	m.countDown = make([]time.Time, len(files))
	// for i, _ := range m.countDown {
	// 	m.countDown[i] = time.Now().Add(1*time.Hour)
	// }
	m.nReduce = nReduce
	// m.reduceId = 0
	// m.mapDone = false
	// m.reduceDone = false
	// m.mapId = 0

	m.server()
	return &m
}
