package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
Stage window;
    //static Thread thread = new Thread();
    public static void main(String[] args) throws Exception {

        launch(args);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       Stage window=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("FirstScreen.fxml"));
        Scene scene = new Scene(root);
        window.setResizable(false);
        window.setScene(scene);
        window.show();
    }
}
