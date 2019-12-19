package com.github.bsfowlie.tilegame.engine;

import com.github.bsfowlie.tilegame.engine.graphics.Display;

public class GameEngine implements Runnable {

    private final Game game;

    private final Display display;

    public GameEngine(
            final Game game,
            final Display display
    ) {

        this.game = game;
        this.display = display;

    }

    @Override
    public void run() {
        // what to do
    }

    /* package-private */ void init() {

        game.init();
        display.show();

    }

}
