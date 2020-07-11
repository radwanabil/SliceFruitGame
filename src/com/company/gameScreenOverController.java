package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class gameScreenOverController implements Initializable {

    @FXML
    AnchorPane pane;
    @FXML
    ImageView imageview;
    @FXML
            Label label;
    StrategyInterface strategy;
    ClassicScreen classicscreen;
    ArcadeScreen arcadescreen;
    Classic classic;
    Timed arcade;
    Media crowd;
    MediaPlayer mediaplayer;
    public gameScreenOverController() {
        classicscreen = ClassicScreen.getClassicScreen();
        arcadescreen = ArcadeScreen.getArcadeScreen();
        classic = Classic.getClassic();
        arcade = Timed.getTimed();
        crowd = new Media(new File("crowd.mp3").toURI().toString());
        mediaplayer = new MediaPlayer(crowd);
    }
    @FXML
    void exit(ActionEvent event) throws IOException {

        Stage window =(Stage) pane.getScene().getWindow();
        window.close();

    }

    @FXML
    void menu(ActionEvent event) {
        mediaplayer.setMute(true);
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

        FirstScreenController.mediaPlayer.pause();
        if(LevelScreenController.strategy.equals(classic))
        {
            label.setText(""+classicscreen.score);
            //classicscreen.Explosion.play();
            if(classicscreen.high == true)
            {
                mediaplayer.play();
                mediaplayer.setMute(false);
                imageview.setImage(new Image("scoreGIF.gif"));
            }
        }
        else if(LevelScreenController.strategy.equals(arcade))
        {
            if(arcadescreen.high == true)
            {
                mediaplayer.play();
                mediaplayer.setMute(false);
                imageview.setImage(new Image("scoreGIF.gif"));
            }
        }
    }
}
