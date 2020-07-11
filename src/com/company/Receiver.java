package com.company;

import java.io.IOException;

public class Receiver {
    static StrategyInterface strategy;
    Classic classic;

    public Receiver() {
        classic = Classic.getClassic();
    }

    public static void setStrategy(StrategyInterface strategy) {
        Receiver.strategy = strategy;
    }
    public void easy() throws IOException {
        setStrategy(LevelScreenController.strategy);
        strategy.newGame(1,2);
        System.out.println("Easy");
    }
    public void medium() throws IOException {
        setStrategy(LevelScreenController.strategy);
        strategy.newGame(3,4);
        System.out.println("Medium");
    }
    public void hard() throws IOException {
        setStrategy(LevelScreenController.strategy);
        strategy.newGame(5,6);
        System.out.println("Hard");
    }
}
