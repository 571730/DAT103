#!/bin/bash
sum=0
echo "Hva er hendelsen?"
read ans
cat $1 | while read line; do
     set -- $line
     if [ "$ans" == "$1" ]; then
	echo $2
	sum=$((sum + $2))
	echo "Sum er $sum"
     fi
done < <(cat $1)
echo "$sum"
