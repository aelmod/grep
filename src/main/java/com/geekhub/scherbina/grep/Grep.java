package com.geekhub.scherbina.grep;

import com.geekhub.scherbina.grep.exceptions.BadArgumentException;
import com.geekhub.scherbina.grep.exceptions.BadPathException;
import com.geekhub.scherbina.grep.options.AdvancedOptions;
import com.geekhub.scherbina.grep.options.BaseOptions;

public class Grep {
    public static void main(String[] args) throws BadArgumentException, BadPathException {
        Driver driver = new Driver(args);
        driver.addOptionFrame(new AdvancedOptions());
        driver.addOptionFrame(new BaseOptions());
        driver.initGrep();
    }
}
