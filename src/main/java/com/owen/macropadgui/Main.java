package com.owen.macropadgui;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.Stage;
import jssc.SerialPort;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    public boolean keyMapSelected = false;
    String keyMapChoice;

    @Override
    public void start(Stage stage) throws IOException {


        try {
            Parent root = FXMLLoader.load(getClass().getResource("KeyMapSelection.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


            SerialPort port = new SerialPort("COM3");
            port.openPort();
            port.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            // port.setParams(9600, 8, 1, 0); // alternate technique
            int mask = SerialPort.MASK_RXCHAR + SerialPort.MASK_CTS + SerialPort.MASK_DSR;
            port.setEventsMask(mask);
            port.addEventListener(new PortListener(port));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        launch();
    }
}