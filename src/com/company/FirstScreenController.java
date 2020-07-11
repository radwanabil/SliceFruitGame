package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FirstScreenController implements Initializable {

    @FXML
    private Label scoreLabel;
    @FXML
    AnchorPane pane;
    StrategyInterface strategy;
    static GameScreen game;
    Classic classic;
    Timed timed;
    Save save;
    Receiver receiver;
    Command easyCommand;
    Command mediumCommand;
    Command hardCommand;
    MenuOptions menu;
   // LevelScreenController levelscreen;
    static MediaPlayer mediaPlayer;
    static Media music;
    ClassicScreen classicScreen;
    ArcadeScreen arcadeScreen;
    public FirstScreenController() {
        classic = Classic.getClassic();
        classicScreen = ClassicScreen.getClassicScreen();
        timed = Timed.getTimed();
        arcadeScreen = ArcadeScreen.getArcadeScreen();
        save=Save.getSave();
    //    levelscreen = new LevelScreenController();
        music = new Media(new File("mainSong.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(music);
        receiver=new Receiver();
        easyCommand=new easyCommand(receiver);
        mediumCommand=new mediumCommand(receiver);
        hardCommand=new hardCommand(receiver);
        menu= new MenuOptions(easyCommand,mediumCommand,hardCommand);
    }

    public void setStrategy(StrategyInterface strategy)
    {
        LevelScreenController.strategy= strategy;
    }
    @FXML
    void classic(ActionEvent event) throws IOException {
        //setStrategy(classic);

        setStrategy(classic);
        //strategy.newGame();
        ClassicScreen.load = false;
        pane = FXMLLoader.load(getClass().getResource("LevelScreen.fxml"));
        Scene first = new Scene(pane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(first);
        window.show();
    }

    @FXML
    void highScore(ActionEvent event) throws IOException {
        pane = FXMLLoader.load(getClass().getResource("HighScoresScreen.fxml"));
        Scene first = new Scene(pane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(first);
        window.show();

    }
    @FXML
    void load(ActionEvent event) throws IOException {
     int i= save.load();
     ClassicScreen.load = true;
     System.out.println("dasjdiasojfoidasjf"+i);
     if(i==1){
         setStrategy(timed);
         arcadeScreen.score = save.score;
         arcadeScreen.seconds = save.seconds;
         menu.clickEasy();
         Stage currentStage = (Stage) pane.getScene().getWindow();
         currentStage.setScene(LevelScreenController.game.getScene());
         currentStage.show();
     }
     else if(i==2)
        {
            setStrategy(timed);
            arcadeScreen.score = save.score;
            arcadeScreen.seconds = save.seconds;
            menu.clickMedium();
            Stage currentStage = (Stage) pane.getScene().getWindow();
            currentStage.setScene(LevelScreenController.game.getScene());
            currentStage.show();
        }
     else if(i==3){
         setStrategy(timed);
         arcadeScreen.score = save.score;
         arcadeScreen.seconds = save.seconds;
         menu.clickHard();
         Stage currentStage = (Stage) pane.getScene().getWindow();
         currentStage.setScene(LevelScreenController.game.getScene());
         currentStage.show();
     }
     else if(i==4)
     {
         setStrategy(classic);
         classicScreen.score = save.score;
         classicScreen.setSeconds(save.seconds);
         menu.clickEasy();
         Stage currentStage = (Stage) pane.getScene().getWindow();
         currentStage.setScene(LevelScreenController.game.getScene());
         currentStage.show();
     }
     else if(i==5){
         setStrategy(classic);
         classicScreen.score = save.score;
         classicScreen.setSeconds(save.seconds);
         menu.clickMedium();
         Stage currentStage = (Stage) pane.getScene().getWindow();
         currentStage.setScene(LevelScreenController.game.getScene());
         currentStage.show();
     }
     else if(i==6){
         setStrategy(classic);
         classicScreen.score = save.score;
         classicScreen.setSeconds(save.seconds);
         menu.clickHard();
         Stage currentStage = (Stage) pane.getScene().getWindow();
         currentStage.setScene(LevelScreenController.game.getScene());
         currentStage.show();
     }

    }

    @FXML
    void archade(ActionEvent event) throws IOException {
        setStrategy(timed);
       // strategy.newGame();
        ClassicScreen.load = false;
        pane = FXMLLoader.load(getClass().getResource("LevelScreen.fxml"));
        Scene first = new Scene(pane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(first);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mediaPlayer.play();
    }
}
