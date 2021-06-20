package main

//
// start the master process, which is implemented
// in ../mr/master.go
//
// go run mrmaster.go pg*.txt
//
// Please do not change this file.
//

import "../mr"
import "time"
import "os"
import "fmt"
import "strconv"

func main() {
	if len(os.Args) < 2 {
		fmt.Fprintf(os.Stderr, "Usage: mrmaster inputfiles...\n")
		os.Exit(1)
	}
	nReduce, _ := strconv.Atoi(os.Args[len(os.Args)-1])
	m := mr.MakeMaster(os.Args[1:len(os.Args)-1], nReduce)
	for m.Done() == false {
		time.Sleep(time.Second)
	}

	time.Sleep(time.Second)
}
