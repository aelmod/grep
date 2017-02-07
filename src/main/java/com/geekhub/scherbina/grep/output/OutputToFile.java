package com.geekhub.scherbina.grep.output;

import com.geekhub.scherbina.grep.data.DataProcessor;

public class OutputToFile implements Output {
    private String path;

    public void savePath(String path) {
        this.path = path;
    }

    @Override
    public void write(DataProcessor dataProcessor) {
//        for (Data data : dataProcessor.getDataList()) {
//            File file = new File("path/");
//            try {
//                FileUtils.writeStringToFile(file, data.getData(), "UTF-8");
//            } catch (IOException e) {
//                e.getMessage();
//            }
//        }
    }
}
