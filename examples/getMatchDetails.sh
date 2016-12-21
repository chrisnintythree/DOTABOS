#!/bin/bash 

cd $(dirname $0)

echo "Getting Repalys"
node example.js $VAR >> test/match_$VAR.txt & PID=$!
  #sleep 10
  #kill $PID
