package com.owen.macropadgui;

import java.util.ArrayList;

public class MacroKey {
    private int keyNum;
    private int keyRow;

    private ArrayList<String> functionList;


    /*
    Key:
        Input Type: K
        Possible Function: 0 (release), 1 ``(press)
        Key Row: 0, 1
        Possible Column: 0, 1, 2, 3
    */
    public MacroKey(int key, int row) {
        keyNum = key;
        keyRow = row;
        functionList = new ArrayList<>();

    }

    public void onAction(int inputType) {
        if (inputType == 1) {
            onKeyPress();
        }
        if (inputType == 0) {
            onKeyRelease();
        }
    }

    public void onKeyPress() {
        System.out.println("Key in row: " + keyRow + " with key Num: " + keyNum + " Pressed |   Function: " + functionList);
    }

    public void onKeyRelease() {
        System.out.println("Key in row: " + keyRow + " with key Num: " + keyNum + " Released");
    }
    public void setKeyFunction(ArrayList<String> list) {
        functionList = list;
    }
}

