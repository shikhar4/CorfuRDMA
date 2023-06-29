#!/bin/bash
set -e
# mvn -DskipTests package
LD_LIBRARY_PATH=/usr/local/lib ./bin/corfu_server -ms 9000 --rdma-host=10.0.2.2 --rdma-port=8000
