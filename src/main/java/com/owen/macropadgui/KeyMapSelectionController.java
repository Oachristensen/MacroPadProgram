package com.owen.macropadgui;

import com.owen.macropadgui.DeviceSelectionController;
import com.owen.macropadgui.GlobalData;
import com.owen.macropadgui.PortListener;
import com.owen.macropadgui.handlers.KeyMapNameJsonHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Pair;
import jssc.SerialPort;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class KeyMapSelectionController implements Initializable {
    @FXML
    private ListView<Pair<String, String>> keyMapList;

    @FXML
    private Button selectButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private static final SerialPort port = new SerialPort("COM3");

    private static PortListener portListener;





    public void checkIfKeyMapSelected(ActionEvent event) {
        if (GlobalData.getInstance().selectedKeyMap != null) {
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
//            String name = keyMapList.getSelectionModel().getSelectedItem();
//            deviceSelectionController.setKeyMapName(name);

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
                port.addEventListener(portListener = new PortListener(port, this));
            }
            portListener.setKeyData(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        keyMapList.setCellFactory(param -> new ListCell<Pair<String, String>>() {
            @Override
            protected void updateItem(Pair<String, String> pair, boolean empty) {
                super.updateItem(pair, empty);
                if (empty || pair == null || pair.getKey() == null) {
                    setText(null);
                } else {
                    setText(pair.getValue());
                }
            }
        });
        keyMapList.getChildrenUnmodifiable().addListener(new ListChangeListener<Node>() {
            @Override
            public void onChanged(Change<? extends Node> change) {
            }
        });
        KeyMapNameJsonHandler keyMapNameJsonHandler = new KeyMapNameJsonHandler(this);
        ArrayList<Pair<String, String>> list = keyMapNameJsonHandler.getList();
        keyMapList.getItems().addAll(list);
        keyMapList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends Pair<String, String>> observableValue, Pair<String, String> pair, Pair<String, String> selectedValue) {
                System.out.println(selectedValue);
                GlobalData.getInstance().selectedKeyMap = selectedValue.getKey();
                System.out.println(GlobalData.getInstance().selectedKeyMap);
            }

        });
    }
}
