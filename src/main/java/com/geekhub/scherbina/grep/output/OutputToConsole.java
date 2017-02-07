package com.geekhub.scherbina.grep.output;

import com.geekhub.scherbina.grep.data.Data;
import com.geekhub.scherbina.grep.data.DataProcessor;

// TODO: 07.02.17 need rework
public class OutputToConsole implements Output {
    @Override
    public void write(DataProcessor dataProcessor) {
        for (Data data : dataProcessor.getDataList()) {
            System.out.println("Path: " + data.getLocation() + "\n");
            System.out.println(data.getData());
        }
    }
}
