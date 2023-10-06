package com.owen.macropadgui;

import javafx.fxml.FXMLLoader;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.File;
import java.nio.file.Files;
import javafx.fxml.FXML;


import java.util.ArrayList;
import java.util.List;


// This doesnt work but I want to move on for now
public class KeyMapNameJsonHandler {


    public final File STORAGE = new File(System.getProperty("user.dir") + "/storage/");
    public final File KEYMAP_PATH = new File(STORAGE, "KeyMapList.json");

    private ArrayList<String> list = new ArrayList<>();

    public KeyMapNameJsonHandler(){

    }
    public KeyMapNameJsonHandler(KeyMapSelectionController keyMapSelectionController) {
        STORAGE.mkdir();
        try {
            final JSONObject data = (JSONObject) JSONValue.parse(new String(Files.readAllBytes(KEYMAP_PATH.toPath())));

            for (Object o : data.keySet()) {
                String name = data.get(o).toString();
                list.add(name);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public ArrayList<String> getList(){

        return list;
    }
}
