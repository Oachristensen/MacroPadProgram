package com.owen.macropadgui.devices;

import commands.MediaKeys;
import javafx.util.Pair;

import java.awt.*;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.VK_SHIFT;

/*
Knob:
    Input Type: N
    Possible Function: 0 (left), 1 (right)
    Knob Turned: 0, 1, 2
    Possible Matrix2 (NOT USED): -1
*/
public class MacroKnob {
    private final int knobNum;

    private ArrayList<String> functionList;
    private ArrayList<Pair<Integer, Integer>>  knobLeftCodeMap;
    private ArrayList<Pair<Integer, Integer>>  knobRightCodeMap;


    public MacroKnob(int knob) {
        knobNum = knob;
        functionList = new ArrayList<>();
        knobLeftCodeMap = new ArrayList<>();
        knobRightCodeMap = new ArrayList<>();
    }

    public void onAction(int direction) {
        if (direction == 0) {

            onKnobRight();
        } else {

            onKnobLeft();
        }

        System.out.println("Knob Turned: " + knobNum + "   |   Function: " + functionList);
    }

    public void onKnobLeft() {
        try {
            Robot robot = new Robot();
            for (Pair<Integer, Integer> p : knobLeftCodeMap) {
                if (p.getValue() != null) {
                    robot.keyPress(VK_SHIFT);
                }
                if (p.getKey() > 0) {
                    robot.keyPress(p.getKey());
                    robot.keyRelease(p.getKey());
                }
                if (p.getValue() != null) {
                    robot.keyRelease(VK_SHIFT);
                }
                if (p.getValue() != null && p.getValue() == MediaKeys.MEDIAKEY) {
                    MediaKeys.sortMediaKeys(p.getKey()).run();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onKnobRight() {
        try {
            Robot robot = new Robot();
            for (Pair<Integer, Integer> p : knobRightCodeMap) {
                if (p.getValue() != null) {
                    robot.keyPress(VK_SHIFT);
                }
                if (p.getKey() > 0) {
                    robot.keyPress(p.getKey());
                    robot.keyRelease(p.getKey());
                }
                if (p.getValue() != null) {
                    robot.keyRelease(VK_SHIFT);
                }
                if (p.getValue() != null && p.getValue() == MediaKeys.MEDIAKEY) {
                    MediaKeys.sortMediaKeys(p.getKey()).run();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setKnobLeftFunction(ArrayList<String> list) {
        this.functionList = list;
    }

    public void setKnobRightFunction(ArrayList<String> list) {
        this.functionList = list;
    }

    public void setKnobLeftCodeMap(ArrayList<Pair<Integer, Integer>>  receivedCodeMap) {
        knobLeftCodeMap = receivedCodeMap;
    }

    public void setKnobRightCodeMap(ArrayList<Pair<Integer, Integer>>  receivedCodeMap) {
        knobRightCodeMap = receivedCodeMap;
    }
}

