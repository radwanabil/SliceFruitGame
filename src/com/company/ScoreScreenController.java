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

public class ScoreScreenController implements Initializable {

    @FXML
    AnchorPane pane;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label highScoreLabel;
    ArcadeScreen arcadeScreen;
    @FXML
    void exit(ActionEvent event) throws IOException {

        Stage window =(Stage) pane.getScene().getWindow();
        window.close();

    }

    @FXML
    void menu(ActionEvent event) {
        try {
            pane = FXMLLoader.load(getClass().getResource("FirstScreen.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene first = new Scene(pane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        FirstScreenController.mediaPlayer.play();
        window.setScene(first);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        arcadeScreen= ArcadeScreen.getArcadeScreen();
        highScoreLabel.setText(""+arcadeScreen.score);
    }
}
