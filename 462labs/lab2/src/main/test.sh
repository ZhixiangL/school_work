#!/bin/sh

rm -rf mr-tmp
mkdir mr-tmp || exit 1
cd mr-tmp || exit 1
rm -f mr-*
# if [ $2 -eq 1 ]
# then
#     (../mrsequential ../../mrapps/wc.so ../PublicDomain/$1/* || exit 1) > ../results/$1-$2-$3
#     sort mr-out-0 > mr-correct-wc.txt
#     rm -f mr-out*
# fi

COUNT=0

(timeout -k 2s 180s ../mrmaster ../PublicDomain/$1/* $3 &
sleep 1
while [ $COUNT -lt $2 ]
do
    timeout -k 2s 180s ../mrworker ../../mrapps/wc.so &
    COUNT=$(( $COUNT + 1 ))
done
COUNT=0
while [ $COUNT -lt $2 ]
do
    wait;
    COUNT=$(( $COUNT + 1 ))
done
wait;
) > ../results/$1-$2-$3

(echo "\nInput files:" 
du -sch ../PublicDomain/$1 
echo "\nIntermediate files:" 
du -sch ../mr-tmp/mr-[0-9]-*) >> ../results/$1-$2-$3