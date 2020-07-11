package com.company;

import javafx.scene.image.Image;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Bateeekh extends Fruits {

    final Image image = new Image("Bateeekha.png");
    final Image image1 = new Image("NosBateekha1.png");
    final Image image2 = new Image("NosBateekha2.png");
    //image3 = new Image();

    public Bateeekh(int min,int max) {
        type =2;
        sprite = new Sprite(image,min,max);
        half1 = new Sprite(image1,min,max);
        half2 = new Sprite(image2,min,max);
        half1.slice =1;
        half2.slice =1;
        }

}
