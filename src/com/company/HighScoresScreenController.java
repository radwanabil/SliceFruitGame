package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HighScoresScreenController implements Initializable {
    ClassicScreen classicScreen;

    @FXML
    private Label classicLabel;

    @FXML
    private Label arcadeLabel;
    @FXML
    AnchorPane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    highScore highscore = highScore.getHighscore();
        String str= null;
        try {
            str = highscore.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        classicLabel.setText(str);
        String str1= null;
        try {
            str1 = highscore.loadArcade();
        } catch (IOException e) {
            e.printStackTrace();
        }
        arcadeLabel.setText(str1);
    }
    @FXML
    void back(ActionEvent event) throws IOException {
        pane = FXMLLoader.load(getClass().getResource("FirstScreen.fxml"));
        Scene first = new Scene(pane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(first);
        window.show();
    }
}
