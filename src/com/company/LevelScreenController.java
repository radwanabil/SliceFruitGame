package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LevelScreenController implements Initializable {

    @FXML AnchorPane pane;
    ClassicScreen mainscreen;
    //Stage window;
    static GameScreen game;
    Receiver receiver;
    Command easyCommand;
    Command mediumCommand;
    Command hardCommand;
    MenuOptions menu;
    static StrategyInterface strategy;

    public LevelScreenController() {
        receiver=new Receiver();
        easyCommand=new easyCommand(receiver);
        mediumCommand=new mediumCommand(receiver);
        hardCommand=new hardCommand(receiver);
        menu= new MenuOptions(easyCommand,mediumCommand,hardCommand);
    }

   // public void getWindow(Stage stage){this.window = stage;}
    @FXML
    void easy(ActionEvent event) throws IOException {
       menu.clickEasy();
      Stage currentStage = (Stage) pane.getScene().getWindow();
        currentStage.setScene(game.getScene());
        currentStage.show();
    }

    @FXML
    void medium(ActionEvent event) throws IOException {
       menu.clickMedium();
        Stage currentStage = (Stage) pane.getScene().getWindow();
        currentStage.setScene(game.getScene());
        currentStage.show();
    }

    @FXML
    void hard(ActionEvent event) throws IOException {
        menu.clickHard();
        Stage currentStage = (Stage) pane.getScene().getWindow();
        currentStage.setScene(game.getScene());
        currentStage.show();

    }

    @FXML
    void back(ActionEvent event) throws IOException {
        pane = FXMLLoader.load(getClass().getResource("FirstScreen.fxml"));
        Scene first = new Scene(pane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(first);
        window.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
   // FirstScreenController.mediaPlayer.play();
    }


}
