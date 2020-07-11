package com.company;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;


public class ClassicScreen implements GameScreen
{
    MediaPlayer mediaPlayer;
    MediaPlayer konbelasound;
    MediaPlayer Explosion;
    MediaPlayer fawakeh;
    Media music1;
    Media music2;
    Media sound3;
    static boolean soundmute,musicmute;
        Group pane;
        Canvas canvas;
        Scene scene;
        Button pause;
        Button instructions;
        Label scorelabel;
        int score=0,min=0,max=0;
        Label lb;
        Label HighScore;
        gameScreenOverController gameover;
        AnimationTimer timer;
       // ArrayList<Sprite> spritesOnScreen;// = new ArrayList<>();
        //ArrayList<Fruits> fruits ;//= new ArrayList<>();
        ArrayList<Objects> objects ;
        ArrayList<Objects> sliced;
        ArrayList<SpecialFruits> labels;
        ArrayList<Konbela> labels2;
        private final Integer starttime=0;
        int flag=0;
        int lives=0;
        boolean high;
        FruitsFactory Fruit;
        highScore highscore;
        Button life1;
        Button life2;
        Button life3;
        Button life;
        static boolean load;
        blueBateeekha bluebateekha;
        Save save;
        MozetElNagah moza;
        PauseMenuController pausemenu;
        private static ClassicScreen classicScreen;
        private Integer seconds= starttime;
        private ClassicScreen(){
            highscore = highScore.getHighscore();
            //lives =0;
            canvas = new Canvas();
            pause = new Button();
            instructions = new Button();
            scorelabel = new Label();
           // score = 0;
            lb = new Label();
            HighScore = new Label();
            Fruit = new FruitsFactory();
            music1 = new Media(new File("Bomb.mp3").toURI().toString());
            music2 = new Media(new File("bombBomb.mp3").toURI().toString());
            sound3 = new Media(new File("fallingFruits.mp3").toURI().toString());
            save = Save.getSave();
            life = new Button();
            //gameover = new gameScreenOverController();
        }
         public static ClassicScreen getClassicScreen()
        {
            if(classicScreen == null)
                classicScreen = new ClassicScreen();
            return classicScreen;
        }

    public Integer getSeconds() {
        return seconds;
    }
    public void setSeconds(int seconds)
    {
        this.seconds = seconds;
    }

    @Override
        public void drawGame(int min,int max) throws IOException{
            FirstScreenController.mediaPlayer.setVolume(0.3);
            high = false;
            gameover = new gameScreenOverController();
            bluebateekha = new blueBateeekha();
            moza = new MozetElNagah();
            //konbelasound = new MediaPlayer(music1);
            //Explosion = new MediaPlayer(music2);
            //fawakeh = new MediaPlayer(sound3);
            this.min=min;
            this.max=max;
            pane = new Group();
            if(load == false) {
                seconds = 0;
                flag = 0;
                score = 0;
                lives = 0;
            }
            else
            {
                seconds = save.seconds;
                flag = 0;
                score = save.score;
            }
            objects = new ArrayList<>();
            labels = new ArrayList<>();
            labels2 = new ArrayList<>();
            ///fruits = new ArrayList<>();
            sliced = new ArrayList<>();
            scene = new Scene(pane, 800, 500);
            Canvas canvas = new Canvas(800, 500);

            Image image = new Image("background.jpg");
            pause.setTranslateX(720);
            pause.setTranslateY(10);
            pause.setDisable(false);
        pause.setGraphic(new ImageView("pause.png"));
        instructions.setTranslateX(725);
        instructions.setTranslateY(70);
        instructions.setStyle("-fx-background-color: transparent ");
        instructions.setGraphic(new ImageView("questionMark.png"));
        lb.setText("Time: "+seconds);
            lb.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
            lb.setTextFill(Color.web("#ff3e3e"));
            lb.setTranslateX(350);
            lb.setTranslateY(14);
            scorelabel.setTranslateX(110);
            scorelabel.setTranslateY(14);
            scorelabel.setText("Your score: "+score);
            scorelabel.setTextFill(Color.web("#1ba157"));
            scorelabel.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
            HighScore.setText("High score: "+highscore.loadHighClassic());
            HighScore.setTranslateY(45);
            HighScore.setTranslateX(110);
            HighScore.setTextFill(Color.web("#1ba157"));
            HighScore.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
            pause.setStyle("-fx-background-color: transparent ");
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.drawImage(image, 0, 0);
            life1 = new Button();
            life2 = new Button();
            life3 = new Button();
            life1.setGraphic(new ImageView("stickman.png"));
            life2.setGraphic(new ImageView("stickman.png"));
            life3.setGraphic(new ImageView("stickman.png"));
            life1.setTranslateX(650);
            life1.setTranslateY(420);
            life2.setTranslateX(690);
            life2.setTranslateY(420);
            life3.setTranslateX(730);
            life3.setTranslateY(420);
            life.setVisible(false);
        if(lives ==1)
        {
            life1.setGraphic(new ImageView("deadstickman.png"));
        }
        else if(lives ==2)
        {
            life2.setGraphic(new ImageView("deadstickman.png"));
        }
        else if(lives ==3)
        {
            life3.setGraphic(new ImageView("deadstickman.png"));
        }
            life1.setStyle("-fx-background-color: transparent ");
            life2.setStyle("-fx-background-color: transparent ");
            life3.setStyle("-fx-background-color: transparent ");
            pane.getChildren().addAll(canvas,pause,scorelabel,lb,HighScore,life1,life2,life3,life,instructions);

            if(flag==0)
            {
                doTime();
                timer = new AnimationTimer() {
                    @Override
                    public void handle(long arg0) {
                        try {
                            GameUpdate(gc);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                };
                timer.start();
            }

            pause.setOnAction(new EventHandler<ActionEvent>()
            {

                @Override
                public void handle(ActionEvent event) {
                    pausemenu = new PauseMenuController();
                    flag =1;
                    timer.stop();
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Stage currentStage = (Stage) pane.getScene().getWindow();
                    PauseMenuController.previousStage = (Stage) pane.getScene().getWindow();
                   // pausemenu.getScreen(pausemenu.classicScreen);
                    pausemenu.level =1;
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    pause.setDisable(true);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.initStyle(StageStyle.UNDECORATED);
                    FirstScreenController.mediaPlayer.pause();
                    stage.show();
                }

            });
            instructions.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    flag =1;
                    timer.stop();
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("instructions.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Stage currentStage = (Stage) pane.getScene().getWindow();
                 //   PauseMenuController.previousStage = (Stage) pane.getScene().getWindow();
                    // pausemenu.getScreen(pausemenu.classicScreen);
                    //pausemenu.level =1;
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    instructions.setDisable(true);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.initStyle(StageStyle.UNDECORATED);
                    FirstScreenController.mediaPlayer.pause();
                    stage.show();
                }
            });
            }
   // }
        public int rand(int min, int max) {
        return (int)(Math.random() * max + min);
        }

        public void doTime() {
            Timeline time= new Timeline();
            KeyFrame frame= new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){

                    @Override
                    public void handle(ActionEvent event) {
                        seconds++;
                        lb.setText("Time: "+seconds.toString());
                        if( flag==1 ){
                            time.stop();
                        }
                        if(seconds%2 == 0) {
                            FruitsFactory Fruit = new FruitsFactory();
                            Fruits newFruit = Fruit.getFruit(min,max);
                            newFruit.sprite.setPosY(499);
                            newFruit.sprite.setPosX(rand(10,720));
                            //spritesOnScreen.add(newFruit.sprite);
                            objects.add(newFruit);
                        }
                        if(seconds%5 == 0) {
                                KonbelaFactory konbela = new KonbelaFactory();
                                Konbela newKonbela = konbela.getKonbela();
                                newKonbela.sprite.setPosX(rand(10,720));
                                newKonbela.sprite.setPosY(499);
                                //spritesOnScreen.add(newKonbela.sprite);
                                objects.add(newKonbela);
                        }
                        if(seconds%10==0) {
                                SpecialFruitsFactory specialfruit = new SpecialFruitsFactory();
                                SpecialFruits newSpecialFruit = specialfruit.getSpecialFruit();
                                newSpecialFruit.sprite.setPosX(rand(10,720));
                                newSpecialFruit.sprite.setPosY(499);
                                //spritesOnScreen.add(newSpecialFruit.sprite);
                                objects.add(newSpecialFruit);
                        }
                    }
                });

                time.setCycleCount(Timeline.INDEFINITE);
                time.getKeyFrames().addAll(frame);
                if(time!=null){
                    time.stop();
                }
                time.play();
            }

        private  void GameUpdate(GraphicsContext  gc) throws IOException {
            gc.clearRect(0,0,800,500);
            Image image = new Image("background.jpg");
            gc.drawImage(image, 0, 0);
            for (int i=0;i<objects.size();i++) {
                objects.get(i).sprite.updateLocation();
                objects.get(i).sprite.render(gc);
            }
          //  scene.setCursor(Cursor.NONE);
                scene.setOnMouseDragged(e ->
                {
                    if (flag == 0) {
                        Media musicFile = new Media(new File("sliceSound.mp3").toURI().toString());
                        //mediaPlayer.play();
                        double x = e.getX();
                        double y = e.getY();
                        //Image blade = new Image("sword.png");
                        //scene.setCursor(new ImageCursor(blade));
                        for (int i = 0; i < objects.size(); i++) {
                            if (objects.get(i).sprite.contains(e.getX(), e.getY())) {
                                if (objects.get(i).type == 1) {
                                    if(soundmute!=true)
                                    {
                                        mediaPlayer = new MediaPlayer(musicFile);
                                        mediaPlayer.play();
                                    }
                                    sliced.add(objects.get(i));
                                    for (int k = 0; k < sliced.size(); k++) {
                                        if (sliced.get(k).equals(objects.get(i))) {
                                            sliced.get(k).half1.posY = objects.get(i).sprite.posY;
                                            sliced.get(k).half2.posY = objects.get(i).sprite.posY;
                                            sliced.get(k).half1.posX = objects.get(i).sprite.posX + 70;
                                            sliced.get(k).half2.posX = objects.get(i).sprite.posX;
                                        }
                                    }
                                    objects.remove(i);
                                    score++;
                                    scorelabel.setText("Your Score: " + score);
                                } else if (objects.get(i).type == 2) {
                                    if(soundmute!=true)
                                    {
                                        mediaPlayer = new MediaPlayer(musicFile);
                                        mediaPlayer.play();
                                    }
                                    sliced.add(objects.get(i));
                                    for (int k = 0; k < sliced.size(); k++) {
                                        if (sliced.get(k).equals(objects.get(i))) {
                                            sliced.get(k).half1.posY = objects.get(i).sprite.posY;
                                            sliced.get(k).half2.posY = objects.get(i).sprite.posY;
                                            sliced.get(k).half1.posX = objects.get(i).sprite.posX + 70;
                                            sliced.get(k).half2.posX = objects.get(i).sprite.posX;
                                        }
                                    }
                                    objects.remove(i);
                                    score++;
                                    scorelabel.setText("Your Score: " + score);
                                } else if (objects.get(i).type == 3) {
                                    sliced.add(objects.get(i));
                                    if(soundmute!=true)
                                    {
                                        mediaPlayer = new MediaPlayer(musicFile);
                                        mediaPlayer.play();
                                    }
                                    for (int k = 0; k < sliced.size(); k++) {
                                        if (sliced.get(k).equals(objects.get(i))) {
                                            sliced.get(k).half1.posY = objects.get(i).sprite.posY;
                                            sliced.get(k).half2.posY = objects.get(i).sprite.posY;
                                            sliced.get(k).half1.posX = objects.get(i).sprite.posX + 70;
                                            sliced.get(k).half2.posX = objects.get(i).sprite.posX;
                                        }
                                    }
                                    objects.remove(i);
                                    score++;
                                    scorelabel.setText("Your Score: " + score);
                                }
                                else if(objects.get(i).type==4)
                                {
                                    sliced.add(objects.get(i));
                                    labels.add((SpecialFruits) objects.get(i));
                                    if(soundmute!=true)
                                    {
                                        mediaPlayer = new MediaPlayer(musicFile);
                                        mediaPlayer.play();
                                    }
                                    for (int k = 0; k < sliced.size(); k++) {
                                        if (sliced.get(k).equals(objects.get(i))) {
                                            sliced.get(k).half1.posY = objects.get(i).sprite.posY;
                                            sliced.get(k).half2.posY = objects.get(i).sprite.posY;
                                            sliced.get(k).half1.posX = objects.get(i).sprite.posX + 70;
                                            sliced.get(k).half2.posX = objects.get(i).sprite.posX;
                                        }
                                    }
                                    for(int k =0;k<labels.size();k++)
                                    {
                                        if(labels.get(k).equals(objects.get(i)))
                                        {
                                            labels.get(k).label.posX = objects.get(i).sprite.posX+30;
                                            labels.get(k).label.posY = objects.get(i).sprite.posY;
                                        }
                                    }
                                    moza.bonus();
                                    objects.remove(i);
                                    score++;
                                    System.out.println("LIVES"+ lives);
                                    if(lives<=0)
                                    {
                                        lives =0;
                                        life1.setGraphic(new ImageView("stickman.png"));
                                        life2.setGraphic(new ImageView("stickman.png"));
                                        life3.setGraphic(new ImageView("stickman.png"));
                                    }
                                    else if(lives==1)
                                    {
                                        life1.setGraphic(new ImageView("deadstickman.png"));
                                        life2.setGraphic(new ImageView("stickman.png"));
                                        life3.setGraphic(new ImageView("stickman.png"));
                                    }
                                    else if(lives == 2)
                                    {
                                        life1.setGraphic(new ImageView("deadstickman.png"));
                                        life2.setGraphic(new ImageView("deadstickman.png"));
                                        life3.setGraphic(new ImageView("stickman.png"));
                                    }
                                    //objects.remove(i);
                                    scorelabel.setText("Your Score: " + score);
                                }
                                else if(objects.get(i).type==5)
                                {
                                    sliced.add(objects.get(i));
                                    labels.add((SpecialFruits) objects.get(i));
                                    if(soundmute!=true)
                                    {
                                        mediaPlayer = new MediaPlayer(musicFile);
                                        mediaPlayer.play();
                                    }
                                    for (int k = 0; k < sliced.size(); k++) {
                                        if (sliced.get(k).equals(objects.get(i))) {
                                            sliced.get(k).half1.posY = objects.get(i).sprite.posY;
                                            sliced.get(k).half2.posY = objects.get(i).sprite.posY;
                                            sliced.get(k).half1.posX = objects.get(i).sprite.posX + 70;
                                            sliced.get(k).half2.posX = objects.get(i).sprite.posX;
                                        }
                                    }
                                    for(int k =0;k<labels.size();k++)
                                    {
                                        if(labels.get(k).equals(objects.get(i)))
                                        {
                                            labels.get(k).label.posX = objects.get(i).sprite.posX+30;
                                            labels.get(k).label.posY = objects.get(i).sprite.posY;
                                        }
                                    }
                                    bluebateekha.bonus();
                                    //score=score+5;
                                    System.out.println("SCORE  "+score);
                                    objects.remove(i);
                                    scorelabel.setText("Your Score: " + score);
                                }
                                else if (objects.get(i).type == 6 && objects.get(i).sprite.slice != 1) {
                                    objects.get(i).sprite.slice = 1;
                                    labels2.add((Konbela) objects.get(i));
                                    lives++;
                                    if(soundmute!=true) {
                                        konbelasound = new MediaPlayer(music1);
                                        konbelasound.play();
                                    }
                                    for(int k =0;k<labels2.size();k++)
                                    {
                                        if(labels2.get(k).equals(objects.get(i)))
                                        {
                                            labels2.get(k).label.posX = objects.get(i).sprite.posX+30;
                                            labels2.get(k).label.posY = objects.get(i).sprite.posY;
                                        }
                                    }
                                    if(lives ==1)
                                    {
                                        life1.setGraphic(new ImageView("deadstickman.png"));
                                    }
                                    else if(lives ==2)
                                    {
                                        life2.setGraphic(new ImageView("deadstickman.png"));
                                    }
                                    else if(lives ==3)
                                    {
                                        life3.setGraphic(new ImageView("deadstickman.png"));
                                    }
                                } else if (objects.get(i).type == 7 && objects.get(i).sprite.slice != 1) {
                                    objects.get(i).sprite.slice = 1;
                                    timer.stop();
                                    flag = 1;
                                   // Explosion = new MediaPlayer(music2);
                                    //Explosion.play();
                                    try {
                                        highscore.save(score);
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }
                                    if(score>=highscore.high1||score>=highscore.high2||score>=highscore.high3||score>=highscore.high4||score>=highscore.high5)
                                    {
                                        high = true;
                                    }
                                    else
                                    {
                                        high = false;
                                    }
                                    Parent root = null;
                                    try {
                                        root = FXMLLoader.load(getClass().getResource("GameScreenOver.fxml"));
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }
                                    /*try {
                                        //highscore.save(score);
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }*/
                                    Stage currentStage = (Stage) pane.getScene().getWindow();
                                    currentStage.setScene(new Scene(root));
                                    currentStage.show();
                                }
                                gc.clearRect(0, 0, 800, 1500);
                                gc.drawImage(image, 0, 0);
                                for (int j = 0; j < objects.size(); j++) {
                                    if (objects.get(j).sprite.slice == 0) {
                                        objects.get(j).sprite.updateLocation();
                                        objects.get(j).sprite.render(gc);
                                        if (objects.get(j).sprite.posY >= 499) {
                                            if (objects.get(i).sprite.slice == 0)
                                                lives++;
                                            System.out.println("LIVES" + lives);
                                            objects.remove(j);
               //                             System.out.println("SIZE" + fruits.size());
                                        }
                                    }
                                }
                                for (int j = 0; j < sliced.size(); j++) {
                                    sliced.get(j).half1.updateLocation();
                                    sliced.get(j).half2.updateLocation();
                                    sliced.get(j).half1.render(gc);
                                    sliced.get(j).half2.render(gc);
                                }
                            }
                        }
                    }
                });
            for (int j=0;j<objects.size();j++) {
                if (objects.get(j).sprite.slice == 0) {
                    objects.get(j).sprite.updateLocation();
                    objects.get(j).sprite.render(gc);
                    if (objects.get(j).sprite.posY >= 499) {
                        if (objects.get(j).sprite.slice == 0&& objects.get(j).type<6) {
                            if(soundmute!=true) {
                                fawakeh = new MediaPlayer(sound3);
                                fawakeh.play();
                            }
                            lives++;
                        }
                        if(lives ==1)
                        {
                            life1.setGraphic(new ImageView("deadstickman.png"));
                        }
                        else if(lives ==2)
                        {
                            life2.setGraphic(new ImageView("deadstickman.png"));
                        }
                        else if(lives ==3)
                        {
                            life3.setGraphic(new ImageView("deadstickman.png"));
                        }
                        System.out.println("LIVES" + lives);
                        objects.remove(j);
                 //       System.out.println("SIZE" + fruits.size());
                    }
                }
            }
            for(int j=0;j<sliced.size();j++)
            {
                sliced.get(j).half1.updateLocation();
                sliced.get(j).half2.updateLocation();
                sliced.get(j).half1.render(gc);
                sliced.get(j).half2.render(gc);
                if(sliced.get(j).half1.posY>=499&&sliced.get(j).half2.posY>=499)
                {
                    sliced.remove(j);
                }
            }
            for(int j=0;j<labels.size();j++)
            {
                labels.get(j).label.updateLocation();
                labels.get(j).label.render(gc);
                if(labels.get(j).label.posY>=499)
                    labels.remove(j);
            }
            for(int j=0;j<labels2.size();j++)
            {
                labels2.get(j).label.updateLocation();
                labels2.get(j).label.render(gc);
                if(labels2.get(j).label.posY>=499)
                    labels2.remove(j);
            }
            if(score > highscore.high1)
            {
                HighScore.setText("High score: "+score);
            }
            if(lives >=3)
            {
                timer.stop();
                highscore.save(score);
                flag =1;
                if(score>=highscore.high1||score>=highscore.high2||score>=highscore.high3||score>=highscore.high4||score>=highscore.high5)
                {
                    high = true;
                }
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("gameScreenOver.fxml"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                Stage currentStage = (Stage) pane.getScene().getWindow();
                currentStage.setScene(new Scene(root));
                currentStage.show();
            }
        }

        @Override
        public Scene getScene()
        {
            return this.scene;
        }
}
