package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InstructionsController implements Initializable {
    @FXML
    AnchorPane pane;
    @FXML
    Label label;
    ClassicScreen classicScreen;
    Classic classic;
    ArcadeScreen arcadescreen;
    Timed arcade;
    public InstructionsController(){
        classicScreen = ClassicScreen.getClassicScreen();
        arcadescreen = ArcadeScreen.getArcadeScreen();
        classic = Classic.getClassic();
        arcade = Timed.getTimed();
    }
    @FXML
    void back(ActionEvent event) throws IOException {
        FirstScreenController.mediaPlayer.play();
        if(LevelScreenController.strategy.equals(classic)) {
            classicScreen.flag = 0;
            classicScreen.timer.start();
            Stage currentStage = (Stage) pane.getScene().getWindow();
            classicScreen.doTime();
            classicScreen.instructions.setDisable(false);
            currentStage.close();
        }
        else if(LevelScreenController.strategy.equals(arcade))
        {
            arcadescreen.flag=0;
            arcadescreen.timer.start();
           // arcadescreen.instructions.setDisable(false);
            Stage currentStage = (Stage) pane.getScene().getWindow();
            arcadescreen.doTime();
            arcadescreen.instructions.setDisable(false);
            currentStage.close();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(LevelScreenController.strategy.equals(classic))
            label.setText("There is no time limit, you got 3 lives. You lose a life when a fruit falls without slicing or slicing a black bomb." +
                    "El Moza el Zar2a proves that the myth is true and restores a lost life and blue bateekha gives you extra 5 points.");
        else
        {
            label.setText("In this mode you have 6 seconds to cut as many fruits as you can. The black bomb removes 7 seconds and the red one ends the game " +
                    "El Moza el zar2a gives you extra 5 seconds and blue bateekha adds 10 points.");
        }
    }
}
