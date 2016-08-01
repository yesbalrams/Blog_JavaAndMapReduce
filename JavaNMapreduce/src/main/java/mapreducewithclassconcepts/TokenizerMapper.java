package mapreducewithclassconcepts;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable>{

private final static IntWritable one = new IntWritable(1);
private Text word = new Text();

public void map(Object key, Text value, Context context
             ) throws IOException, InterruptedException {
String[] day_temp=value.toString().split(",");
context.write(new Text(day_temp[0]), new IntWritable(Integer.parseInt(day_temp[1])));
}
}