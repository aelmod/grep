package com.geekhub.scherbina.grep.data;

public class Data {
    private String data;
    private String location;

    public Data(String data, String location) {
        this.data = data;
        this.location = location;
    }

    public String getData() {
        return data;
    }

    public String getLocation() {
        return location;
    }
}
