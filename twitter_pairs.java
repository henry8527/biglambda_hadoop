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

public class twitter_pairs {

  public static class twitter_pairsMapper
  extends Mapper<Object, Text, Text, IntWritable>{

    public void hashtag(){

    }
    public void match(){

    }
    public void find_matches(){

    }
    public void pair(){

    }
    public void zero(){

    }
    public void one(){

    }
    public void append(){

    }
    public void split(){

    }
    public void plus(){

    }
    public void m(){

    }
    public void perms(){

    }
    public void canonical(){

    }
    public void filt(){

    }
    public void emit(){

    }
    public void fst(){

    }
    public void snd(){

    }
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
      // λ.hashtag()
      while(1) {
        hashtag ();
      }
    }
  }
    public static class twitter_pairsReducer
    extends Reducer<Text,IntWritable,Text,IntWritable>{

      public void hashtag(){

      }
      public void match(){

      }
      public void find_matches(){

      }
      public void pair(){

      }
      public void zero(){

      }
      public void one(){

      }
      public void append(){

      }
      public void split(){

      }
      public void plus(){

      }
      public void m(){

      }
      public void perms(){

      }
      public void canonical(){

      }
      public void filt(){

      }
      public void emit(){

      }
      public void fst(){

      }
      public void snd(){

      }
      public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        // λ.λ.pair(hashtag(), one())
        while(1) {
          pair (hashtag(), one());
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
