package com.company;

public class SpecialFruitsFactory {

    private int type;
    MozetElNagah moza;
    blueBateeekha bateekha;
    public SpecialFruitsFactory()
    {

    }

    public int rand() {
        return (int)(Math.random() * 2 + 1);
    }

    public SpecialFruits getSpecialFruit() {
        type = rand();
        System.out.println("sdiajsdisad"+type);
        if (type == 2) {
            moza = new MozetElNagah();
            return moza;
        }
        else{
                bateekha = new blueBateeekha();
                return bateekha;
        }
    }
}
