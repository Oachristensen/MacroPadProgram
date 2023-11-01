package com.owen.macropadgui.handlers;

import com.owen.macropadgui.GlobalData;
import com.owen.macropadgui.KeyMapSelectionController;
import javafx.util.Pair;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;


import java.util.ArrayList;


public class KeyMapNameJsonHandler {


    public static final File STORAGE = new File(System.getProperty("user.dir") + "/storage/");
    public static final File KEYMAP_PATH = new File(STORAGE, "KeyMapList.json");

    private final ArrayList<Pair<String, String>> list = new ArrayList<>();


    public KeyMapNameJsonHandler(KeyMapSelectionController keyMapSelectionController) {
        STORAGE.mkdir();
        try {
            final JSONObject data = (JSONObject) JSONValue.parse(new String(Files.readAllBytes(KEYMAP_PATH.toPath())));

            for (Object o : data.keySet()) {
                String keyName = (String) o;
                String displayName = data.get(o).toString();
                list.add(new Pair<>(keyName, displayName));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Pair<String, String>> getList(){
        return list;
    }


    public static void uploadKeyMapNames(String name){
        STORAGE.mkdir();
        File KEYMAP_PATH = new File(STORAGE, "KeyMapList.json");
        try {
            JSONObject keyNameFile = (JSONObject) JSONValue.parse(new String(Files.readAllBytes(KEYMAP_PATH.toPath())));
            keyNameFile.put(GlobalData.getInstance().selectedKeyMap, name);
            FileWriter file = new FileWriter(KEYMAP_PATH);
            file.write(keyNameFile.toJSONString());
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
