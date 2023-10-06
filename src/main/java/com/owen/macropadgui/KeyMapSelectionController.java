package com.owen.macropadgui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import jssc.SerialPort;

import javax.sound.sampled.Port;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class KeyMapSelectionController implements Initializable {
    @FXML
    private ListView<String> keyMapList;

    @FXML
    private Button selectButton;

    private Stage stage;
    private Scene scene;
    private Parent root;


    private int keyMapChoice;






    public void checkIfKeyMapSelected(javafx.event.ActionEvent event) {
        if (getKeyMapChoice() != -1) {
            switchToDeviceSelection(event);
            PortListener portListener = new PortListener(this);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Select a Keymap");
            alert.setHeaderText("No Keymap selected");
            alert.setContentText("Select a Keymap to continue");
            alert.show();
        }
    }

    public void switchToDeviceSelection(javafx.event.ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DeviceSelection.fxml"));
            root = loader.load();

            DeviceSelectionController deviceSelectionController = loader.getController();
            String name = keyMapList.getSelectionModel().getSelectedItem();
            deviceSelectionController.setKeyMapName(name);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getKeyMapChoice() {
        return keyMapChoice;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        keyMapChoice = -1;
        KeyMapNameJsonHandler keyMapNameJsonHandler = new KeyMapNameJsonHandler(this);
        ArrayList<String> list = keyMapNameJsonHandler.getList();
        keyMapList.getItems().addAll(list);
        keyMapList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                keyMapChoice = keyMapList.getSelectionModel().getSelectedIndex();
                String name = keyMapList.getSelectionModel().getSelectedItem();
                System.out.println(name);


            }

        });
    }
}
