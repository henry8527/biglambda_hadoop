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

public class selection {

  public static class selectionMapper
  extends Mapper<Object, Text, Text, IntWritable>{

    public void filt(){

    }
    public void m(){

    }
    public void pair(){

    }
    public void one(){

    }
    public void add(){

    }
    public void append(){

    }
    public void to_items(){

    }
    public void to_name(){

    }
    public void access(){

    }
    public void has_val(){

    }
    public void KEY(){

    }
    public void VALUE(){

    }
    public void concat_db(){

    }
    public void emit_item(){

    }
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
      // λ.Var(1, Database)
      while(1) {
        Var (1, Database);
      }
    }
  }
    public static class selectionReducer
    extends Reducer<Text,IntWritable,Text,IntWritable>{

      public void filt(){

      }
      public void m(){

      }
      public void pair(){

      }
      public void one(){

      }
      public void add(){

      }
      public void append(){

      }
      public void to_items(){

      }
      public void to_name(){

      }
      public void access(){

      }
      public void has_val(){

      }
      public void KEY(){

      }
      public void VALUE(){

      }
      public void concat_db(){

      }
      public void emit_item(){

      }
      public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        // λ.λ.filt(λ.Var(1, Bool), Var(2, [Bool]))
        while(1) {
          Var (1, Bool);
        }
        while(1) {
          filt (Var_result, Var(2, [Bool]));
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
