#!/bin/sh

REQUESTS_PER_SECOND=$1
REQUEST_URL=$3

for i in {1..1000}
do 
	TIME=$(date +%s)
	curl -X $METHOD $REQUEST_URL -d message="$TIME"
	SLEEP_INCREMENT=
done
