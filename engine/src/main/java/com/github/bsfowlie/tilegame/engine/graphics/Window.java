package com.github.bsfowlie.tilegame.engine.graphics;

public class Window implements Display {

    private final String title;

    private final int width;

    public Window(final String title, final int width) {

        this.title = title;
        this.width = width;

    }

    @Override
    public void show() {

    }

    @Override
    public String title() {

        return title;

    }

    @Override
    public int width() {

        return width;

    }
}
