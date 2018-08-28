#!/bin/bash
RUN=true
SUM=0
re='^[0-9]+$'
while "$RUN"; do
    read ans
    if ! [[ "$ans" =~ $re ]]; then
	echo $SUM
	RUN=false        
    else
	SUM=$((SUM + $ans))
    fi
done
