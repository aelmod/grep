package com.geekhub.scherbina.grep.control;

import org.apache.commons.cli.CommandLine;

public interface OptionFrame {
    void registerOptions(OptionsManager optionsManager);

    void init(CommandLine commandLine);
}
