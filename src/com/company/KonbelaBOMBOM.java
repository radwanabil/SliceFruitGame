package com.company;

import javafx.scene.image.Image;

public class KonbelaBOMBOM extends Konbela{

    final Image image = new Image("konbelaBOMBOM.png");

    public KonbelaBOMBOM() {
        super.sprite = new Sprite(image,1,2);
        type =7;
    }
}
