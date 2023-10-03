package com.owen.macropadgui;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.File;
import java.nio.file.Files;

import java.util.ArrayList;
import java.util.List;

public class KeyMapNameJsonHandler {


    public final File STORAGE = new File(System.getProperty("user.dir") + "/storage/");
    public final File KEYMAP_PATH = new File(STORAGE, "KeyMapList.json");

    KeyMapSelectionController keyMapSelectionController = new KeyMapSelectionController();
    private ArrayList<String> list;

    public KeyMapNameJsonHandler(Main main) {
        STORAGE.mkdir();

        try {
            final JSONObject data = (JSONObject) JSONValue.parse(new String(Files.readAllBytes(KEYMAP_PATH.toPath())));

            for (Object o : data.keySet()) {
                String name = data.get(o).toString();
                list.add(name);

            }
            keyMapSelectionController.setKeyMapList(list);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
