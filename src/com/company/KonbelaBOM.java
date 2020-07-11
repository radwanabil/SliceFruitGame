package com.company;

import javafx.scene.image.Image;

import java.awt.*;

public class KonbelaBOM extends Konbela{

    final Image image = new Image("konbelaBOM.png");
    Classic classic;
    Timed arcade;
    ClassicScreen classicScreen;
    ArcadeScreen arcadeScreen;

    public KonbelaBOM() {
        super.sprite = new Sprite(image,1,2);
        type = 6;
        classic = Classic.getClassic();
        arcade = Timed.getTimed();
        classicScreen = ClassicScreen.getClassicScreen();
        arcadeScreen = ArcadeScreen.getArcadeScreen();
        if(LevelScreenController.strategy.equals(classic))
        {
            image3 = new Image("lifemince.png");
        }
        else
        {
            image3 = new Image("7secs.png");
        }
        label = new Sprite(image3,2,2);
        label.slice =1;
    }
    void explode()
    {
        if(LevelScreenController.strategy.equals(classic))
        {
            classicScreen.lives++;
        }
        else if(LevelScreenController.strategy.equals(arcade))
        {
            arcadeScreen.seconds = arcadeScreen.seconds -7;
        }
    }
}
