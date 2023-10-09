package com.owen.macropadgui;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.net.URL;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ResourceBundle;


public class FunctionSelectionController implements Initializable {
    @FXML
    private TextField keyInput1;
    @FXML
    private TextField keyInput2;
    @FXML
    private TextField keyInput3;
    @FXML
    private TextField keyInput4;
    @FXML
    private TextField keyInput5;

    @FXML
    private TreeView<String> functionList1;
    @FXML
    private TreeView<String> functionList2;
    @FXML
    private TreeView<String> functionList3;
    @FXML
    private TreeView<String> functionList4;
    @FXML
    private TreeView<String> functionList5;

    @FXML
    private Button backButton;

    @FXML
    private Button saveButton;

    @FXML
    private ToggleButton pressReleaseToggleButton;

    private Stage stage;

    private String[] releaseArray = {"", "", "", "", ""};
    private String[] pressArray = {"", "", "", "", ""};

    private HashMap<Integer, TextField> keyTextFieldList;
    private HashMap<Integer, TreeView<String>> functionTreeViewList;
    private HashMap<Integer, Integer> functionTreeViewIndexList;


    private String[] populateArray() {
        String[] newArray = new String[5];
        for (Integer i : keyTextFieldList.keySet()) {
            if (!keyTextFieldList.get(i).getText().isBlank() || !(keyTextFieldList.get(i).getText() == null)) {
                newArray[i] = (keyTextFieldList.get(i).getText());
            } else if (functionTreeViewList.get(i).getSelectionModel().getSelectedItem() != null) {
                newArray[i] = (functionTreeViewList.get(i).getSelectionModel().getSelectedItem().toString());
                functionTreeViewIndexList.put(i, functionTreeViewList.get(i).getSelectionModel().getSelectedIndex());
            } else if (keyTextFieldList.get(i).getText().isBlank() && functionTreeViewList.get(i).getSelectionModel().getSelectedItem() == null) {
                newArray[i] = (" ");
            }

        }
        return newArray;
    }

    private void populateTreeView() {
        TreeItem<String> topRoot = new TreeItem<String>("Special Keys");
        topRoot.setExpanded(true);
        TreeItem<String> rootFKeys = new TreeItem<String>("F Keys");
        rootFKeys.setExpanded(false);
        for (int i = 1; i < 13; i++) {
            TreeItem<String> fnKey = new TreeItem<>("F" + i);
            rootFKeys.getChildren().add(fnKey);
        }
        TreeItem<String> rootSpecialKeys = new TreeItem<String>("Function Keys");
        rootFKeys.setExpanded(false);
        rootSpecialKeys.getChildren().addAll(
                new TreeItem<String>("Space"),
                new TreeItem<String>("Enter"),
                new TreeItem<String>("Backspace"),
                new TreeItem<String>("Tab"),
                new TreeItem<String>("Alt"),
                new TreeItem<String>("Ctrl"),
                new TreeItem<String>("Windows"),
                new TreeItem<String>("Esc"),
                new TreeItem<String>("Caps")
        );
        TreeItem<String> rootArrowKeys = new TreeItem<String>("Arrow Keys");
        rootArrowKeys.getChildren().addAll(
                new TreeItem<>("Up"),
                new TreeItem<>("Down"),
                new TreeItem<>("Left"),
                new TreeItem<>("Right")
        );
        topRoot.getChildren().addAll(rootFKeys, rootSpecialKeys, rootArrowKeys);

        for (Integer i : functionTreeViewList.keySet()) {
            functionTreeViewList.get(i).setRoot(topRoot);
        }

    }

    private void clearSelection() {
        for (Integer i : keyTextFieldList.keySet()) {
            System.out.println(keyTextFieldList.get(i).getText());
            keyTextFieldList.get(i).setText(" ");
            functionTreeViewList.get(i).getSelectionModel().select(null);
        }
    }

    private void setSelection(String[] array) {
        for (Integer i : keyTextFieldList.keySet()) {
            System.out.println(keyTextFieldList.get(i).getText());
            keyTextFieldList.get(i).setText(array[i]);
            if (functionTreeViewList.get(i) != null || functionTreeViewIndexList.get(i) != null) {
                functionTreeViewList.get(i).getSelectionModel().select(functionTreeViewIndexList.get(i));
            }
        }
    }

    private void setTreeIndex() {
        for (Integer i : keyTextFieldList.keySet()) {
            TreeItem<String> selectedItem = functionTreeViewList.get(i).getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                functionTreeViewIndexList.put(i, selectedItem.getParent().getChildren().indexOf(selectedItem));
            }
        }
    }


    public void exitFunctionSelection(ActionEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public static String arrayToSortedString(String[] data) {
        return (data[0] + " " + data[1] + " " + data[2] + " " + data[3] + " " + data[4]);
    }

    public static String sortItemID(String itemID) {
        String deviceType = "";
        String deviceNum = "";

        char[] itemIdCharArray = itemID.toCharArray();
        switch (itemIdCharArray[1]) {
            case 'e':
                deviceType = "Key";
                switch (itemIdCharArray[3]) {
                    case '1':
                        deviceNum = " 0 0";
                        break;
                    case '2':
                        deviceNum = " 0 1";
                        break;
                    case '3':
                        deviceNum = " 0 2";
                        break;
                    case '4':
                        deviceNum = " 0 3";
                        break;
                    case '5':
                        deviceNum = " 1 0";
                        break;
                    case '6':
                        deviceNum = " 1 1";
                        break;
                    case '7':
                        deviceNum = " 1 2";
                        break;
                    case '8':
                        deviceNum = " 1 3";
                        break;
                    default:
                        System.out.println("Something wrong with KeyID");
                }
                break;
            case 'u':
                deviceType = "Button";
                switch (itemIdCharArray[6]) {
                    case '1':
                        deviceNum = " 0";
                        break;
                    case '2':
                        deviceNum = " 1";
                        break;
                    case '3':
                        deviceNum = " 2";
                        break;
                    default:
                        System.out.println("Something wrong with ButtonID");
                }
                break;
            case 'n':
                deviceType = "Knob";
                switch (itemIdCharArray[4]) {
                    case '1':
                        deviceNum = " 0";
                        break;
                    case '2':
                        deviceNum = " 1";
                        break;
                    case '3':
                        deviceNum = " 2";
                        break;
                    default:
                        System.out.println("Something wrong with KnobID");
                }
                break;
            default:
                System.out.println("Something wrong with ItemID");
        }
        return (deviceType + deviceNum);
    }


    public void setFunctionData(String[] data, String inputType) {
        String itemID = GlobalData.getInstance().selectedItemID;
        String sortedItemID = sortItemID(itemID);
        String key = (sortedItemID + " " + inputType);
        String value = arrayToSortedString(data);
        JsonHandler.uploadKeyData(key, value);
    }

    public void uploadFunctionData(ActionEvent event) {
        // 0 for release 1 for press
        Arrays.fill(releaseArray, (""));
        releaseArray = populateArray();
        Arrays.fill(pressArray, (""));
        pressArray = populateArray();
        setFunctionData(releaseArray, "0");
        setFunctionData(pressArray, "1");
        exitFunctionSelection(event);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        keyTextFieldList = new HashMap<>();
        functionTreeViewList = new HashMap<>();
        functionTreeViewIndexList = new HashMap<>();

        keyTextFieldList.put(0, keyInput1);
        keyTextFieldList.put(1, keyInput2);
        keyTextFieldList.put(2, keyInput3);
        keyTextFieldList.put(3, keyInput4);
        keyTextFieldList.put(4, keyInput5);

        functionTreeViewList.put(0, functionList1);
        functionTreeViewList.put(1, functionList2);
        functionTreeViewList.put(2, functionList3);
        functionTreeViewList.put(3, functionList4);
        functionTreeViewList.put(4, functionList5);

        functionTreeViewIndexList.put(0, 1);
        functionTreeViewIndexList.put(1, 2);
        functionTreeViewIndexList.put(2, 3);
        functionTreeViewIndexList.put(3, 4);
        functionTreeViewIndexList.put(4, 5);

        populateTreeView();
        if (GlobalData.getInstance().selectedItemID.toCharArray()[1] == 'n') {
            pressReleaseToggleButton.setText("LEFT");
        }


        pressReleaseToggleButton.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean isSelected) {
                if (GlobalData.getInstance().selectedItemID.toCharArray()[1] == 'n') {
                    if (isSelected == false) {

                        Arrays.fill(releaseArray, (""));
                        releaseArray = populateArray();
                        setTreeIndex();
                        clearSelection();
                        setSelection(pressArray);
                        pressReleaseToggleButton.setText("LEFT");

                    } else {
                        Arrays.fill(pressArray, (""));
                        pressArray = populateArray();
                        setTreeIndex();
                        clearSelection();
                        setSelection(releaseArray);
                        pressReleaseToggleButton.setText("RIGHT");

                    }
                } else {
                    if (isSelected == false) {

                        Arrays.fill(releaseArray, (""));
                        releaseArray = populateArray();
                        clearSelection();
                        setSelection(pressArray);
                        pressReleaseToggleButton.setText("PRESS");

                    } else {
                        Arrays.fill(pressArray, (""));
                        pressArray = populateArray();
                        clearSelection();
                        setSelection(releaseArray);
                        pressReleaseToggleButton.setText("RELEASE");

                    }
                }
            }
        });
    }
}
