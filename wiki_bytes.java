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

public class wiki_bytes {

  public static class wiki_bytesMapper
  extends Mapper<Object, Text, Text, IntWritable>{

    public void pagename(){

    }
    public void views(){

    }
    public void bytes(){

    }
    public void title(){

    }
    public void text(){

    }
    public void desired(){

    }
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
      // λ.pair(pagename(Var(1, Log)), bytes(Var(1, Log)))
      while(1) {
        pair (pagename(Var(1, Log)), bytes(Var(1, Log)));
      }
    }
  }
    public static class wiki_bytesReducer
    extends Reducer<Text,IntWritable,Text,IntWritable>{

      public void pagename(){

      }
      public void views(){

      }
      public void bytes(){

      }
      public void title(){

      }
      public void text(){

      }
      public void desired(){

      }
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
        // λ.λ.plus(Var(2, Int), Var(1, Int))
        Integer Var = new Integer();
        while(1) {
          plus (Var(2, Int), Var(1, Int));
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
