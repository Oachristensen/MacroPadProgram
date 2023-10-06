package com.owen.macropadgui;

public class GlobalData {
    private final static GlobalData globalData = new GlobalData();

    public static GlobalData getInstance() {
         return globalData;

    }

    public int selectedKeyMap = -1;

    public String selectedItemID;


    private GlobalData(){}

}
