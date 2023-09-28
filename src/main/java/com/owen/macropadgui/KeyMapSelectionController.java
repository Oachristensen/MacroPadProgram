package com.owen.macropadgui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class KeyMapSelectionController {
    @FXML
    private ListView<String> keyMapList;
    @FXML
    private Button selectButton;
    @FXML
    private Button createButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void checkIfKeyMapSelected(javafx.event.ActionEvent event) {
        if (keyMapList.getEditingIndex() != -1) {
            // Move to DeviceSelection with the selected Keymap
            switchToDeviceSelection(event);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Select a Keymap");
            alert.setHeaderText("No Keymap selected");
            alert.setContentText("Select a Keymap to continue");
            alert.show();
        }
    }
    public void switchToDeviceSelection(javafx.event.ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("DeviceSelection.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void setKeyMapList(ArrayList<String> list) {
        keyMapList.getItems().addAll(list);
    }
 }
