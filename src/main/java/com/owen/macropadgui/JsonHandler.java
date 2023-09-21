package com.owen.macropadgui;


import javafx.util.Pair;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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

                        MacroKey macroKey = new MacroKey(row, col);
                        macroKey.setKeyFunction(valueList);

                        main.keyMap.put(new Pair<>(row, col), macroKey);


                    }
                    case "Button" -> {
                        int buttonNum = Integer.parseInt(splitKey[1]);
                        MacroButton macroButton = new MacroButton(buttonNum);
                        macroButton.setKeyFunction(valueList);

                        main.buttonMap.put(buttonNum, macroButton);

                    }
                    case "Knob" -> {
                        int knobNum = Integer.parseInt(splitKey[1]);
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
