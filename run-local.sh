#!/usr/bin/env bash
#set -ex

echo "[info] Packaging ..."
sbt package

echo "[info] Copy jar file ..."
docker cp ./target/scala-2.11/testbigdata_2.11-1.0.jar sandbox-hdp:/root/
echo "[info] Copy to [sandbox-hdp:/root/] - DONE"