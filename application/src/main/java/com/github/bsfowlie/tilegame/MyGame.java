package com.github.bsfowlie.tilegame;

import java.awt.*;

import com.github.bsfowlie.tilegame.engine.Game;

class MyGame implements Game {

    public static final String WINDOW_TITLE = "Tile Game";

    public static final int WINDOW_WIDTH = 800;

    public static final int WINDOW_HEIGHT = 640;

    public static final int BLOCK_WIDTH = 50;

    public static final int BLOCK_HEIGHT = 50;

    private final boolean stayAlive;

    private int x, y;

    private int frames;

    private boolean running;

    public MyGame(final boolean stayAlive) {

        this.stayAlive = stayAlive;
        frames = 0;
        running = false;

    }

    @Override
    public void init() {

        running = true;
        x = 0;
        y = 0;

    }

    @Override
    public boolean running() {

        if (!running && !stayAlive) System.exit(0);
        return running;

    }

    @Override
    public void update() {

        ++frames;
        running = frames < 50;
        x += 5;
        y += 5;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void renderTo(final Graphics2D g2d) {

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
        g2d.setColor(Color.RED);
        g2d.fillRect(x, y, BLOCK_WIDTH, BLOCK_HEIGHT);

    }
}
