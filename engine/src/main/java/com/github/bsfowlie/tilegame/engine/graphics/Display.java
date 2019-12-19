package com.github.bsfowlie.tilegame.engine.graphics;

public interface Display {

    static Display create(String title, int width, int height) {

        return new Window(title, width, height);

    }

    void show();

    String title();

    int width();

    int height();

}
