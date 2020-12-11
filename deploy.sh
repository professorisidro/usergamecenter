#!/bin/bash
PID=$(ps x | grep gamecenter | tail -1 | cut -d" " -f1)
kill -9 $PID
cp ./target/gamecenter-0.0.1-SNAPSHOT.jar /root
nohup java -jar /root/gamecenter-0.0.1-SNAPSHOT.jar & 
