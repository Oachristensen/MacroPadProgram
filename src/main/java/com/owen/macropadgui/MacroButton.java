package com.owen.macropadgui;


import javafx.util.Pair;

import java.awt.*;


import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Button:
    Input Type: B
    Possible Function: 0 (release), 1 (press)
    Button pressed: 0, 1, 2
    Possible Matrix2 (NOT USED): -1
*/
public class MacroButton {
    public int buttonNum;
    public int counter = 0;
    private ArrayList<String> functionList;
    private Map<Pair<Integer, Integer>, Integer> keyCodeMap;

    public MacroButton(int button) {
        buttonNum = button;
        functionList = new ArrayList<>();
        keyCodeMap = new HashMap<>();
    }

    public void onAction(int type) {
        if (type == 0) {
            onKeyRelease();
        } else {
            onKeyPress();
        }
    }

    public void onKeyPress() {
        try {
            Robot robot = new Robot();
            //robot.keyPress();
//            for (int i = 0; i < functionList.size(); i++) {
//                robot.keyPress(Integer.parseInt(functionList.get(i)));
//                System.out.println("Key press complete");
//            }
//            for (int i = 0; i < functionList.size(); i++) {
//                robot.keyRelease(Integer.parseInt(functionList.get(i)));
//                System.out.println("Key Release complete");
//
//            }


            counter++;
            System.out.println("Button num: " + buttonNum + " pressed.   |   Counter: " + counter + "   |   Function: " + functionList + keyCodeMap);
        } catch (Exception e) {
            System.out.println("On Button key press error");

        }
    }

    public void onKeyRelease() {


    }


    public void setKeyFunction(ArrayList<String> list) {
        this.functionList = list;
    }

    public void setKeyCodeMap(Map<Pair<Integer, Integer>, Integer> recievedCodeMap) {
        keyCodeMap = recievedCodeMap;
    }
}


