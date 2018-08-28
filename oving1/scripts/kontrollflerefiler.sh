#!/bin/bash
for i in $*; do
  ./filkontrol.sh $i 60 &
done
