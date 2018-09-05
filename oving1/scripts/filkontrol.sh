#!/bin/bash
EKSISTERER=false
FILETIME=0
RUN=true
if [ -e "$1" ]; then
    EKSISTERER=true
    FILETIME=`stat -c %Y $1`
fi
while "$RUN"; do
   sleep $2
   if [ -e "$1" ] && [ "$EKSISTERER" != true ]; then
	echo "Filen $1 ble opprettet!"
	RUN=false
   elif [ ! -e "$1"  ] && [ "$EKSISTERER" == true ]; then
	echo "Filen $1 er blitt slettet"
	RUN=false
   elif [ -e "$1" ] && [ "$EKSISTERER" == true ]; then
	if [ "$FILETIME" == `stat -c %Y $1` ]; then
            echo "$1 eksisterer"
	else
	    echo "$1 er blitt endret"
	    FILETIME=`stat -c %Y $1`
	    RUN=false
	fi
   else
	echo "Venter.."
   fi
done

	
