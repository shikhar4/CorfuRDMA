#!/bin/bash
LD_LIBRARY_PATH=/usr/local/lib java -cp target/darpc-1.9-jar-with-dependencies.jar:target/darpc-1.9-tests.jar com.ibm.darpc.examples.client.DaRPCClient -a 10.0.2.2