package com.company;

import javafx.scene.image.Image;

public class blueBateeekha extends SpecialFruits{

    final Image image = new Image("BlueBateeekha.png");
    Classic classic;
    ClassicScreen classicScreen;
    ArcadeScreen arcadeScreen;
    Timed arcade;

    public blueBateeekha() {
        classic = Classic.getClassic();
        classicScreen = ClassicScreen.getClassicScreen();
        arcade = Timed.getTimed();
        arcadeScreen = ArcadeScreen.getArcadeScreen();
        if(LevelScreenController.strategy.equals(classic))
            image3 = new Image("5points.png");
        else
            image3 = new Image("10pointsplus.png");
        type=5;
        image1 = new Image("NosBlueBateekha1.png");
        image2 = new Image("NosBlueBateekha2.png");
        super.sprite = new Sprite(image,1,2);
        half1 = new Sprite(image1,1,2);
        half2 = new Sprite(image2,1,2);
        label = new Sprite(image3,2,2);
        half1.slice = 1;
        half2.slice = 1;
        label.slice = 1;
    }

    @Override
    void bonus() {
        if(LevelScreenController.strategy.equals(classic))
        {
            classicScreen.score = classicScreen.score+5;
            System.out.println("sdooaidjasdjaso     "+classicScreen.score);
        }
        else if(LevelScreenController.strategy.equals(arcade))
        {
            arcadeScreen.score = arcadeScreen.score+10;
        }
    }
}
