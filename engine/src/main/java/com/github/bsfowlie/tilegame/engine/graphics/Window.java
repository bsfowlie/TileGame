package com.github.bsfowlie.tilegame.engine.graphics;

public class Window implements Display {

    private final String title;

    private final int width;

    private final int height;

    public Window(
            final String title,
            final int width,
            final int height
    ) {

        this.title = title;
        this.width = width;
        this.height = height;

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

    @Override
    public int height() {

        return height;

    }
}
