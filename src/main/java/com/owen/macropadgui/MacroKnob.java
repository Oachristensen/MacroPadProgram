package com.owen.macropadgui;

import commands.MediaKeys;
import javafx.util.Pair;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.awt.event.KeyEvent.VK_RIGHT_PARENTHESIS;
import static java.awt.event.KeyEvent.VK_SHIFT;

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
    private Map<Pair<Integer, Integer>, Integer> knobLeftCodeMap;
    private Map<Pair<Integer, Integer>, Integer> knobRightCodeMap;


    public MacroKnob(int knob) {
        knobNum = knob;
        functionList = new ArrayList<>();
        knobLeftCodeMap = new HashMap<>();
        knobRightCodeMap = new HashMap<>();
    }

    public void onAction(int direction) {
        if (direction == 0) {
            counter++;
            onKnobRight();
        } else {
            counter++;
            onKnobLeft();
        }

        System.out.println("Knob Turned: " + knobNum + "    |   Knob Counter: " + counter + "   |   Function: " + functionList);
    }

    public void onKnobLeft() {
        try {
            Robot robot = new Robot();
            for (Pair<Integer, Integer> p : knobLeftCodeMap.keySet()) {
                if (p.getValue() != null) {
                    robot.keyPress(VK_SHIFT);
                }
                if (p.getKey() > 0) {
                    robot.keyPress(p.getKey());
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
            for (Pair<Integer, Integer> p : knobRightCodeMap.keySet()) {
                if (p.getValue() != null) {
                    robot.keyPress(VK_SHIFT);
                }
                if (p.getKey() > 0) {
                    robot.keyPress(p.getKey());
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

    public void setKnobLeftCodeMap(Map<Pair<Integer, Integer>, Integer> recievedCodeMap) {
        knobLeftCodeMap = recievedCodeMap;
    }

    public void setKnobRightCodeMap(Map<Pair<Integer, Integer>, Integer> recievedCodeMap) {
        knobRightCodeMap = recievedCodeMap;
    }
}

