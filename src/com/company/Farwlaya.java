package com.company;

import javafx.scene.image.Image;

public class Farwlaya extends Fruits {
    final Image image = new Image("Farwlaya.png");

    public Farwlaya(int min,int max) {
        image1 = new Image("NosFarwlaya1.png");
        image2 = new Image("NosFarwlaya2.png");
        type =1;
        sprite = new Sprite(image,min,max);
        half1 = new Sprite(image1,min,max);
        half2 = new Sprite(image2,min,max);
        sprite.slice=0;
        half1.slice =1;
        half2.slice =1;
    }

}
