package mapreducewitharray.Arrays;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MinTemperature {

  public static class TokenizerMapper
       extends Mapper<Object, Text, Text, IntWritable>{

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
      String[] day_temp=value.toString().split(",");
      context.write(new Text(day_temp[0]), new IntWritable(Integer.parseInt(day_temp[1])));
    }
  }

  public static class IntSumReducer extends Reducer<Text,IntWritable,Text,Text> {
    

    public void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException {
      
      ArrayList<Integer> sorted=new ArrayList<Integer>();
     
      for (IntWritable val : values) {
        
        sorted.add(val.get());
      }
      Collections.sort(sorted);
      
      int[] top5_cold_days=new int[5];
	      for (int i=0;i<top5_cold_days.length;i++)
	      {
	    	  top5_cold_days[i]=sorted.get(i);
	      }
	    
	    String temp="";
	     
	    for (int i=0;i<top5_cold_days.length;i++)
	     {
	    	 temp=temp+top5_cold_days[i]+"\t";
	     }
	     context.write(key, new Text(temp));
      }
      
    }
  

  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, "word count");
    job.setJarByClass(MinTemperature.class);
    job.setMapperClass(TokenizerMapper.class);
    job.setReducerClass(IntSumReducer.class);
    job.setMapOutputKeyClass(Text.class);
    job.setMapOutputValueClass(IntWritable.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(Text.class);
    Path Output= new Path("/home/abhaymise/Downloads/temperature.out");
    if (FileSystem.get(conf).exists(Output))
    {
    	System.out.println("Output path"+Output.toUri() +" exists. Deleting it ...");
    	FileSystem.get(conf).delete(Output);
    }
    FileInputFormat.addInputPath(job, new Path("/home/abhaymise/Downloads/temperature.csv"));
    FileOutputFormat.setOutputPath(job, Output);
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}