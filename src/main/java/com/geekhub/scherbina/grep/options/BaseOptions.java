package com.geekhub.scherbina.grep.options;

import com.geekhub.scherbina.grep.Matcher;
import com.geekhub.scherbina.grep.output.Output;
import com.geekhub.scherbina.grep.output.OutputToConsole;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import com.geekhub.scherbina.grep.control.OptionFrame;
import com.geekhub.scherbina.grep.control.OptionsManager;
import com.geekhub.scherbina.grep.data.DataProcessor;
import com.geekhub.scherbina.grep.exceptions.BadPathException;
import com.geekhub.scherbina.grep.source.DataDownloader;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BaseOptions implements OptionFrame {
    private OptionsManager optionsManager;

    public void registerOptions(OptionsManager optionsManager) {
        Option word = new Option("w", "word", true, "word or words that you want to search");
        word.setArgName("text");

        Option file = new Option("f", "file", true, "path to file");
        file.setArgName("file");

        Option url = new Option("u", "url", true, "url to data");
        url.setArgName("url");

        Option regex = new Option("r", "regex", true, "regular expression");
        regex.setArgName("regex");

        Option help = new Option("h", "help", false, "display this help text");

        optionsManager.addOption(word);
        optionsManager.addOption(file);
        optionsManager.addOption(url);
        optionsManager.addOption(regex);
        optionsManager.addOption(help);
        this.optionsManager = optionsManager;
    }

    public void init(CommandLine commandLine) {
        DataProcessor dataProcessor = new DataProcessor();
        DataDownloader dataDownloader = new DataDownloader();

        String[] words = commandLine.getOptionValues("w");
        String[] dataFromFile = commandLine.getOptionValues("f");
        String[] dataFromUrl = commandLine.getOptionValues("u");
        String[] regex = commandLine.getOptionValues("r");

        if (commandLine.hasOption("f")) {
            for (String data : dataFromFile) {
                try {
                    dataProcessor.addData(dataDownloader.getDataUsingStrategies(data));
                } catch (BadPathException e) {
                    e.printStackTrace();
                }
            }
        }
        if (commandLine.hasOption("u")) {
            for (String data : dataFromUrl) {
                try {
                    dataProcessor.addData(dataDownloader.getDataUsingStrategies(data));
                } catch (BadPathException e) {
                    e.printStackTrace();
                }
            }
        }
        if (commandLine.hasOption("h")) {
            HelpFormatter formatter = new HelpFormatter();
            String header = "Hi";
            String footer = "Bye =)";
            formatter.printHelp("GREP ANALOG", header, optionsManager.getOptions(), footer, true);
        }
        write(dataProcessor, words, regex);
    }

    private void write(DataProcessor dataProcessor, String[] words, String[] regex) {
        DataProcessor resDataProcessor = new Matcher(dataProcessor, words, stringsToPatternList(regex)).start();
        Output output = new OutputToConsole();
        output.write(resDataProcessor);
    }

    private List<Pattern> stringsToPatternList(String[] regex) {
        List<Pattern> patterns = new ArrayList<>();
        if (regex != null) {
            for (String s : regex) {
                patterns.add(Pattern.compile(s));
            }
        }
        return patterns;
    }
}
