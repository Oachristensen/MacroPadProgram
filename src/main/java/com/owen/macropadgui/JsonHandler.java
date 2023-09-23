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
    public static final File KEYMAP_PATH = new File(STORAGE, "KeyMap.json");


    public JsonHandler(PortListener main) {
        STORAGE.mkdir();

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
                        MacroKey tempKey = main.keyMap.get(o);
                        //Big sleepy,  fix in morning
//                        if (main.keyMap.get(new Pair<>(row, col)) != null) {
//                            MacroKey macroKey = new MacroKey(row, col);
//
//                            if (inputType == 1) {
//                                macroKey.setKeyPressFunction(valueList);
//                                macroKey.setKeyPressCodeMap(recievedCodeMap);
//                            } else if (inputType == 0) {
//                                macroKey.setKeyReleaseFunction(valueList);
//                                macroKey.setKeyReleaseCodeMap(recievedCodeMap);
//                            }
//                        }
//
//                        main.keyMap.put(new Pair<>(row, col), macroKey);


                    }
                    case "Button" -> {
                        int buttonNum = Integer.parseInt(splitKey[1]);
                        int inputType = Integer.parseInt(splitKey[2]);
                        MacroButton macroButton = new MacroButton(buttonNum);
                        Map<Pair<Integer, Integer>, Integer> recievedCodeMap = KeyPressHandler.convertStringToKeyCode(valueList);
                        macroButton.setKeyFunction(valueList);
                        macroButton.setKeyCodeMap(recievedCodeMap);

                        main.buttonMap.put(buttonNum, macroButton);


                    }
                    case "Knob" -> {
                        int knobNum = Integer.parseInt(splitKey[1]);
                        int inputType = Integer.parseInt(splitKey[2]);
                        MacroKnob macroKnob = new MacroKnob(knobNum);
                        macroKnob.setKeyFunction(valueList);

                        main.knobMap.put(knobNum, macroKnob);

                    }
                    default -> {

                    }


                }


            }


        } catch (Exception e) {
            System.out.println(e);
        }

    }


}
