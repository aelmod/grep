package com.geekhub.scherbina.grep.source;

import com.geekhub.scherbina.grep.exceptions.BadPathException;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataDownloaderTest {
    @Test
    public void DownloadStrategyByFileTest() throws BadPathException {
        String data = new DataDownloader().getDataUsingStrategies("/home/aelmod/test2.txt").getData();
        assertEquals("rdp\n", data);
    }

    @Test
    public void DownloadStrategyByUrlTest() throws BadPathException {
        String data = new DataDownloader().getDataUsingStrategies("http://pastebin.com/raw/8jBNAqUK").getData();
        assertEquals("test text", data);
    }
    @Test(expected = BadPathException.class)
    public void DownloadStrategyExceptionTest() throws BadPathException {
        new DataDownloader().getDataUsingStrategies("?lol?");
    }
}