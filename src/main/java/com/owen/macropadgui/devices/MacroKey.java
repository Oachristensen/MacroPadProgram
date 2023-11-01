package com.owen.macropadgui.devices;

import com.owen.macropadgui.DeviceSelectionController;
import com.owen.macropadgui.GlobalData;
import commands.MediaKeys;
import javafx.util.Pair;

import java.awt.*;

import static java.awt.event.KeyEvent.*;

import java.util.ArrayList;

public class MacroKey {
    private final int keyRow;
    private final int keyCol;

    private ArrayList<Pair<Integer, Integer>>  keyPressCodeMap;
    private ArrayList<Pair<Integer, Integer>>  keyReleaseCodeMap;


    /*
    Key:
        Input Type: K
        Possible Function: 0 (release), 1 ``(press)
        Key Row: 0, 1
        Possible Column: 0, 1, 2, 3
    */
    public MacroKey(int key, int row) {
        keyRow = key;
        keyCol = row;
        keyPressCodeMap = new ArrayList<>();
        keyReleaseCodeMap = new ArrayList<>();

    }

    public void onAction(int inputType) {
        final DeviceSelectionController d = GlobalData.getInstance().deviceSelectionController;

        if (inputType == 1) {
            if (d != null) {
                GlobalData.getInstance().deviceSelectionController.setButtonToggle(keyRow, keyCol, true);
            }


            onKeyPress();
        }
        if (inputType == 0) {
            if (d != null) {
                GlobalData.getInstance().deviceSelectionController.setButtonToggle(keyRow, keyCol, false);
            }
            onKeyRelease();
        }
    }

    public void onKeyPress() {
        try {

            System.out.println("Key in col: " + keyCol + " with key col: " + keyRow + " Pressed |   Function: " + keyPressCodeMap);
            Robot robot = new Robot();
            for (Pair<Integer, Integer> p : keyPressCodeMap) {
                if (p.getValue() != null) {
                    robot.keyPress(VK_SHIFT);
                }
                if (p.getKey() > 0){
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

    public void onKeyRelease() {
        try {
            System.out.println("Key in row: " + keyCol + " with key Num: " + keyRow + " Released");
            Robot robot = new Robot();
            for (Pair<Integer, Integer> p :  keyReleaseCodeMap) {
                if (p.getValue() != null) {
                    robot.keyPress(VK_SHIFT);
                }
                if (p.getKey() > 0){
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

    public void setKeyPressFunction(ArrayList<String> list) {
    }
    public void setKeyReleaseFunction(ArrayList<String> list) {
    }

    public void setKeyPressCodeMap(ArrayList<Pair<Integer, Integer>>  receivedCodeMap) {
        keyPressCodeMap = receivedCodeMap;
    }
    public void setKeyReleaseCodeMap(ArrayList<Pair<Integer, Integer>>  recievedCodeMap) {
        keyReleaseCodeMap = recievedCodeMap;
    }

}

