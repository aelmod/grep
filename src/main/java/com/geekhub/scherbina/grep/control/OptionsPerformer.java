package com.geekhub.scherbina.grep.control;

import com.geekhub.scherbina.grep.cli.CliParser;
import com.geekhub.scherbina.grep.exceptions.BadArgumentException;
import com.geekhub.scherbina.grep.exceptions.BadPathException;

import java.util.ArrayList;

public class OptionsPerformer {
    private ArrayList<OptionFrame> optionFrames;

    public OptionsPerformer(ArrayList<OptionFrame> optionFrames) {
        this.optionFrames = optionFrames;
    }

    public void init(OptionsManager optionsManager) {
        for (OptionFrame optionFrame : optionFrames) {
            optionFrame.registerOptions(optionsManager);
        }
    }
    public void execute(CliParser cliParser) throws BadArgumentException, BadPathException {
        for (OptionFrame optionFrame : optionFrames) {
            optionFrame.init(cliParser.parse());
        }
    }
}
