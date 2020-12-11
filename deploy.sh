#!/bin/bash
PID=$(ps x | grep vitrinevirtual | tail -1 | cut -d" " -f1)
kill -9 $PID
cp ./target/testador-0.0.1-SNAPSHOT.jar /root
nohup java -jar /root/testador-0.0.1-SNAPSHOT.jar & 
