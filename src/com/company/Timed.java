package com.company;

import java.io.IOException;

public class Timed implements StrategyInterface
{
    private static Timed timed;
    ArcadeScreen arcade;
    private Timed()
    {
        arcade =ArcadeScreen.getArcadeScreen();
    }
    public static Timed getTimed()
    {
        if(timed == null)
            timed = new Timed();
        return timed;
    }

    @Override
    public void newGame(int min,int max) throws IOException {
        LevelScreenController.game = arcade;
        arcade.drawGame(min,max);
    }
}
