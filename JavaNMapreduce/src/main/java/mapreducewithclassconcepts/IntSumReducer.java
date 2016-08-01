package mapreducewithclassconcepts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class IntSumReducer extends Reducer<Text,IntWritable,Text,Text> {
    

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
      
