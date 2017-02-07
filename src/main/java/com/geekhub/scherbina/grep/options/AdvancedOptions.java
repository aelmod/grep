package com.geekhub.scherbina.grep.options;

import com.geekhub.scherbina.grep.control.OptionFrame;
import com.geekhub.scherbina.grep.control.OptionsManager;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;

public class AdvancedOptions implements OptionFrame {
    @Override
    public void registerOptions(OptionsManager optionsManager) {
        Option save = new Option("s", "save", true, "save data to file");
        save.setArgName("path");
        Option additionalInfo = new Option("a", "additional", false, "add additional info");
        optionsManager.addOption(save);
        optionsManager.addOption(additionalInfo);
    }

    @Override
    public void init(CommandLine commandLine) {
        if (commandLine.hasOption("a")){
        }
        if (commandLine.hasOption("s")){
        }
    }
}
