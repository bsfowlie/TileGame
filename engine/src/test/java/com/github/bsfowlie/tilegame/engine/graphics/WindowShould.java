package com.github.bsfowlie.tilegame.engine.graphics;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WindowShould implements WithAssertions {

    private static final String TITLE = "Any Title";
    private static final int WIDTH = 400;

    @ParameterizedTest
    @ValueSource(strings = {"testing", "title"})
    void have_a_title(final String title) {

        // given
        final Display window = new Window(title, WIDTH);

        // when

        // then
        assertThat(window.title()).isEqualTo(title);

    }

    @ParameterizedTest
    @ValueSource(ints = {400, 800})
    void have_a_width(final int width) {

        // given
        final Display window = new Window(TITLE, width);

        // when

        // then
        assertThat(window.width()).isEqualTo(width);

    }

}