package com.company;

import javafx.scene.image.Image;

import java.sql.Time;

public class MozetElNagah extends SpecialFruits {

    final Image image = new Image("MozetElNagah.png");
    Classic classic;
    Timed arcade;
    ClassicScreen classicScreen;
    ArcadeScreen arcadeScreen;

    public MozetElNagah() {
        type = 4;
        image1 = new Image("NosMozetElNagah1.png");
        image2 = new Image("NosMozetElNagah2.png");
        if(LevelScreenController.strategy.equals(classic))
            image3 = new Image("lifeplus.png");
        else
            image3 = new Image("5secplus.png");
        sprite = new Sprite(image, 1, 2);
        half1 = new Sprite(image1, 2, 2);
        half2 = new Sprite(image2, 1, 2);
        label = new Sprite(image3,2,2);
        half1.slice = 1;
        half2.slice = 1;
        label.slice =1;
        classic = Classic.getClassic();
        arcade = Timed.getTimed();
        classicScreen = ClassicScreen.getClassicScreen();
        arcadeScreen = ArcadeScreen.getArcadeScreen();
    }

    @Override
    void bonus() {
        if(LevelScreenController.strategy.equals(classic))
        {
            classicScreen.lives--;
        }
        else if(LevelScreenController.strategy.equals(arcade))
        {
            arcadeScreen.seconds = arcadeScreen.seconds+5;
        }
    }
}
