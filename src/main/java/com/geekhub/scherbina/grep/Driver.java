package com.geekhub.scherbina.grep;

import com.geekhub.scherbina.grep.cli.CliParser;
import com.geekhub.scherbina.grep.control.OptionsManager;
import com.geekhub.scherbina.grep.exceptions.BadArgumentException;
import com.geekhub.scherbina.grep.control.OptionFrame;
import com.geekhub.scherbina.grep.control.OptionsPerformer;
import com.geekhub.scherbina.grep.exceptions.BadPathException;

import java.util.ArrayList;

class Driver {
    private String[] commandLineArguments;

    Driver(String[] commandLineArguments) {
        this.commandLineArguments = commandLineArguments;
    }

    private OptionsManager optionsManager() {
        return new OptionsManager();
    }

    private CliParser getCliParser(OptionsManager optionsManager) {
        return new CliParser(optionsManager.getOptions(), commandLineArguments);
    }

    private ArrayList<OptionFrame> optionFrames = new ArrayList<>();

    void addOptionFrame(OptionFrame optionFrame) {
        optionFrames.add(optionFrame);
    }

    void initGrep() throws BadArgumentException, BadPathException {
        OptionsManager optionsManager = optionsManager();
        CliParser cliParser = getCliParser(optionsManager);
        prepareOptionFrame(optionsManager, cliParser);
    }

    private void prepareOptionFrame(OptionsManager optionsManager, CliParser cliParser) throws BadArgumentException, BadPathException {
        OptionsPerformer optionsPerformer = new OptionsPerformer(optionFrames);
        optionsPerformer.init(optionsManager);
        optionsPerformer.execute(cliParser);
    }
}
