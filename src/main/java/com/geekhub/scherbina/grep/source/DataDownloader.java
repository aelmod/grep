package com.geekhub.scherbina.grep.source;

import com.geekhub.scherbina.grep.data.Data;
import com.geekhub.scherbina.grep.exceptions.BadPathException;

import java.util.ArrayList;
import java.util.List;

public class DataDownloader {
    private List<Class<? extends DownloadStrategy>> downloadStrategies = new ArrayList<>();

    public DataDownloader() {
        downloadStrategies.add(DownloadStrategyByFile.class);
        downloadStrategies.add(DownloadStrategyByUrl.class);
    }

    public Data getDataUsingStrategies(String path) throws BadPathException {
        for (Class<? extends DownloadStrategy> downloadStrategy : downloadStrategies) {
            try {
                DownloadStrategy strategy = downloadStrategy.newInstance();
                String data = strategy.getData(path);
                if (data != null) return new Data(data, path);
            } catch (IllegalStateException e) {
                throw e;
            } catch (Exception e) {
                throw new RuntimeException("It shouldn't never perform!!!");
            }
        }
        throw new BadPathException("Wrong file location or no have strategies for this protocol");
    }
}
