#!/bin/bash
set -e
# mvn -DskipTests package
LD_LIBRARY_PATH=/usr/local/lib java -cp samples/target/samples-0.4.0-SNAPSHOT-shaded.jar org.corfudb.samples.HelloCorfu -c localhost:9000
