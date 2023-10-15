package com.owen.macropadgui;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.Stage;
import jssc.SerialPort;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

/*TODO
Store function data in a label that can be diplayed when opened
Saving keymap names and writing on upload
Adding functionality to the Treeview selection
Fixing bugs/Fixing old stuff:
   Go through and check names
   make things static/final if possible
   remove unnecessary things
   comments?


    */


    @Override
    public void start(Stage stage){


        try {
            Parent root = FXMLLoader.load(getClass().getResource("KeyMapSelection.fxml"));
            Scene scene = new Scene(root);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        launch();
    }
}