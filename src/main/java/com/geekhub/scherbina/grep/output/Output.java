package com.geekhub.scherbina.grep.output;

import com.geekhub.scherbina.grep.data.DataProcessor;

public interface Output {
    void write(DataProcessor dataProcessor);
}
