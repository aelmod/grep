package com.geekhub.scherbina.grep;

import com.geekhub.scherbina.grep.data.Data;
import com.geekhub.scherbina.grep.data.DataProcessor;

import java.util.List;
import java.util.regex.Pattern;

public class Matcher {
    private DataProcessor data;
    private String[] words;
    private List<Pattern> patterns;

    public Matcher(DataProcessor data, String[] words, List<Pattern> patterns) {
        this.data = data;
        this.words = words;
        this.patterns = patterns;
    }

    private String setEscape(String substring) {
        String escapeCharBefore = "#";
        String escapeCharAfter = "#";
        return escapeCharBefore + substring + escapeCharAfter;
    }

    private Pattern getWordsOnlyPattern(String word) {
        return Pattern.compile("\\b\\Q" + word.toLowerCase() + "\\E\\b");
    }


    private String findMatches(String data, Pattern pattern) {
        String res = data;
        //String res = null;
        //if (data == null) return null;
        java.util.regex.Matcher m = pattern.matcher(data.toLowerCase());
        while (m.find()) {
            String substring = data.substring(m.start(), m.end());
            String resWord = setEscape(substring);
            res = data.replace(substring, resWord);
        }
        return res;
    }

    public DataProcessor start() {
        DataProcessor dataProcessor = new DataProcessor();
        for (Data data : data.getDataList()) {
            String temp = data.getData();
            temp = accordingToWords(temp);
            temp = accordingToPatterns(temp);
            dataProcessor.addData(new Data(temp, data.getLocation()));
        }
        return dataProcessor;
    }

    private String accordingToPatterns(String temp) {
        if (patterns != null) {
            for (Pattern pattern : patterns) {
                temp = findMatches(temp, pattern);
            }
        }
        return temp;
    }

    private String accordingToWords(String temp) {
        if (words != null) {
            for (String word : words) {
                temp = findMatches(temp, getWordsOnlyPattern(word));
            }
        }
        return temp;
    }
}
