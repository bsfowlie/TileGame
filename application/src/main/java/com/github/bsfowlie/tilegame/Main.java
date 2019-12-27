package com.github.bsfowlie.tilegame;

import java.awt.*;
import javax.swing.*;

import com.github.bsfowlie.tilegame.engine.Game;
import com.github.bsfowlie.tilegame.engine.GameEngine;
import com.github.bsfowlie.tilegame.engine.graphics.Display;

public class Main {

    private static final int WINDOW_WIDTH = 800;

    private static final int WINDOW_HEIGHT = 640;

    private static final int BLOCK_WIDTH = 50;

    private static final int BLOCK_HEIGHT = 50;

    public static void main(String[] args) {

        final boolean stayAlive = args.length > 0;
        final Display display = Display.create("Tile Game", WINDOW_WIDTH, WINDOW_HEIGHT);
        final Game game = new Game() {

            private int x, y;
            private int frames = 0;
            private boolean running = true;

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
        };

        SwingUtilities.invokeLater(new GameEngine(game, display));

    }

}
