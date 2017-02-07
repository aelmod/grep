package com.geekhub.scherbina.grep.control;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aelmod on 05.02.17.
 */
public class OptionsManagerTest {
    @Test
    public void addOption() throws Exception {
        Option option = new Option("s", "ss");
        OptionsManager optionsManager = new OptionsManager();
        optionsManager.addOption(option);

        Options options = new Options().addOption(option);
        assertEquals(options.getOption("s"), optionsManager.getOptions().getOption("s"));
    }

    @Test
    public void addOptionsGroup() throws Exception {
        Option option = new Option("s", "ss");
        OptionGroup optionGroup = new OptionGroup();
        optionGroup.addOption(option);
        Options options = new Options();
        options.addOptionGroup(optionGroup);

        OptionsManager optionsManager = new OptionsManager();
        optionsManager.addOptionsGroup(optionGroup);

        Options options1 = optionsManager.getOptions();

        assertEquals(options.getOption("s"), options1.getOption("s"));
    }

    @Test
    public void getOptions() throws Exception {
        OptionsManager optionsManager = new OptionsManager();
        Option option = new Option("s", "ss");
        optionsManager.addOption(option);
        Options options = optionsManager.getOptions();
        Option s = options.getOption("s");
        assertEquals("s", s.getOpt());
    }

}