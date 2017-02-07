package com.geekhub.scherbina.grep;

import com.geekhub.scherbina.grep.data.Data;
import com.geekhub.scherbina.grep.data.DataProcessor;
import com.geekhub.scherbina.grep.exceptions.BadPathException;
import com.geekhub.scherbina.grep.source.DataDownloader;
import com.geekhub.scherbina.grep.source.DownloadStrategy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class MatcherTest {
    @Test
    public void MatcherWithWordTest() throws BadPathException {
        Data data = new Data("test", "/home/asd.txt");
        String[] words = new String[1];
        words[0] = "test";

        DataProcessor dataProcessor = new DataProcessor();
        dataProcessor.addData(data);
        DataProcessor start = new Matcher(dataProcessor, words, new ArrayList<>()).start();
        for (Data data1 : start.getDataList()) {
            assertEquals("#test#", data1.getData());
        }
    }
    @Test
    public void MatcherWithPatternTest() throws BadPathException {
        Data data = new Data("testpatt", "/home/asd.txt");
        String[] words = new String[0];

        DataProcessor dataProcessor = new DataProcessor();
        dataProcessor.addData(data);

        ArrayList<Pattern> patterns = new ArrayList<>();
        patterns.add(Pattern.compile("testpatt"));

        DataProcessor start = new Matcher(dataProcessor, words, patterns).start();
        for (Data data1 : start.getDataList()) {
            assertEquals("#testpatt#", data1.getData());
        }
    }

}