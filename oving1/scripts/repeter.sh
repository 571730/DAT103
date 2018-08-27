#!/bin/bash
COUNTER=0
while [ $COUNTER -lt $1 ]; do
	echo $2
	let COUNTER=COUNTER+1
done
