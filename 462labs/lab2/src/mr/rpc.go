package mr

//
// RPC definitions.
//
// remember to capitalize all names.
//

import "os"
import "strconv"

//
// example to show how to declare the arguments
// and reply for an RPC.
//

type Args struct {
	LastFileId int
	LastReduceId int
	Id int
}

type Reply struct {
	FileName string
	FileId int
	MapStop bool
	Stop bool 
	NReduceId int
	NReduce int
	Wait bool
	MapId int
}

// Add your RPC definitions here.


// Cook up a unique-ish UNIX-domain socket name
// in /var/tmp, for the master.
// Can't use the current directory since
// Athena AFS doesn't support UNIX-domain sockets.
func masterSock() string {
	s := "/var/tmp/824-mr-"
	s += strconv.Itoa(os.Getuid())
	return s
}
