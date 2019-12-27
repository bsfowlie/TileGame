package com.github.bsfowlie.tilegame;

import javax.swing.*;

import com.github.bsfowlie.tilegame.engine.Game;
import com.github.bsfowlie.tilegame.engine.GameEngine;
import com.github.bsfowlie.tilegame.engine.graphics.Display;

public class Main {

    public static void main(String[] args) {

        final boolean stayAlive = args.length > 0;
        final Game game = new MyGame(stayAlive);

        final Display display = Display.create(MyGame.WINDOW_TITLE, MyGame.WINDOW_WIDTH, MyGame.WINDOW_HEIGHT);

        SwingUtilities.invokeLater(new GameEngine(game, display));

    }

}
