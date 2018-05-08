#!/usr/bin/env bash
#set -ex
jarFileName="testbigdata_2.11-1.0.jar"
runCommond="hadoop jar /root/testbigdata_2.11-1.0.jar FileSystemDoubleCat /user/data/note.txt"

echo "[info] Packaging ..."
sbt package

echo "[info] Copy jar file ..."
docker exec sandbox-hdp rm root/${jarFileName}
docker cp ./target/scala-2.11/${jarFileName} sandbox-hdp:/root/
echo "[info] Copy ${jarFileName} to [sandbox-hdp:/root/] - DONE"

echo "[info] Execute Command ${runCommond}"
docker exec sandbox-hdp ${runCommond}

