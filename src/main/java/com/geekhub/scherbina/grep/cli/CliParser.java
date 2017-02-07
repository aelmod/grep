package com.geekhub.scherbina.grep.cli;

import org.apache.commons.cli.*;
import com.geekhub.scherbina.grep.exceptions.BadArgumentException;

public class CliParser {
    private Options options;
    private String[] commandLineArguments;

    public CliParser(Options options, String[] commandLineArguments) {
        this.options = options;
        this.commandLineArguments = commandLineArguments;
    }

    public CommandLine parse() throws BadArgumentException {
        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine commandLine;
        try {
            commandLine = commandLineParser.parse(options, commandLineArguments);
        } catch (ParseException e) {
            throw new BadArgumentException(e);
        }
        return commandLine;
    }
}
