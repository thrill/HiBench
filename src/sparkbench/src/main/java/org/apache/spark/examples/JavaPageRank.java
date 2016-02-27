/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Copied from org.apache.spark.examples.JavaPageRank
 * Modification from origin:
 *    Use saveAsText instead of print to present the result. See the commented
 * code at the tail of the code.
 */
package org.apache.spark.examples;

import com.intel.sparkbench.IOCommon;
import scala.Tuple2;

import com.google.common.collect.Iterables;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFlatMapFunction;
import org.apache.spark.api.java.function.PairFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Computes the PageRank of URLs from an input file. Input file should
 * be in format of:
 * URL         neighbor URL
 * URL         neighbor URL
 * URL         neighbor URL
 * ...
 * where URL and their neighbors are separated by space(s).
 */
public final class JavaPageRank {
  private static final Pattern SPACES = Pattern.compile("\\s+");

  private static class Sum implements Function2<Double, Double, Double> {
    @Override
    public Double call(Double a, Double b) {
      return a + b;
    }
  }

  public static void main(String[] args) throws Exception {
    if (args.length < 3) {
      System.err.println("Usage: JavaPageRank <num_pages> <input_file> <output_file> <number_of_iterations>");
      System.exit(1);
    }

    SparkConf sparkConf = new SparkConf().setAppName("JavaPageRank");
    JavaSparkContext ctx = new JavaSparkContext(sparkConf);

    final long numPages = Long.parseLong(args[0]);

    // Loads in input file. It should be in format of:
    //     URL         neighbor URL
    //     URL         neighbor URL
    //     URL         neighbor URL
    //     ...
    JavaRDD<String> lines = ctx.textFile(args[1], 1);

    // Loads all URLs from input file and initialize their neighbors.
    JavaPairRDD<Long, Iterable<Long>> links
        = lines.mapToPair(new PairFunction<String, Long, Long>() {
      @Override
      public Tuple2<Long, Long> call(String s) {
        String[] parts = SPACES.split(s);
        return new Tuple2<Long, Long>(Long.parseLong(parts[parts.length-2]),
                                      Long.parseLong(parts[parts.length-1]));
      }
    }).groupByKey().cache();

    // Loads all URLs with other URL(s) link to from input file and initialize
    // ranks of them to one / n.
    JavaPairRDD<Long, Double> ranks = links
        .mapValues(new Function<Iterable<Long>, Double>() {
      @Override
      public Double call(Iterable<Long> rs) {
        return 1.0d / numPages;
      }
    });

    assert(ranks.count() == numPages);

    // Calculates and updates URL ranks continuously using PageRank algorithm.
    for (int current = 0; current < Integer.parseInt(args[3]); current++) {
      // Calculates URL contributions to the rank of other URLs.
      JavaPairRDD<Long, Double> contribs = links.join(ranks).values()
        .flatMapToPair(new PairFlatMapFunction<Tuple2<Iterable<Long>, Double>, Long, Double>() {
          @Override
          public Iterable<Tuple2<Long, Double>> call(Tuple2<Iterable<Long>, Double> s) {
            int urlCount = Iterables.size(s._1);
            List<Tuple2<Long, Double>> results = new ArrayList<Tuple2<Long, Double>>();
            for (Long n : s._1) {
              results.add(new Tuple2<Long, Double>(n, s._2() / urlCount));
            }
            return results;
          }
      });

      // Re-calculates URL ranks based on neighbor contributions.
      ranks = contribs.reduceByKey(new Sum()).mapValues(new Function<Double, Double>() {
        @Override
        public Double call(Double sum) {
          return sum * 0.85 + 0.15 / numPages;
        }
      });
    }

    // Collects all URL ranks and dump them to console.
//    List<Tuple2<String, Double>> output = ranks.collect();
//    for (Tuple2<?,?> tuple : output) {
//        System.out.println(tuple._1() + " has rank: " + tuple._2() + ".");
//    }

    //IOCommon io = new IOCommon(JavaSparkContext.toSparkContext(ctx));
    //io.save(args[1], ranks.rdd());
    ranks.saveAsTextFile(args[2]);

    ctx.stop();
  }
}
