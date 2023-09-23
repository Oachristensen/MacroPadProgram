package com.owen.macropadgui;

import javafx.util.Pair;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class PortListener implements SerialPortEventListener {
    public Map<Integer, MacroButton> buttonMap;
    public Map<Integer, MacroKnob> knobMap;
    public Map<Pair<Integer, Integer>, MacroKey> keyMap;
    private SerialPort port;


    public PortListener(SerialPort port) {

        this.port = port;
        knobMap = new HashMap<>();
        buttonMap = new HashMap<>();
        keyMap = new HashMap<>();

        JsonHandler jsonHandler = new JsonHandler(this);

    }

    public int convertCharToInteger(char c) {
        return Integer.parseInt(String.valueOf(c));
    }

    public void serialEvent(SerialPortEvent event) {

        try {

            byte[] bytes = port.readBytes();
            String recievedString = new String(bytes).trim();
            if (recievedString.equals("")) {
                //Error correction
                return;
            }
            char type = recievedString.charAt(0);


            int inputType = convertCharToInteger(recievedString.charAt(1));
            if (type == 'K') {
                int keyRow = convertCharToInteger(recievedString.charAt(2)); // 0 top row 1 bot row
                int keyCol = convertCharToInteger(recievedString.charAt(3)); // 0-3 right to left

                if (keyMap.get(new Pair<>(keyRow, keyCol)) == null) {
                    throw new NullPointerException("Key not found in keyMap with row/col: " + keyRow + "/" + keyCol);
                }
                keyMap.get(new Pair<>(keyRow, keyCol)).onAction(inputType);


            } else if (type == 'N') {
                int knobNum = convertCharToInteger(recievedString.charAt(2));
                if (knobMap.get(knobNum) == null) {
                    throw new NullPointerException("Knob not found in knobMap with num: " + knobNum);
                }

                int turnDirection = convertCharToInteger(recievedString.charAt(1)); // 0 left, 1 right
                knobMap.get(knobNum).onAction(turnDirection);


            } else if (type == 'B') {
                int buttonNum = convertCharToInteger(recievedString.charAt(2));
                if (buttonMap.get(buttonNum) == null) {
                    throw new NullPointerException("Button not found in buttonMap with num: " + buttonNum);
                }
                buttonMap.get(buttonNum).onAction(inputType);
            }
        } catch (SerialPortException e) {
            throw new RuntimeException(e);
        }
    }
}