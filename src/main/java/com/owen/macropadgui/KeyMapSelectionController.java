package com.owen.macropadgui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
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

import java.net.URL;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.ResourceBundle;

public class KeyMapSelectionController implements Initializable {
    @FXML
    private ListView<String> keyMapList;

    @FXML
    private Button selectButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private static final SerialPort port = new SerialPort("COM3");






    public void checkIfKeyMapSelected(ActionEvent event) {
        if (GlobalData.getInstance().selectedKeyMap != -1) {
            switchToDeviceSelection(event);

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Select a Keymap");
            alert.setHeaderText("No Keymap selected");
            alert.setContentText("Select a Keymap to continue");
            alert.show();
        }
    }

    public void switchToDeviceSelection(ActionEvent event) {
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
            if (!port.isOpened()) {
                port.openPort();
                port.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                // port.setParams(9600, 8, 1, 0); // alternate technique
                int mask = SerialPort.MASK_RXCHAR + SerialPort.MASK_CTS + SerialPort.MASK_DSR;
                port.setEventsMask(mask);
                port.addEventListener(new PortListener(port, this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        KeyMapNameJsonHandler keyMapNameJsonHandler = new KeyMapNameJsonHandler(this);
        ArrayList<String> list = keyMapNameJsonHandler.getList();
        keyMapList.getItems().addAll(list);
        keyMapList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                GlobalData.getInstance().selectedKeyMap = keyMapList.getSelectionModel().getSelectedIndex();
                System.out.println(GlobalData.getInstance().selectedKeyMap);
            }

        });
    }
}
