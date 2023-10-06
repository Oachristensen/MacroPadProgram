package com.owen.macropadgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.*;
import javafx.stage.Stage;


public class DeviceSelectionController {
    @FXML
    private TextField keyMapName = new TextField();
    @FXML
    private Button uploadButton;
    @FXML
    private Button backButton;

    @FXML
    private Rectangle key1;
    @FXML
    private Rectangle key2;
    @FXML
    private Rectangle key3;
    @FXML
    private Rectangle key4;
    @FXML
    private Rectangle key5;
    @FXML
    private Rectangle key6;
    @FXML
    private Rectangle key7;
    @FXML
    private Rectangle key8;

    @FXML
    private Circle knob1;
    @FXML
    private Circle knob2;
    @FXML
    private Circle knob3;

    @FXML
    private Button knob1Left;
    @FXML
    private Button knob2Left;
    @FXML
    private Button knob3Left;

    @FXML
    private Button knob1Right;
    @FXML
    private Button knob2Right;
    @FXML
    private Button knob3Right;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private int keyMapChoice;


    public void switchToKeymapSelection(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("KeyMapSelection.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setKeyMapName(String name) {
        keyMapName.setText(name);
    }

    public void switchToFunctionSelection(MouseEvent event) {
        GlobalData.getInstance().selectedItemID = (((Node) event.getSource()).getId());
        try {

            Parent root = FXMLLoader.load(getClass().getResource("FunctionSelection.fxml"));
            Stage secondStage = new Stage();
            secondStage.setResizable(false);
            secondStage.setScene(new Scene(root));
            secondStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

