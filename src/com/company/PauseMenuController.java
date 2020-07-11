package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;

public class PauseMenuController implements Initializable {

    int level;
    @FXML AnchorPane pane;
   static Stage previousStage;
   ClassicScreen classicScreen;
  // boolean soundmute,musicmute;
   GameScreen game;
    Classic classic;
   Timed arcade;
   Save save;
    //ArcadeScreen arcadescreen;
    ArcadeScreen arcadescreen;
    public PauseMenuController()
    {
        previousStage = new Stage();
        arcadescreen = ArcadeScreen.getArcadeScreen();
        classicScreen = ClassicScreen.getClassicScreen();
        //arcadescreen = ArcadeScreen.getArcadeScreen();
        classic = Classic.getClassic();
        arcade = Timed.getTimed();
        save=Save.getSave();

    }
    @FXML
    void resume(ActionEvent event) throws IOException {
      FirstScreenController.mediaPlayer.play();
        if(LevelScreenController.strategy.equals(classic)) {
            classicScreen.flag = 0;
            classicScreen.timer.start();
            Stage currentStage = (Stage) pane.getScene().getWindow();
            classicScreen.doTime();
            classicScreen.pause.setDisable(false);
            currentStage.close();
        }
        else if(LevelScreenController.strategy.equals(arcade))
        {
            arcadescreen.flag=0;
           arcadescreen.timer.start();
           arcadescreen.pause.setDisable(false);
            Stage currentStage = (Stage) pane.getScene().getWindow();
            arcadescreen.doTime();
            currentStage.close();
        }
    }

    @FXML
    void reset(ActionEvent event) throws IOException {
        if(LevelScreenController.strategy.equals(classic))
        {
            Stage currentStage = (Stage) pane.getScene().getWindow();
            Stage previousStage = (Stage) classicScreen.pane.getScene().getWindow();
            classicScreen.drawGame(classicScreen.min,classicScreen.max);
            previousStage.setScene(classicScreen.getScene());
            classicScreen.pause.setDisable(false);
            currentStage.close();
            previousStage.show();
        }
        else if(LevelScreenController.strategy.equals(arcade))
        {
            Stage currentStage = (Stage) pane.getScene().getWindow();
            Stage previousStage = (Stage) arcadescreen.pane.getScene().getWindow();
            arcadescreen.drawGame(arcadescreen.min,arcadescreen.max);
            previousStage.setScene(arcadescreen.getScene());
            arcadescreen.pause.setDisable(false);
            currentStage.close();
            previousStage.show();
        }
    }
    @FXML
    void save(ActionEvent event) {
        if(LevelScreenController.strategy.equals(classic))
        {
            save.save(classicScreen.lives, classicScreen.score, classicScreen.getSeconds(), classicScreen.min,classicScreen.max);
        }
        else if(LevelScreenController.strategy.equals(arcade))
        {
            save.save(7, arcadescreen.score, arcadescreen.getSeconds(), arcadescreen.min,arcadescreen.max);
        }

    }

    @FXML
    void newGame(ActionEvent event)
    {
        Parent root = null;
        try {
            root =FXMLLoader.load(getClass().getResource("FirstScreen.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage currentStage = (Stage) pane.getScene().getWindow();
        if(LevelScreenController.strategy.equals(classic))
        {
            Stage previousStage = (Stage) classicScreen.pane.getScene().getWindow();
        }
        else if(LevelScreenController.strategy.equals(arcade))
        {
            Stage previousStage = (Stage) arcadescreen.pane.getScene().getWindow();
        }
        Scene scene = new Scene(root);
        previousStage.setScene(scene);
        currentStage.close();
        previousStage.show();
    }
    @FXML
    public void sound(ActionEvent event)
    {
        if(LevelScreenController.strategy.equals(classic))
        {
            if(ClassicScreen.soundmute == false)
            {
               // classicScreen.Explosion.setMute(true);
                /*classicScreen.fawakeh.setMute(true);
                classicScreen.konbelasound.setMute(true);
                classicScreen.mediaPlayer.setMute(true);
                */ClassicScreen.soundmute = true;
            }
            else
            {
                //classicScreen.Explosion.setMute(false);
                /*classicScreen.fawakeh.setMute(false);
                classicScreen.konbelasound.setMute(false);
                classicScreen.mediaPlayer.setMute(false);*/
                ClassicScreen.soundmute = false;
            }
        }
        else
        {
            if(arcadescreen.soundmute == false)
            {
                arcadescreen.soundmute = true;
            }
            else
            {
                arcadescreen.soundmute = false;
            }
        }
    }
    @FXML
    public void music(ActionEvent event)
    {
        if(ClassicScreen.musicmute==false)
        {
            FirstScreenController.mediaPlayer.setVolume(0.0);
            ClassicScreen.musicmute = true;
        }
        else
        {
            FirstScreenController.mediaPlayer.setVolume(0.3);
            ClassicScreen.musicmute = false;
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
