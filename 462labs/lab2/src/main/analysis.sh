#!/bin/sh

(cd ../mrapps && go build -buildmode=plugin wc.go) || exit 1
(go build $RACE mrmaster.go) || exit 1
(go build $RACE mrworker.go) || exit 1
(go build $RACE mrsequential.go) || exit 1

mc=3
rc=3
while [ $mc -lt  10 ]
do
    rc=3
    while [ $rc -lt 10 ]
    do
        sh test.sh "Top50" $mc $rc  
        sleep 1
        rc=$(( $rc + 1 ))
    done

    mc=$(( $mc + 1 ))
done
#  sh test.sh "Top50" $mc $rc