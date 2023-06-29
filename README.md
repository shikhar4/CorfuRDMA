# CorfuRDMA

## Setup

1. Build DiSNI according to [DiSNI README](disni/README.md).


2. Build Corfu with RDMA

```
mvn package -DskipTests
```

3. Start Corfu Server with RDMA endpoints


```
LD_LIBRARY_PATH=/usr/local/lib ./bin/corfu_server -ms 9000 --rdma-host=10.0.2.2 --rdma-port=8000
```

4. Run Corfu applications

```
LD_LIBRARY_PATH=/usr/local/lib java -cp samples/target/samples-0.4.0-SNAPSHOT-shaded.jar org.corfudb.samples.HelloCorfu -c localhost:9000
```
