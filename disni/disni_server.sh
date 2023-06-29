#!/bin/bash
LD_LIBRARY_PATH=/usr/local/lib java -cp target/disni-2.1-jar-with-dependencies.jar:target/disni-2.1-tests.jar com.ibm.disni.examples.ReadServer -a 10.0.2.2 -p 8000