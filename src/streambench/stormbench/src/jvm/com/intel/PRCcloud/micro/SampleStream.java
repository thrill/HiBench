package com.intel.PRCcloud.micro;

import backtype.storm.topology.base.*;
import backtype.storm.topology.*;
import backtype.storm.tuple.*;
import storm.kafka.*;

import com.intel.PRCcloud.*;
import com.intel.PRCcloud.util.*;
import com.intel.PRCcloud.topologies.*;

import java.util.Random;

public class SampleStream extends SingleSpoutTops{

    public SampleStream(StormBenchConfig config){
        super(config);
    }

    public void setBolt(TopologyBuilder builder){
        builder.setBolt("sampleAndPrint",new SampleBolt(config.prob),config.boltThreads).shuffleGrouping("spout");
    }

    public static class SampleBolt extends BaseBasicBolt{

        private double probability;
        private int count=0;
        private ThreadLocal<Random> rand = null;

        public SampleBolt(double prob){
            probability=prob;
            rand = threadRandom(1);
        }

        public void execute(Tuple tuple, BasicOutputCollector collector) {
            double randVal = rand.get().nextDouble();
            if(randVal<=probability){
                count+=1;
                collector.emit(new Values(tuple.getString(0)));
                BenchLogUtil.logMsg("   count:"+count);
            }
        }

        public void declareOutputFields(OutputFieldsDeclarer ofd){
        }
    }

    public static ThreadLocal<Random> threadRandom(final long seed) {
        return new ThreadLocal<Random>(){
            @Override
            protected Random initialValue() {
                return new Random(seed);
            }
        };
    }

}
