package com.geekhub.scherbina.grep.source;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class DownloadStrategyByFile implements DownloadStrategy {
    @Override
    public String getData(String path) {
        File file = new File(path);
        String fileData = null;
        try {
            fileData = FileUtils.readFileToString(file, charset);
        } catch (IOException e) {
            // TODO: 01.02.17 add exeption
            //e.printStackTrace();
        }
        return fileData;
    }
}
