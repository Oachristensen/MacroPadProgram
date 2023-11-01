package com.owen.macropadgui;

import com.owen.macropadgui.handlers.JsonHandler;
import com.owen.macropadgui.handlers.KeyMapNameJsonHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class DeviceSelectionController implements Initializable {
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

    private Rectangle[][] rectangleList;

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

    private PortListener portListener;


    public void switchToKeymapSelection(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("KeyMapSelection.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setKeyMapName(String name) {
        keyMapName.setText(name);
    }
    public void setPortListener(PortListener activePortListener){
        portListener = activePortListener;
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

    public void uploadData(ActionEvent event) {
        String name = keyMapName.getText();
        KeyMapNameJsonHandler.uploadKeyMapNames(name);
        portListener.setKeyData();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GlobalData.getInstance().deviceSelectionController = this;
        rectangleList = new Rectangle[][]{new Rectangle[]{key1, key2, key3, key4}, new Rectangle[]{key5, key6, key7, key8}};
    }


    public void setButtonToggle(final int keyRow, final int keyCol, final boolean isPressed) {
        if (isPressed) {
            rectangleList[keyRow][keyCol].setStyle("-fx-fill: red;");
        } else {
            rectangleList[keyRow][keyCol].setStyle("-fx-fill: white;");
        }



    }
}

