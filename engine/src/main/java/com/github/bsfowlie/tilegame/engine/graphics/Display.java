package com.github.bsfowlie.tilegame.engine.graphics;

import com.github.bsfowlie.tilegame.engine.Game;

public interface Display {

    static Display create(String title, int width, int height) {

        return new Window(title, width, height);

    }

    void show();

    String title();

    int width();

    int height();

    void render(Game game);

}
