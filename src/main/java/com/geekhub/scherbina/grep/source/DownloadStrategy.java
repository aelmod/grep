package com.geekhub.scherbina.grep.source;

public interface DownloadStrategy {
    String charset = "UTF-8";
    String getData(String path);
}
