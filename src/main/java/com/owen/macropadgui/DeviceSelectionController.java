package com.owen.macropadgui;

import com.owen.macropadgui.GlobalData;
import com.owen.macropadgui.handlers.KeyMapNameJsonHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;
import org.json.simple.JSONObject;

import java.util.ArrayList;


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
    private Circle button1;
    @FXML
    private Circle button2;
    @FXML
    private Circle button3;

    @FXML
    private Button knob1;
    @FXML
    private Button knob2;
    @FXML
    private Button knob3;

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

    public void uploadNameData(ActionEvent event) {
        String name = keyMapName.getText();
        KeyMapNameJsonHandler.uploadKeyMapNames(name);

    }
}

