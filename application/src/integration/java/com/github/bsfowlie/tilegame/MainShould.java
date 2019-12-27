package com.github.bsfowlie.tilegame;

import static org.assertj.swing.core.BasicRobot.robotWithCurrentAwtHierarchy;
import static org.assertj.swing.finder.WindowFinder.findFrame;

import org.assertj.core.api.WithAssertions;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainShould implements WithAssertions {

    private static final String NAMED_GAME = "game";

    private FrameFixture frame;

    @BeforeAll static void setupAccessCheck() {

        FailOnThreadViolationRepaintManager.install();

    }

    @BeforeEach void setupFrame() {

        Main.main(new String[] {"-stayAlive"});
        frame = findFrame(NAMED_GAME).using(robotWithCurrentAwtHierarchy());

    }

    @Test void show_a_display() {

        frame.requireVisible();

    }

    @AfterEach void cleanupFrame() {

        frame.cleanUp();

    }

}
