package com.github.bsfowlie.tilegame.engine.graphics;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DisplayShould implements WithAssertions {

    private static final String GAME_TITLE = "game";

    private static final int WIDTH = 800;

    private static final int HEIGHT = 640;

    @Test
    void create_a_window() {

        // given
        final Display window = Display.create(GAME_TITLE, WIDTH, HEIGHT);

        // when

        // then
        Assertions.assertAll(
                () -> assertThat(window.title()).isEqualTo(GAME_TITLE),
                () -> assertThat(window.width()).isEqualTo(WIDTH),
                () -> assertThat(window.height()).isEqualTo(HEIGHT)
        );

    }

}
