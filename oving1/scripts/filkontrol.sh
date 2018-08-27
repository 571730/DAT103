#!/bin/bash
RUN=true
OPPRETTET=false
while [$RUN] do
	sleep $2
	if[-e $1 == 0] && [$OPPRETTET != true]
	then
		echo "Filen ble opprettet!"
		$OPPRETTET=true
	elif [-e $1 -gt 0] && [$OPPRETTET == true]
	then
		echo "Filen er blitt slettet"
	else
		echo "Venter.."
	fi
done

	
