#!/bin/bash
OPPRETTET=false
FILETIME=0
while true; do
   if [ -e "$1" ] && [ "$OPPRETTET" != true ]; then
	echo "Filen $1 ble opprettet!"
	OPPRETTET=true
	FILETIME=`stat -c %Y $1`
   elif [ ! -e "$1"  ] && [ "$OPPRETTET" == true ]; then
	echo "Filen $1 er blitt slettet"
   elif [ -e "$1" ] && [ "$OPPRETTET" == true ]; then
	if [ "$FILETIME" == `stat -c %Y $1` ]; then
            echo "$1 eksisterer"
	else
	    echo "$1 er blitt endret"
	    FILETIME=`stat -c %Y $1`
	fi
   else
	echo "Venter.."
   fi
   sleep $2
done

	
