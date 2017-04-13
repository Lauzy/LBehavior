package com.lauzy.freedom.lbehavior.model;


import java.util.ArrayList;
import java.util.List;

public class DataModel {
    public static List<String> getDemoData() {
        List<String> demoData = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            demoData.add("Android -- " + i);
        }
        return demoData;
    }
}
