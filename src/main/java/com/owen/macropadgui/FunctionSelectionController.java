package com.owen.macropadgui;


import com.owen.macropadgui.handlers.JsonHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;


public class FunctionSelectionController implements Initializable {
    @FXML
    private Label keyInput1;
    @FXML
    private Label keyInput2;
    @FXML
    private Label keyInput3;
    @FXML
    private Label keyInput4;
    @FXML
    private Label keyInput5;

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

    private String[] releaseArray = {null, null, null, null, null};
    private String[] pressArray = {null, null, null, null, null};

    private HashMap<Integer, Label> keyLabelList;
    private HashMap<Integer, TreeView<String>> functionTreeViewList;

    private final ArrayList<String> valueList = JsonHandler.getValueList();


    private String[] populateArray(String[] newArray) {
        for (int i = 0; i < newArray.length; i++) {
            if (functionTreeViewList.get(i).getSelectionModel().getSelectedItem() != null) {
                newArray[i] = (functionTreeViewList.get(i).getSelectionModel().getSelectedItem().getValue());
                System.out.println(functionTreeViewList.get(i).getSelectionModel().getSelectedItem().getValue());
//                functionTreeViewIndexList.put(i, functionTreeViewList.get(i).getSelectionModel().getSelectedIndex());
            } else if (functionTreeViewList.get(i).getSelectionModel().getSelectedItem() == null && newArray[i] == null) {
                newArray[i] = (null);
            }

        }
        return newArray;
    }

    private void populateTreeView() {
        ArrayList<TreeItem<String>> treeRoots = new ArrayList<>();
        TreeItem<String> topRoot = new TreeItem<>("Special Keys");
        topRoot.setExpanded(true);
        TreeItem<String> rootFKeys = new TreeItem<>("F Keys");
        rootFKeys.setExpanded(false);
        for (int i = 1; i < 13; i++) {
            TreeItem<String> fnKey = new TreeItem<>("F" + i);
            rootFKeys.getChildren().add(fnKey);
        }
        treeRoots.add(rootFKeys);
        TreeItem<String> rootModifierKeys = new TreeItem<>("Modifier Keys");
        rootFKeys.setExpanded(false);
        rootModifierKeys.getChildren().addAll(
                new TreeItem<>("Space"),
                new TreeItem<>("Enter"),
                new TreeItem<>("Backspace"),
                new TreeItem<>("Tab"),
                new TreeItem<>("Alt"),
                new TreeItem<>("Ctrl"),
                new TreeItem<>("Windows"),
                new TreeItem<>("Esc"),
                new TreeItem<>("Caps")
        );
        treeRoots.add(rootModifierKeys);
        TreeItem<String> rootArrowKeys = new TreeItem<>("Arrow Keys");
        rootArrowKeys.getChildren().addAll(
                new TreeItem<>("Up"),
                new TreeItem<>("Down"),
                new TreeItem<>("Left"),
                new TreeItem<>("Right")
        );
        treeRoots.add(rootArrowKeys);
        TreeItem<String> rootLetterKeys = new TreeItem<>("Letters");
        rootLetterKeys.getChildren().addAll(
                new TreeItem<>("A"),
                new TreeItem<>("B"),
                new TreeItem<>("C"),
                new TreeItem<>("D"),
                new TreeItem<>("E"),
                new TreeItem<>("F"),
                new TreeItem<>("G"),
                new TreeItem<>("H"),
                new TreeItem<>("I"),
                new TreeItem<>("J"),
                new TreeItem<>("K"),
                new TreeItem<>("L"),
                new TreeItem<>("M"),
                new TreeItem<>("N"),
                new TreeItem<>("O"),
                new TreeItem<>("P"),
                new TreeItem<>("Q"),
                new TreeItem<>("R"),
                new TreeItem<>("S"),
                new TreeItem<>("T"),
                new TreeItem<>("U"),
                new TreeItem<>("V"),
                new TreeItem<>("W"),
                new TreeItem<>("X"),
                new TreeItem<>("Y"),
                new TreeItem<>("Z")
        );
        treeRoots.add(rootLetterKeys);

        TreeItem<String> rootNumberKeys = new TreeItem<>("Numbers");
        rootNumberKeys.getChildren().addAll(
                new TreeItem<>("1"),
                new TreeItem<>("2"),
                new TreeItem<>("3"),
                new TreeItem<>("4"),
                new TreeItem<>("5"),
                new TreeItem<>("6"),
                new TreeItem<>("7"),
                new TreeItem<>("8"),
                new TreeItem<>("9"),
                new TreeItem<>("0")
        );
        treeRoots.add(rootNumberKeys);

        TreeItem<String> rootMediaKeys = new TreeItem<>("Media Keys");
        rootMediaKeys.getChildren().addAll(
                new TreeItem<>("VOL_UP"),
                new TreeItem<>("VOL_DOWN"),
                new TreeItem<>("PLAY/PAUSE"),
                new TreeItem<>("NEXT"),
                new TreeItem<>("NEXT"),
                new TreeItem<>("PREV"),
                new TreeItem<>("MUTE"),
                new TreeItem<>("STOP")
        );
        treeRoots.add(rootMediaKeys);

        TreeItem<String> rootSpecialKeys = new TreeItem<>("Special Characters");
        rootSpecialKeys.getChildren().addAll(
                new TreeItem<>("!"),
                new TreeItem<>("="),
                new TreeItem<>("-"),
                new TreeItem<>("`"),
                new TreeItem<>("~"),
                new TreeItem<>("@"),
                new TreeItem<>("$"),
                new TreeItem<>("#"),
                new TreeItem<>("%"),
                new TreeItem<>("^"),
                new TreeItem<>("&"),
                new TreeItem<>("*"),
                new TreeItem<>("("),
                new TreeItem<>(")"),
                new TreeItem<>("_"),
                new TreeItem<>("+"),
                new TreeItem<>("["),
                new TreeItem<>("]"),
                new TreeItem<>("\\"),
                new TreeItem<>("{"),
                new TreeItem<>("}"),
                new TreeItem<>("|"),
                new TreeItem<>(":"),
                new TreeItem<>(";"),
                new TreeItem<>("'"),
                new TreeItem<>("\""),
                new TreeItem<>(","),
                new TreeItem<>("<"),
                new TreeItem<>(">"),
                new TreeItem<>("."),
                new TreeItem<>("/"),
                new TreeItem<>("?"),
                new TreeItem<>("%")
                );
        treeRoots.add(rootSpecialKeys);

        topRoot.getChildren().addAll(treeRoots);

        for (Integer i : functionTreeViewList.keySet()) {
            functionTreeViewList.get(i).setRoot(topRoot);
        }

    }

    private void clearSelection() {
        for (Integer i : keyLabelList.keySet()) {
            System.out.println(keyLabelList.get(i).getText());
            functionTreeViewList.get(i).getSelectionModel().select(null);
        }
    }

    private void setSelection(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(keyLabelList.get(i).getText());
            keyLabelList.get(i).setText(array[i]);
        }
    }

    public void exitFunctionSelection(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
        populateArray(releaseArray);
        populateArray(pressArray);
        setFunctionData(releaseArray, "0");
        setFunctionData(pressArray, "1");
        exitFunctionSelection(event);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println(valueList);

        keyLabelList = new HashMap<>();
        functionTreeViewList = new HashMap<>();

        keyLabelList.put(0, keyInput1);
        keyLabelList.put(1, keyInput2);
        keyLabelList.put(2, keyInput3);
        keyLabelList.put(3, keyInput4);
        keyLabelList.put(4, keyInput5);


//        for (int i = 0; i < keyLabelList.size(); i++) {
//            try {
//                keyLabelList.get(i).setText(valueList.get(i));
//            } catch (Exception ignored) {
//            }
//        }


        functionTreeViewList.put(0, functionList1);
        functionTreeViewList.put(1, functionList2);
        functionTreeViewList.put(2, functionList3);
        functionTreeViewList.put(3, functionList4);
        functionTreeViewList.put(4, functionList5);

//        functionTreeViewIndexList.put(0, 1);
//        functionTreeViewIndexList.put(1, 2);
//        functionTreeViewIndexList.put(2, 3);
//        functionTreeViewIndexList.put(3, 4);
//        functionTreeViewIndexList.put(4, 5);

        populateTreeView();

        if (GlobalData.getInstance().selectedItemID.toCharArray()[1] == 'n') {
            pressReleaseToggleButton.setText("LEFT");
        }

        functionList1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> observableValue, TreeItem<String> stringTreeItem, TreeItem<String> t1) {
                keyInput1.setText(functionList1.getSelectionModel().getSelectedItem().getValue());
            }
        });
        functionList2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> observableValue, TreeItem<String> stringTreeItem, TreeItem<String> t1) {
                keyInput2.setText(functionList2.getSelectionModel().getSelectedItem().getValue());

            }
        });

        functionList3.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {

            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> observableValue, TreeItem<String> stringTreeItem, TreeItem<String> t1) {
                keyInput3.setText(functionList3.getSelectionModel().getSelectedItem().getValue());
            }
        });
        functionList4.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> observableValue, TreeItem<String> stringTreeItem, TreeItem<String> t1) {
                keyInput4.setText(functionList4.getSelectionModel().getSelectedItem().getValue());

            }
        });
        functionList5.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> observableValue, TreeItem<String> stringTreeItem, TreeItem<String> t1) {
                keyInput5.setText(functionList5.getSelectionModel().getSelectedItem().getValue());
            }
        });

        pressReleaseToggleButton.selectedProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean isSelected) {
                if (GlobalData.getInstance().selectedItemID.toCharArray()[1] == 'n') {
                    if (isSelected == false) {

                        releaseArray = populateArray(releaseArray);
//                        setTreeIndex();
                        clearSelection();
                        setSelection(pressArray);
                        pressReleaseToggleButton.setText("LEFT");

                    } else {
                        pressArray = populateArray(pressArray);
//                        setTreeIndex();
                        clearSelection();
                        setSelection(releaseArray);
                        pressReleaseToggleButton.setText("RIGHT");

                    }
                } else {
                    if (isSelected == false) {

                        releaseArray = populateArray(releaseArray);
                        clearSelection();
                        setSelection(pressArray);
                        pressReleaseToggleButton.setText("PRESS");

                    } else {
                        pressArray = populateArray(pressArray);
                        clearSelection();
                        setSelection(releaseArray);
                        pressReleaseToggleButton.setText("RELEASE");

                    }
                }
            }
        });
    }
}
