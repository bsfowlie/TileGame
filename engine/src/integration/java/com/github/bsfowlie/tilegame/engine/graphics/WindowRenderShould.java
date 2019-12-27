package com.github.bsfowlie.tilegame.engine.graphics;

import static org.assertj.swing.core.BasicRobot.robotWithCurrentAwtHierarchy;
import static org.assertj.swing.finder.WindowFinder.findFrame;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

import java.awt.*;
import java.awt.image.BufferStrategy;
import javax.swing.*;

import com.github.bsfowlie.tilegame.engine.Game;
import org.assertj.core.api.WithAssertions;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WindowRenderShould implements WithAssertions {

    private static final String NAMED_GAME = "game";

    private static final String TITLE = "Tile Game!";

    private static final int WIDTH = 800;

    private static final int HEIGHT = 640;

    private Window window;

    private FrameFixture frame;

    @Mock private Game game;

    @BeforeAll
    static void setupAccessCheck() {

        FailOnThreadViolationRepaintManager.install();

    }

    @BeforeEach
    void setupFrame() {

        window = (Window) Display.create(TITLE, WIDTH, HEIGHT);
        SwingUtilities.invokeLater(window::show);
        frame = findFrame(NAMED_GAME).using(robotWithCurrentAwtHierarchy());

    }

    @Test
    void call_game_to_render_when_invoked() {

        // given

        // when
        window.render(game);

        // then
        then(game).should(atLeastOnce()).renderTo(any(Graphics2D.class));

    }

    @Test
    void create_buffer_strategy_only_when_invoked_first_time() {

        // given
        final Canvas canvas = (Canvas) ((JFrame) frame.target()).getContentPane().getComponent(0);
        assertThat(canvas.getBufferStrategy()).isNull();

        // when
        window.render(game);

        // then
        final BufferStrategy strategy = canvas.getBufferStrategy();
        assertThat(strategy).isNotNull();

        // when
        window.render(game);

        // then
        assertThat(canvas.getBufferStrategy()).isSameAs(strategy);

    }

    @Test
    void shows_the_rendered_frame(@Mock BufferStrategy strategy, @Mock Graphics2D g2d) {

        // given
        given(strategy.getDrawGraphics()).willReturn(g2d);
        given(strategy.contentsRestored()).willReturn(true,false, true, false);
        given(strategy.contentsLost()).willReturn(true,false);

        // when
        window.renderWith(strategy, game);

        // then
        then(game).should(atLeastOnce()).renderTo(any(Graphics2D.class));
        then(g2d).should(times(4)).dispose();
        then(strategy).should(times(2)).show();

    }

    @Test
    void cleanup_graphics_after_rendering(@Mock Graphics2D g2d) {

        // given

        // when
        window.renderTo(g2d, game);

        // then
        then(game).should(atLeastOnce()).renderTo(any(Graphics2D.class));
        then(g2d).should(times(1)).dispose();

    }

    @AfterEach
    void cleanupFrame() {

        frame.cleanUp();

    }

}
