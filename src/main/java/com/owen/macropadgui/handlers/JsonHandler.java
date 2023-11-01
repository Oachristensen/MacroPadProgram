package com.owen.macropadgui.handlers;


import com.owen.macropadgui.GlobalData;
import com.owen.macropadgui.PortListener;
import com.owen.macropadgui.devices.MacroButton;
import com.owen.macropadgui.devices.MacroKey;
import com.owen.macropadgui.devices.MacroKnob;
import javafx.util.Pair;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class JsonHandler {

    public static final File STORAGE = new File(System.getProperty("user.dir") + "/storage/");

    public JsonHandler() {

    }




    public static ArrayList<String> getValueList() {
        ArrayList<String> valueList = new ArrayList<>();
        STORAGE.mkdir();
        File KEYMAP_PATH = new File(STORAGE, GlobalData.getInstance().selectedKeyMap + ".json");

        try {
            JSONObject data = (JSONObject) JSONValue.parse(new String(Files.readAllBytes(KEYMAP_PATH.toPath())));
            System.out.println(data);

            for (Object o : data.keySet()) {
                String value = (String) data.get(o);

                valueList = new ArrayList<>(List.of(value.split(" ")));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return valueList;
    }

    public void setKeyData(PortListener main) {
        STORAGE.mkdir();
        File KEYMAP_PATH = new File(STORAGE,GlobalData.getInstance().selectedKeyMap + ".json");

        try {
            JSONObject data = (JSONObject) JSONValue.parse(new String(Files.readAllBytes(KEYMAP_PATH.toPath())));
            System.out.println(data);

            for (Object o : data.keySet()) {
                String key = (String) o;
                String value = (String) data.get(o);

                String[] splitKey = key.split(" ");

                ArrayList<String> valueList = new ArrayList<>(List.of(value.split(" ")));
                System.out.println(valueList);

                ArrayList<Pair<Integer, Integer>> receivedCodeList = KeyPressHandler.convertStringToKeyCode(valueList);

                switch (splitKey[0]) {
                    case "Key" -> {
                        int row = Integer.parseInt(splitKey[1]);
                        int col = Integer.parseInt(splitKey[2]);
                        int inputType = Integer.parseInt(splitKey[3]);
                        System.out.println(receivedCodeList);
                        MacroKey macroKey = new MacroKey(row, col);
                        if (main.keyMap.get(new Pair<>(row, col)) != null) {
                            macroKey = main.keyMap.get(new Pair<>(row, col));
                        }

                        if (inputType == 1) {
                            macroKey.setKeyPressFunction(valueList);
                            macroKey.setKeyPressCodeMap(receivedCodeList);
                        } else if (inputType == 0) {
                            macroKey.setKeyReleaseFunction(valueList);
                            macroKey.setKeyReleaseCodeMap(receivedCodeList);
                        }
                        main.keyMap.putIfAbsent(new Pair<>(row, col), macroKey);


                    }
                    case "Button" -> {
                        int buttonNum = Integer.parseInt(splitKey[1]);
                        int inputType = Integer.parseInt(splitKey[2]);
                        MacroButton macroButton = new MacroButton(buttonNum);
                        if (main.buttonMap.get(buttonNum) != null) {
                            macroButton = main.buttonMap.get(buttonNum);
                        }

                        if (inputType == 1) {
                            macroButton.setButtonPressFunction(valueList);
                            macroButton.setButtonPressCodeMap(receivedCodeList);
                        } else if (inputType == 0) {
                            macroButton.setButtonReleaseFunction(valueList);
                            macroButton.setButtonReleaseCodeMap(receivedCodeList);
                        }
                        main.buttonMap.putIfAbsent(buttonNum, macroButton);
                    }
                    case "Knob" -> {
                        int knobNum = Integer.parseInt(splitKey[1]);
                        int inputType = Integer.parseInt(splitKey[2]);
                        MacroKnob macroKnob = new MacroKnob(knobNum);
                        if (main.knobMap.get(knobNum) != null) {
                            macroKnob = main.knobMap.get(knobNum);
                        }

                        if (inputType == 1) {
                            macroKnob.setKnobRightFunction(valueList);
                            macroKnob.setKnobRightCodeMap(receivedCodeList);
                        } else if (inputType == 0) {
                            macroKnob.setKnobLeftFunction(valueList);
                            macroKnob.setKnobLeftCodeMap(receivedCodeList);
                        }
                        main.knobMap.putIfAbsent(knobNum, macroKnob);

                    }
                    default -> {

                    }


                }


            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void uploadKeyData(String key, String value) {
        STORAGE.mkdir();
        File KEYMAP_PATH = new File(STORAGE,GlobalData.getInstance().selectedKeyMap + ".json");
        try {
            JSONObject keyMapFile = (JSONObject) JSONValue.parse(new String(Files.readAllBytes(KEYMAP_PATH.toPath())));
            keyMapFile.put(key, value);
            FileWriter file = new FileWriter(KEYMAP_PATH);
            file.write(keyMapFile.toJSONString());
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
