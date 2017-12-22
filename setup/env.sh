#!/bin/bash -x

export PYTHON_VERSION=2.7
export JDK_VERSION=8
export SCALA_VERSION=2.12.4
export MAVEN_VERSION=3.5.2
export HADOOP_VERSION_DETAIL=2.7.5
export SPARK_VERSION_DETAIL=2.2.1
export HADOOP_FOR_SPARK_VERSION=2.7
export FLINK_VERSION_DETAIL=1.4.0
export HADOOP_FOR_FLINK_VERSION=26
export SCALA_FOR_FLINK_VERSION=2.11

export JAVA_HOME=/usr
export PATH=$PATH:$JAVA_HOME/bin

export SCALA_HOME=$HOME/local/scala
export PATH=$PATH:$SCALA_HOME/bin

export M2_HOME=$HOME/local/apache-maven
export PATH=$PATH:$M2_HOME/bin

export HADOOP_HOME=$HOME/local/hadoop-${HADOOP_VERSION_DETAIL}
export HADOOP_PREFIX=$HOME/local/hadoop-${HADOOP_VERSION_DETAIL}
export HADOOP_CONF_DIR=${HADOOP_HOME}/etc/hadoop/

export HADOOP_INSTALL=$HADOOP_HOME
export PATH=$PATH:$HADOOP_INSTALL/bin
export PATH=$PATH:$HADOOP_INSTALL/sbin

export HADOOP_MAPRED_HOME=$HADOOP_INSTALL
export HADOOP_COMMON_HOME=$HADOOP_INSTALL
export HADOOP_HDFS_HOME=$HADOOP_INSTALL
export YARN_HOME=$HADOOP_INSTALL
export HADOOP_COMMON_LIB_NATIVE_DIR=$HADOOP_INSTALL/lib/native
export HADOOP_OPTS="-Djava.library.path=$HADOOP_INSTALL/lib/native"

export SPARK_HOME=$HOME/local/spark-${SPARK_VERSION_DETAIL}
export SPARK_MASTER_IP=localhost

export FLINK_HOME=$HOME/local/flink-${FLINK_VERSION_DETAIL}
export PATH=$PATH:$FLINK_HOME/bin

export THRILL_HOME=$HOME/thrill
