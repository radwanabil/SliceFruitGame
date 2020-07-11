package com.company;

import com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets;

public class FruitsFactory {
    Farwlaya farwlaya;
    Bateeekh bateeekh;
    Kiwi kiwi;
    public FruitsFactory(){
        /*farwlaya = new Farwlaya();
        bateeekh = new Bateeekh();
        kiwi = new Kiwi();*/
    }
    private int type;

    public int rand() {
        return (int)(Math.random() * 3 + 1);
    }

    public Fruits getFruit(int min,int max) {
        type = rand();
        if (type == 1) {
            kiwi = new Kiwi(min,max);
            return kiwi;
        }
        else if (type == 2) {
            farwlaya = new Farwlaya(min,max);
          //  farwlaya.sprite.setSpeed(min,max);
            return farwlaya;
        }
        else{
            bateeekh = new Bateeekh(min,max);
            //bateeekh.sprite.setSpeed(min,max);
            return bateeekh;
        }
    }
}
