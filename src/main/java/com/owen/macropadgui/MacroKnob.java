package com.owen.macropadgui;

import java.util.ArrayList;

/*
Knob:
    Input Type: N
    Possible Function: 0 (left), 1 (right)
    Knob Turned: 0, 1, 2
    Possible Matrix2 (NOT USED): -1
*/
public class MacroKnob {
    private int knobNum;
    private int counter = 100;

    private ArrayList<String> functionList;


    public MacroKnob(int knob) {
        knobNum = knob;
        functionList = new ArrayList<>();
    }

    public void onAction(int direction) {
        if (direction == 0) {
            counter++;
        } else {
            counter++;
        }

        System.out.println("Knob Turned: " + knobNum + "    |   Knob Counter: " + counter + "   |   Function: " + functionList);
    }

    public void setKeyFunction(ArrayList<String> list) {

        this.functionList = list;
    }

}

