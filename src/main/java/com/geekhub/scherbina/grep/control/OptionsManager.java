package com.geekhub.scherbina.grep.control;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;

public class OptionsManager {
    private Options options = new Options();

    public void addOption(Option option) {
        options.addOption(option);
    }

    public void addOptionsGroup(OptionGroup optionGroup) {
        options.addOptionGroup(optionGroup);
    }

    public Options getOptions(){
        return options;
    }
}
