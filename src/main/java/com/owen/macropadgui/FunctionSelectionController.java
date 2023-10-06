package com.owen.macropadgui;


import com.almasb.fxgl.core.collection.Array;
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
            if (!keyTextFieldList.get(i).getText().isBlank()) {
                newArray[i] = (keyTextFieldList.get(i).getText());
            }
            else if (functionTreeViewList.get(i).getSelectionModel().getSelectedItem() != null) {
                newArray[i] = (functionTreeViewList.get(i).getSelectionModel().getSelectedItem().toString());
                functionTreeViewIndexList.put(i, functionTreeViewList.get(i).getSelectionModel().getSelectedIndex());
            }
            else if (keyTextFieldList.get(i).getText().isBlank() && functionTreeViewList.get(i).getSelectionModel().getSelectedItem() == null) {
                newArray[i] = (" ");
            }

        }
        return newArray;
    }

    private void clearSelection() {
        for (Integer i : keyTextFieldList.keySet()) {
        keyTextFieldList.get(i).setText("");
        functionTreeViewList.get(i).setSelectionModel(null);
    }
    }
    private void setSelection(String[] array) {
            for (Integer i : keyTextFieldList.keySet()) {
                keyTextFieldList.get(i).setText(array[i]);
//                functionTreeViewList.get(i).getSelectionModel().select(functionTreeViewIndexList.get(i));

        }
    }


    public void exitFunctionSelection(ActionEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void getKeyData() {
        int keyMapID = GlobalData.getInstance().selectedKeyMap;
        String itemID = GlobalData.getInstance().selectedItemID;
//        ArrayList<String> inputList = populateArray();
//        //TODO This is not how this function should work
//        JsonHandler.putKeyData(itemID, inputList, keyMapID);
    }
    public void emptyStringArray(String[] array){
        Arrays.fill(array, (""));
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


        pressReleaseToggleButton.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean isSelected) {
                if (isSelected == false) {

                    Arrays.fill(pressArray, (""));
                    pressArray = populateArray();
                    clearSelection();
                    setSelection(pressArray);
                    pressReleaseToggleButton.setText("PRESS");

                } else {
                    Arrays.fill(releaseArray, (""));
                    releaseArray = populateArray();
                    clearSelection();
                    setSelection(releaseArray);
                    pressReleaseToggleButton.setText("RELEASE");

                }
            }
        });
    }
}
