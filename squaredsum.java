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

public class squaredsum {

  public static class squaredsumMapper
  extends Mapper<Object, Text, Text, IntWritable>{

    public void zero(){

    }
    public void succ(){

    }
    public void square(){

    }
    public void add(){

    }
    public void fadd(){

    }
    public void div(){

    }
    public void cast(){

    }
    public void round(){

    }
    public void singleton(){

    }
    public void default(){

    }
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
      // λ.square(Var(1, Int))
      Integer Var = new Integer();
      while(1) {
        square (Var(1, Int));
      }
    }
  }
    public static class squaredsumReducer
    extends Reducer<Text,IntWritable,Text,IntWritable>{

      public void zero(){

      }
      public void succ(){

      }
      public void square(){

      }
      public void add(){

      }
      public void fadd(){

      }
      public void div(){

      }
      public void cast(){

      }
      public void round(){

      }
      public void singleton(){

      }
      public void default(){

      }
      public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        // λ.λ.add(Var(2, Int), Var(1, Int))
        Integer Var = new Integer();
        while(1) {
          add (Var(2, Int), Var(1, Int));
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
