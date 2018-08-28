#!/bin/bash

sum=0
file="$1"
echo "Hva er hendelsen?"
read ans
while IFS= read line
do
	set -- $line
	if [ "$ans" == "$1" ]; then
		sum=$((sum + $2))
	fi
done <"$file"
echo "$sum" 
