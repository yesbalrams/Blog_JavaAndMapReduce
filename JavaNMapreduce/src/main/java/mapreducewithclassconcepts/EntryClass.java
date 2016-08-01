package mapreducewithclassconcepts;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class EntryClass {
	
	  public static void main(String[] args) throws Exception {
		    Configuration conf = new Configuration();
		    Job job = Job.getInstance(conf, "word count");
		    job.setJarByClass(EntryClass.class);
		    job.setMapperClass(TokenizerMapper.class);
		    job.setReducerClass(IntSumReducer.class);
		    job.setMapOutputKeyClass(Text.class);
		    job.setMapOutputValueClass(IntWritable.class);
		    job.setOutputKeyClass(Text.class);
		    job.setOutputValueClass(Text.class);
		    Path Output= new Path("/home/abhay/Downloads/temperature.out");
		    if (FileSystem.get(conf).exists(Output))
		    {
		    	System.out.println("Output path"+Output.toUri() +" exists. Deleting it ...");
		    	FileSystem.get(conf).delete(Output);
		    }
		    FileInputFormat.addInputPath(job, new Path("/home/abhay/Downloads/temperature.csv"));
		    FileOutputFormat.setOutputPath(job, Output);
		    System.exit(job.waitForCompletion(true) ? 0 : 1);
		  }

}
