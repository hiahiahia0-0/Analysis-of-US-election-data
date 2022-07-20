package com.nd.aoue.analyzer.reducer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class OccupationPartyReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        //统计各党派支持
        int OccupationAmount=0;
        for (Text value : values) {
            int amount=(int)Float.parseFloat(value.toString());
            OccupationAmount+=amount;
        }
        System.out.println(key + "_" + OccupationAmount);

        context.write(key,new Text(key + "_" + OccupationAmount));
    }
}
