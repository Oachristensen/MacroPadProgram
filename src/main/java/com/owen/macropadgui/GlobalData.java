package com.owen.macropadgui;


public class GlobalData {
    private final static GlobalData globalData = new GlobalData();

    public static GlobalData getInstance() {
         return globalData;

    }

    public String selectedKeyMap;

    public String selectedItemID;


    public DeviceSelectionController deviceSelectionController;

    private GlobalData(){}

}
