package com.github.bsfowlie.tilegame.engine.graphics;

import static org.assertj.swing.core.BasicRobot.robotWithCurrentAwtHierarchy;
import static org.assertj.swing.finder.WindowFinder.findFrame;

import org.assertj.core.api.WithAssertions;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WindowShowShould implements WithAssertions {

    private static final String TITLE = "Tile Game!";

    private static final int WIDTH = 800;

    private static final int HEIGHT = 640;

    private Display window;

    private FrameFixture frame;

    @BeforeAll static void setupAccessCheck() {

        FailOnThreadViolationRepaintManager.install();

    }

    @BeforeEach void setupWindow() {

        window = Display.create(TITLE, WIDTH, HEIGHT);
        GuiActionRunner.execute(()->window.show());

    }

    @BeforeEach void setupFrame() {

        frame = findFrame(TITLE).using(robotWithCurrentAwtHierarchy());

    }

    @Test void display_the_window() {

        // given

        // when

        // then
        frame.requireVisible();
    }

    @AfterEach void cleanupFrame() {

        frame.cleanUp();

    }
}
