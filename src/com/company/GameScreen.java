package com.company;

import javafx.scene.Scene;

import java.io.IOException;

public interface GameScreen {
    Scene getScene();
    void drawGame(int min,int max) throws IOException;
}
