package com.owen.macropadgui;


import javafx.util.Pair;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.crypto.Mac;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonHandler {

    public static final File STORAGE = new File(System.getProperty("user.dir") + "/storage/");


    public JsonHandler(PortListener main, int keyMapChoice) {
        STORAGE.mkdir();
        File KEYMAP_PATH = new File(STORAGE, "KeyMap" + keyMapChoice + ".json");

        try {
            final JSONObject data = (JSONObject) JSONValue.parse(new String(Files.readAllBytes(KEYMAP_PATH.toPath())));

            for (Object o : data.keySet()) {
                String key = (String) o;
                String value = (String) data.get(o);

//                System.out.println(key + "    |   " + value);

                String[] splitKey = key.split(" ");

                ArrayList<String> valueList = new ArrayList<>(List.of(value.split(" ")));


                switch (splitKey[0]) {
                    case "Key" -> {
                        int row = Integer.parseInt(splitKey[1]);
                        int col = Integer.parseInt(splitKey[2]);
                        int inputType = Integer.parseInt(splitKey[3]);
                        Map<Pair<Integer, Integer>, Integer> recievedCodeMap = KeyPressHandler.convertStringToKeyCode(valueList);
                        MacroKey macroKey = new MacroKey(row, col);
                        if (main.keyMap.get(new Pair<>(row, col)) != null) {
                            macroKey = main.keyMap.get(new Pair<>(row, col));
                        }

                        if (inputType == 1) {
                            macroKey.setKeyPressFunction(valueList);
                            macroKey.setKeyPressCodeMap(recievedCodeMap);
                        } else if (inputType == 0) {
                            macroKey.setKeyReleaseFunction(valueList);
                            macroKey.setKeyReleaseCodeMap(recievedCodeMap);
                        }
                        if (main.keyMap.get(new Pair<>(row, col)) == null) {
                            main.keyMap.put(new Pair<>(row, col), macroKey);
                        }


                    }
                    case "Button" -> {
                        int buttonNum = Integer.parseInt(splitKey[1]);
                        int inputType = Integer.parseInt(splitKey[2]);
                        Map<Pair<Integer, Integer>, Integer> recievedCodeMap = KeyPressHandler.convertStringToKeyCode(valueList);
                        MacroButton macroButton = new MacroButton(buttonNum);
                        if (main.buttonMap.get(buttonNum) != null) {
                            macroButton = main.buttonMap.get(buttonNum);
                        }

                        if (inputType == 1) {
                            macroButton.setButtonPressFunction(valueList);
                            macroButton.setButtonPressCodeMap(recievedCodeMap);
                        } else if (inputType == 0) {
                            macroButton.setButtonReleaseFunction(valueList);
                            macroButton.setButtonReleaseCodeMap(recievedCodeMap);
                        }
                        if (main.buttonMap.get(buttonNum) == null) {
                            main.buttonMap.put(buttonNum, macroButton);
                        }
                    }
                    case "Knob" -> {
                        int knobNum = Integer.parseInt(splitKey[1]);
                        int inputType = Integer.parseInt(splitKey[2]);
                        Map<Pair<Integer, Integer>, Integer> recievedCodeMap = KeyPressHandler.convertStringToKeyCode(valueList);
                        MacroKnob macroKnob = new MacroKnob(knobNum);
                        if (main.knobMap.get(knobNum) != null) {
                            macroKnob = main.knobMap.get(knobNum);
                        }

                        if (inputType == 1) {
                            macroKnob.setKnobRightFunction(valueList);
                            macroKnob.setKnobRightCodeMap(recievedCodeMap);
                        } else if (inputType == 0) {
                            macroKnob.setKnobLeftFunction(valueList);
                            macroKnob.setKnobLeftCodeMap(recievedCodeMap);
                        }
                        if (main.knobMap.get(knobNum) == null) {
                            main.knobMap.put(knobNum, macroKnob);
                        }

                    }
                    case "Name" -> {
                        // Change Keymap name to this
                    }
                    default -> {

                    }


                }


            }


        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public static void putKeyData(String itemID, ArrayList<String> data, int keyMapChoice){
        STORAGE.mkdir();
        File KEYMAP_PATH = new File(STORAGE, "KeyMap" + keyMapChoice + ".json");
        JSONObject keyMapFile =  new JSONObject();
//        keyMapFile.put()

    }


}
