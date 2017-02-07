package com.geekhub.scherbina.grep.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataProcessor {
    private final List<Data> dataList = new ArrayList<>();

    public void addData(Data data) {
        dataList.add(data);
    }

    public List<Data> getDataList() {
        return dataList;
    }
}
