// Import java standard library
import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;
import java.net.*;
import java.swing.*;
// Import hadoop mapreduce library
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.lib.output.FileOutputFormat;

public class wordcount {

  public static class wordcountMapper
  extends Mapper<Object, Text, Text, IntWritable>{

    public void split(){

    }
    public void m(){

    }
    public void pair(){

    }
    public void one(){

    }
    public void plus(){

    }
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
      // λ.m(λ.pair(Var(1, String), one()), split(Var(1, String)))
      String Var = new String();
      while(1) {
        pair (Var(1, String), one());
      }
      String Var = new String();
      while(1) {
        m (pair_result, split(Var(1, String)));
      }
    }
  }
    public static class wordcountReducer
    extends Reducer<Text,IntWritable,Text,IntWritable>{

      public void split(){

      }
      public void m(){

      }
      public void pair(){

      }
      public void one(){

      }
      public void plus(){

      }
      public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        // λ.λ.plus(one(), Var(2, Int))
        Integer Var = new Integer();
        while(1) {
          plus (one(), Var(2, Int));
        }
      }
    }
    public static void main(String[] args) throws Exception {
      Configuration conf = new Configuration();
      Job job = Job.getInstance(conf, );
      job.setJarByClass();
      job.setMapperClass();
      job.setCombinerClass();
      job.setReducerClass();
      job.setOutputKeyClass();
      job.setOutputValueClass();
      FileInputFormat.addInputPath(job, new Path(args[0]));
      FileOutputFormat.setOutputPath(job, new Path(args[1]));
      System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
  }
