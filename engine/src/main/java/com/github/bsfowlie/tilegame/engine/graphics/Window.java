package com.github.bsfowlie.tilegame.engine.graphics;

import java.awt.*;
import java.awt.image.BufferStrategy;
import javax.swing.*;

import com.github.bsfowlie.tilegame.engine.Game;

class Window implements Display {

    private static final String FRAME_NAME = "game";

    private final String title;

    private final int width;

    private final int height;

    private Canvas canvas;

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

        SwingUtilities.invokeLater(this::createFrame);

    }

    private void createFrame() {

        JFrame frame = new JFrame(title);
        frame.setName(FRAME_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        final Dimension size = new Dimension(width, height);
        canvas = new Canvas();
        canvas.setMaximumSize(size);
        canvas.setMinimumSize(size);
        canvas.setPreferredSize(size);

        frame.add(canvas);
        frame.pack();
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

    @Override
    public void render(
            final Game game
    ) {

        if (canvas.getBufferStrategy() == null) {
            canvas.createBufferStrategy(3);
        }

        renderWith(canvas.getBufferStrategy(), game);

    }

    /* package-private*/ void renderWith(final BufferStrategy strategy, final Game game) {

        renderTo((Graphics2D) strategy.getDrawGraphics(), game);
        strategy.show();

    }

    /* package-private*/ void renderTo(final Graphics2D g2d, final Game game) {

        game.renderTo(g2d);
        g2d.dispose();

    }

}
