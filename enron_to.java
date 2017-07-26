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

public class enron_to {

  public static class enron_toMapper
  extends Mapper<Object, Text, Text, IntWritable>{

    public void get_lines(){

    }
    public void get_selector(){

    }
    public void extract_line(){

    }
    public void from_tag(){

    }
    public void to_tag(){

    }
    public void extract_tagged(){

    }
    public void pair(){

    }
    public void add(){

    }
    public void one(){

    }
    public void m(){

    }
    public void filt(){

    }
    public void append(){

    }
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
      // λ.pair(extract_tagged(extract_line(Var(1, Email), to_tag()), to_tag()), one())
      while(1) {
        pair (extract_tagged(extract_line(Var(1, Email), to_tag()), to_tag()), one());
      }
    }
  }
    public static class enron_toReducer
    extends Reducer<Text,IntWritable,Text,IntWritable>{

      public void get_lines(){

      }
      public void get_selector(){

      }
      public void extract_line(){

      }
      public void from_tag(){

      }
      public void to_tag(){

      }
      public void extract_tagged(){

      }
      public void pair(){

      }
      public void add(){

      }
      public void one(){

      }
      public void m(){

      }
      public void filt(){

      }
      public void append(){

      }
      public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        // λ.λ.add(one(), Var(2, Int))
        Integer Var = new Integer();
        while(1) {
          add (one(), Var(2, Int));
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
