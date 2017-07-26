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

public class grep {

  public static class grepMapper
  extends Mapper<Object, Text, Text, IntWritable>{

    public void word_split(){

    }
    public void PATTERN(){

    }
    public void p_filter(){

    }
    public void append(){

    }
    public void emit(){

    }
    public void m(){

    }
    public void one(){

    }
    public void pair(){

    }
    public void plus(){

    }
    public void is_zero(){

    }
    public void length(){

    }
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
      // λ.word_split(Var(1, String))
      String Var = new String();
      while(1) {
        word_split (Var(1, String));
      }
    }
  }
    public static class grepReducer
    extends Reducer<Text,IntWritable,Text,IntWritable>{

      public void word_split(){

      }
      public void PATTERN(){

      }
      public void p_filter(){

      }
      public void append(){

      }
      public void emit(){

      }
      public void m(){

      }
      public void one(){

      }
      public void pair(){

      }
      public void plus(){

      }
      public void is_zero(){

      }
      public void length(){

      }
      public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        // λ.λ.p_filter(λ.PATTERN(Var(1, String)), append(Var(2, [String]), Var(1, [String])))
        String Var = new String();
        while(1) {
          PATTERN (Var(1, String));
        }
        String Var = new String();
        while(1) {
          p_filter (PATTERN_result, append(Var(2, [String]), Var(1, [String])));
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
