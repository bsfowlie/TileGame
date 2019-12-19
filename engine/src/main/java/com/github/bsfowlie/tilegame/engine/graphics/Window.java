package com.github.bsfowlie.tilegame.engine.graphics;

public class Window implements Display {

    private final String title;

    public Window(final String title) {

        this.title = title;
    }

    @Override
    public void show() {

    }

    @Override
    public String title() {

        return title;

    }
}
