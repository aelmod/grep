package com.geekhub.scherbina.grep.source;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class DownloadStrategyByUrl implements DownloadStrategy {
    @Override
    public String getData(String path) {
        String data = null;
        try (InputStream in = new URL(path).openStream()) {
            data = IOUtils.toString(in, charset);
        } catch (IOException e) {
            // TODO: 01.02.17 add exeption
            //e.printStackTrace();
        }
        return data;
    }
}
