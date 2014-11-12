# Spark Benchmark Suite (SparkBench) #
## SparkBench - the micro-benchmark suite for Spark ##

---

- Current version: 0.1
- Release data: TBD
- Contact: [Lv Qi](mailto:qi.lv@intel.com), [Grace Huang](mailto:jie.huang@intel.com)
- Homepage: https://github.com/intel-bigdata/Sparkbench

- Contents:
  1. Overview
  2. Getting Started
  3. Running

---
### OVERVIEW ###

This benchmark suite contains 9 typical micro workloads:

  **Spark Core:**

1. Sort (sort)

    This workload sorts its *text* input data, which is generated
    using RandomTextWriter.

2. WordCount (wordcount)

    This workload counts the occurrence of each word in the input
    data, which are generated using RandomTextWriter. It is
    representative of another typical class of real world MapReduce
    jobs - extracting a small amount of interesting data from large
    data set.

3. Sleep (sleep)

    This workload sleep an amount of seconds in each task to verify
    task scheduler.

  **Spark SQL:**

4. Scan (scan)

    Measure the throughput of the SparkSql cluster by query a large
    table and write the result back to HDFS:

    `FROM rankings SELECT *`

5. Join (join)

    Join two large tables with some `WHERE` conditions, `GROUP BY` and
    `ORDER BY` operations:
   
    `SELECT sourceIP, sum(adRevenue) as totalRevenue, avg(pageRank)
    FROM rankings R JOIN (SELECT sourceIP, destURL, adRevenue FROM
    uservisits UV WHERE (datediff(UV.visitDate, '1999-01-01')>=0 AND
    datediff(UV.visitDate, '2000-01-01')<=0)) NUV ON (R.pageURL =
    NUV.destURL) group by sourceIP order by totalRevenue DESC limit 1`

6. Aggregate (aggregation)

   Query large table with `SUM` and `GROUP BY` operations:

   `SELECT sourceIP, SUM(adRevenue) FROM uservisits GROUP BY sourceIP`

  **Spark Graphx:**

7. PageRank (pagerank)

    This workload benchmarks PageRank algorithm implemented in
    Spark-MLLib examples. The data source is generated from Web data
    whose hyperlinks follow the Zipfian distribution.

  **Spark MLLib:**

8. Bayesian Classification (bayes)

    This workload benchmarks NaiveBayesian Classification implemented
    in Spark-MLLib examples.

    Large-scale machine learning is another important use of
    MapReduce. This workload tests the Naive Bayesian (a popular
    classification algorithm for knowledge discovery and data mining)
    trainer in Mahout 0.7, which is an open source (Apache project)
    machine learning library. The workload uses the automatically
    generated documents whose words follow the zipfian
    distribution. The dict used for text generation is also from the
    default linux file /usr/share/dict/linux.words.

9. K-means clustering (kmeans)

    This workload tests the K-means (a well-known clustering algorithm
    for knowledge discovery and data mining) clustering in Mahout
    0.7. The input data set is generated by GenKMeansDataset based on
    Uniform Distribution and Guassian Distribution.

---
### Getting Started ###

2. Prerequisites

  1. Setup HiBench-2.2

      Download/checkout HiBench-2.2 benchmark suite from
      [https://github.com/intel-hadoop/HiBench/zipball/HiBench-2.2](https://github.com/intel-hadoop/HiBench/zipball/HiBench-2.2). Use
      etl-comm branch.

  2. Setup Hadoop

      Before you run any workload in the package, please verify the
      Hadoop framework is running correctly. Currently Hadoop 1.x has
      been tested.

  3. Setup Spark

      `sbt/sbt -Phive assembly`
      
      Please refer to `Possible Issues` to set
      `conf/spark-default.conf` properly.

  4. Setup SparkBench

      Download/checkout SparkBench benchmark suite from
      [https://github.com/intel-bigdata/Sparkbench](https://github.com/Intel-bigdata/Sparkbench/archive/master.zip).

  5. Setup `numpy` in all nodes for Python related MLLib workloads.

2. Configure for the all workloads

    You need to set some global environment variables in the
    `bin/sparkbench-config.sh` file located in the root dir.

          HADOOP_HOME            < The Hadoop installation location >
          HADOOP_CONF_DIR        < The hadoop configuration DIR >
          HADOOP_EXAMPLES_JAR    < The path to hadoop-examples-xxx.jar >
          SPARK_HOME             < The Spark installation location >
          SPARK_CONF_DIR         < The Spark config DIR >
          SPARK_EXAMPLES_JAR     < The path to spark-examples-xxx.jar >
          DICT_PATH              < The dict location >
          DATA_PATH              < The base HDFS path to hold HiBench data >
          SPARKBENCH_REPORT      < The path to SparkBench reports >
          PARALLEL               < The Parallelism of the executions >

    Note:

      1.  SparkBench will guess the value of these variables if they
      are not explicitly set. If so, SparkBench guarantees neither the
      correctness of guess nor the success running of benchmarks.

      2. Do not change the default values of other global environment
      variables unless necessary.

3. Configure each workload

    You can modify the `conf/configure.sh` file under each workload
    folder if it exists. All the data size and options related to the
    workload are defined in this file.

4. Synchronize the time on all nodes (optional but recommended)

5. Build

    You will need to execute `bin/build-all.sh` to build all
    workloads. (Assume `sbt` is installed properly and accessible in
    `$PATH`)

---
### Running ###

- Run several workloads together

  The `conf/benchmarks.lst` file under the package folder defines the
  workloads to run when you execute the `bin/run-all.sh` script under
  the package folder. Each line in the list file specifies one
  workload. You can use `#` at the beginning of each line to skip the
  corresponding bench if necessary.

- Run each workload separately

  You can also run each workload separately. In general, there are 3
  different files under one workload folder.

      conf/configure.sh       Configuration file contains all parameters 
                              such as data size and test options.
      prepare/prepare.sh      Generate or copy the job input data into HDFS.
      java/bin/run.sh         Execute the java workload
      scala/bin/run.sh        Execute the scala workload
      python/bin/run.sh       Execute the python workload
      

  Follow the steps below to run a workload:

  1. Configure the benchmark:

      set your own configurations by modifying `configure.sh` if
      necessary.

  2. Prepare data:

      `prepare/prepare.sh` to prepare input data in HDFS for running the
      benchmark.

  3. Run the benchmark:

      `*/bin/run.sh` to run the corresponding benchmark.

  4. Plot the report:
      
      `${SPARKBENCH}/bin/report_gen_plot.py` to generate report figures.

      Note:
      
        `report_gen_plot.py` requires `python2.x` and `python-matplotlib`.

---
### Possible issues ###

   1. com.esotericsoftware.kryo.KryoException: Buffer overflow....

      MLLib may use KryoSerializer. Add a line or raise the value in
      `conf/spark-defaults.conf`:

       `spark.kryoserializer.buffer.mb  2000`

   2. Exception in thread "main" org.apache.spark.SparkException: Job
   aborted due to stage failure: Task 0 in stage 1.0 failed 4 times,
   most recent failure: Lost task 0.3 in stage 1.0 (TID 6, sr456):
   java.io.EOFException:

       Currently bayies data converter will fail if using
       KryoSerializer. Ensure to use default java serializer in
       `conf/spark-defaults.conf`:

       `spark.closure.serializer  org.apache.spark.serializer.JavaSerializer`