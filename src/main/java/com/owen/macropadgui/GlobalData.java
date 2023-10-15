package com.owen.macropadgui;

import javafx.util.Pair;

public class GlobalData {
    private final static GlobalData globalData = new GlobalData();

    public static GlobalData getInstance() {
         return globalData;

    }

    public String selectedKeyMap;

    public String selectedItemID;

    public String selectedKeyMapName;


    private GlobalData(){}

}
