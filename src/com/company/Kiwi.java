package com.company;

import javafx.scene.image.Image;

public class Kiwi extends Fruits {

    final Image image = new Image("Kiwi.png");
    final Image image1 = new Image("NosKiwi1.png");
    final Image image2 = new Image("NosKiwi2.png");

    public Kiwi(int min,int max) {
        type =3;
        sprite = new Sprite(image,min,max);
        half1 = new Sprite(image1,min,max);
        half2 = new Sprite(image2,min,max);
        sprite.slice=0;
        half1.slice =1;
        half2.slice =1;


    }
}
