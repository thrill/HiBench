#!/usr/bin/env python2
# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

"""
Mapping from properties to environment variable names
"""
HiBenchEnvPropMappingMandatory=dict(
    JAVA_BIN="java.bin",
    HADOOP_HOME="hibench.hadoop.home",
    SPARK_HOME="hibench.spark.home",
    HDFS_MASTER="hibench.hdfs.master",
    SPARK_MASTER="hibench.spark.master",
    HADOOP_VERSION="hibench.hadoop.version",       
    HADOOP_RELEASE="hibench.hadoop.release",        
    HADOOP_EXAMPLES_JAR="hibench.hadoop.examples.jar", 
    HADOOP_EXECUTABLE="hibench.hadoop.executable", 
    HADOOP_CONF_DIR="hibench.hadoop.configure.dir",
    SPARK_VERSION="hibench.spark.version",
    HIBENCH_HOME="hibench.home",
    HIBENCH_CONF="hibench.configure.dir", 

    DEPENDENCY_DIR="hibench.dependency.dir",
    REPORT_COLUMN_FORMATS="hibench.report.formats",
    SPARKBENCH_JAR="hibench.sparkbench.jar",
    HIBENCH_PYTHON_PATH="hibench.sparkbench.python.dir",
    NUM_MAPS="hibench.default.map.parallelism",
    NUM_REDS="hibench.default.shuffle.parallelism",
    INPUT_HDFS="hibench.workload.input",
    OUTPUT_HDFS="hibench.workload.output",

    REDUCER_CONFIG_NAME="hibench.hadoop.reducer.name",
    MAP_CONFIG_NAME="hibench.hadoop.mapper.name",
    COMPRESS_OPT="hibench.workload.compress.options",
    DATATOOLS_COMPRESS_OPT="hibench.workload.compress.datatools.options",
    KMEANS_COMPRESS_OPT="hibench.workload.compress.kmeans_gen.options",
    HIVE_SQL_COMPRESS_OPTS="hibench.workload.compress.hive.options",

    MASTERS="hibench.masters.hostnames",
    SLAVES="hibench.slaves.hostnames",
    )

HiBenchEnvPropMapping=dict(
    SPARK_EXAMPLES_JAR="hibench.spark.examples.jar",

    HIVE_HOME="hibench.hive.home",
    HIVE_RELEASE="hibench.hive.release",
    HIVEBENCH_TEMPLATE="hibench.hivebench.template.dir",
    MAHOUT_HOME="hibench.mahout.home",
    MAHOUT_RELEASE="hibench.mahout.release",
    NUTCH_HOME="hibench.nutch.home",
    NUTCH_BASE_HDFS="hibench.nutch.base.hdfs",
    NUTCH_INPUT="hibench.nutch.dir.name.input",
    NUTCH_DIR="hibench.nutch.nutchindexing.dir",
    HIBENCH_REPORT="hibench.report.dir", # set in default
    HIBENCH_REPORT_NAME="hibench.report.name", # set in default
    YARN_NUM_EXECUTORS="hibench.yarn.executor.num",
    YARN_EXECUTOR_CORES="hibench.yarn.executor.cores",
    YARN_EXECUTOR_MEMORY="hibench.yarn.executor.memory",
    YARN_DRIVER_MEMORY="hibench.yarn.driver.memory",
    DATA_HDFS="hibench.hdfs.data.dir",
    # For Sleep workload
    MAP_SLEEP_TIME="hibench.sleep.mapper.seconds",
    RED_SLEEP_TIME="hibench.sleep.reducer.seconds",
    HADOOP_SLEEP_JAR="hibench.sleep.job.jar",
    # For Sort, Terasort, Wordcount
    DATASIZE="hibench.workload.datasize",
    BYTES_TOTAL_NAME="hibench.randomtextwriter.bytestotal.name",

    # For hive related workload, data scale
    PAGES="hibench.workload.pages",
    USERVISITS="hibench.workload.uservisits",
    HIVE_INPUT="hibench.hive.dir.name.input",
    HIVE_BASE_HDFS="hibench.hive.base.hdfs",
    # For bayes
    CLASSES="hibench.workload.classes",
    BAYES_INPUT="hibench.bayes.dir.name.input",
    DATATOOLS="hibench.hibench.datatool.dir",
    BAYES_BASE_HDFS="hibench.bayes.base.hdfs",
    NGRAMS="hibench.bayes.ngrams",
    # For kmeans
    INPUT_SAMPLE="hibench.kmeans.input.sample",
    INPUT_CLUSTER="hibench.kmeans.input.cluster",
    NUM_OF_CLUSTERS="hibench.kmeans.num_of_clusters",
    NUM_OF_SAMPLES="hibench.kmeans.num_of_samples",
    SAMPLES_PER_INPUTFILE="hibench.kmeans.samples_per_inputfile",
    DIMENSIONS="hibench.kmeans.dimensions",
    MAX_ITERATION="hibench.kmeans.max_iteration",
    K="hibench.kmeans.k",
    # For Pagerank
    PAGERANK_BASE_HDFS="hibench.pagerank.base.hdfs",
    PAGERANK_INPUT="hibench.pagerank.dir.name.input",
    BLOCK="hibench.pagerank.block",
    NUM_ITERATIONS="hibench.pagerank.num_iterations",
    PEGASUS_JAR="hibench.pagerank.pegasus.dir",
    # For DFSIOE
    RD_NUM_OF_FILES="hibench.dfsioe.read.number_of_files",
    RD_FILE_SIZE="hibench.dfsioe.read.file_size",
    WT_NUM_OF_FILES="hibench.dfsioe.write.number_of_files",
    WT_FILE_SIZE="hibench.dfsioe.write.file_size",
    MAP_JAVA_OPTS="hibench.dfsioe.map.java_opts",
    RED_JAVA_OPTS="hibench.dfsioe.red.java_opts",

    # For streaming bench
    # prepare
    STREAMING_DATA_SCALE_FACTOR="hibench.streamingbench.datagen.scale_factor",
    STREAMING_DATA_DIR="hibench.streamingbench.datagen.dir",
    STREAMING_DATA1_NAME="hibench.streamingbench.datagen.data1.name",
    STREAMING_DATA1_DIR="hibench.streamingbench.datagen.data1.dir",
    STREAMING_DATA1_LENGTH="hibench.streamingbench.datagen.data1.length",
    STREAMING_DATA2_SAMPLE_DIR="hibench.streamingbench.datagen.data2_samples.dir",
    STREAMING_DATA2_CLUSTER_DIR="hibench.streamingbench.datagen.data2_cluster.dir",
    
    
#    app="hibench.streamingbench.app",
#    textdataset_recordsize_factor="hibench.streamingbench.prepare.textdataset_recordsize_factor",
#    mode="hibench.streamingbench.prepare.mode",
#    records="hibench.streamingbench.prepare.push.records",
#    recordPerInterval="hibench.streamingbench.prepare.periodic.recordPerInterval",
#    intervalSpan="hibench.streamingbench.prepare.periodic.intervalSpan",
#    totalRound="hibench.streamingbench.prepare.periodic.totalRound",

    # sparkstreaming
    STREAMINGBENCH_JARS="hibench.streamingbench.jars",
    STREAMBENCH_STORM_JAR="hibench.streamingbench.stormbench.jar",
    STORM_BIN_HOME="hibench.streamingbench.storm.home",
#    zkHost="hibench.streamingbench.zookeeper.host",
#    receiverNodes="hibench.streamingbench.receiver_nodes",
    # benchName="hibench.streamingbench.benchname",
    # topicName="hibench.streamingbench.topic_name",
    # batchInterval="hibench.streamingbench.batch_interval",
    # consumerGroup="hibench.streamingbench.consumer_group",
    # recordCount="hibench.streamingbench.record_count",

    # fieldIndex="hibench.streamingbench.field_index",
    # separator="hibench.streamingbench.separator",
    # prob="hibench.streamingbench.prob",
    # pattern="hibench.streamingbench.pattern",
    # copies="hibench.streamingbench.copies",
    # testWAL="hibench.streamingbench.testWAL",
    # checkpointPath="hibench.streamingbench.checkpoint_path",
    # debug="hibench.streamingbench.debug",
    # directMode="hibench.streamingbench.direct_mode",
    # brokerList="hibench.streamingbench.broker_list_with_quote",

    # prepare
    # nimbus="hibench.streamingbench.storm.nimbus",
    # nimbusAPIPort="hibench.streamingbench.storm.nimbusAPIPort",
    # nimbusContactInterval="hibench.streamingbench.storm.nimbusContactInterval",
    # workerCount="hibench.streamingbench.storm.worker_count",
    # spoutThreads="hibench.streamingbench.storm.spout_threads",
    # boltThreads="hibench.streamingbench.storm.bolt_threads",
    # readFromStart="hibench.streamingbench.storm.read_from_start",
    # ackon="hibench.streamingbench.storm.ackon",
#    consumer="hibench.streamingbench.storm.consumer",
    # consumer="hibench.streamingbench.consumer_group",
    
    )

HiBenchPropEnvMapping=dict([(v,k) for k, v in HiBenchEnvPropMapping.items()])
HiBenchPropEnvMappingMandatory=dict([(v,k) for k, v in HiBenchEnvPropMappingMandatory.items()])
