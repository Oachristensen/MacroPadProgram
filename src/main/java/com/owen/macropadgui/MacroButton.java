package com.owen.macropadgui;


import java.awt.*;


import java.util.ArrayList;

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

    public MacroButton(int button) {
        buttonNum = button;
        functionList = new ArrayList<>();
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
//            for (int i = 0; i < functionList.size(); i++) {
//                robot.keyPress(functionList.get(i));
//            }
//            for (int i = 0; i < functionList.size(); i++) {
//                robot.keyRelease(functionList.get(i));
//            }



            counter++;
            System.out.println("Button num: " + buttonNum + " pressed.   |   Counter: " + counter + "   |   Function: " + functionList);
        }
        catch (Exception e) {

        }
    }

    public void onKeyRelease() {


    }


    public void setKeyFunction(ArrayList<String> list) {
        this.functionList = list;
    }
}

