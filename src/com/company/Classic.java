package com.company;

import java.io.IOException;

public class Classic implements StrategyInterface {
    private static Classic classic;
    ClassicScreen classicScreen;
    private Classic()
    {
        classicScreen = ClassicScreen.getClassicScreen();
    }
    public static Classic getClassic()
    {
        if(classic == null)
            classic = new Classic();
        return classic;
    }

    @Override
    public void newGame(int min,int max) throws IOException {
        LevelScreenController.game = classicScreen;
        classicScreen.drawGame(min,max);
    }
}
