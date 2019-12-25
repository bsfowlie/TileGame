package com.github.bsfowlie.tilegame.engine;

import java.awt.*;

public interface Game {

    void init();

    boolean running();

    void update();

    void renderTo(Graphics2D g2d);

}
