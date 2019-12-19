package com.github.bsfowlie.tilegame.engine.graphics;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WindowShould implements WithAssertions {

    private static final String ANY_TITLE = "Any Title";
    private static final int ANY_WIDTH = 400;
    private static final int ANY_HEIGHT = 320;

    @ParameterizedTest
    @ValueSource(strings = {"testing", "title"})
    void have_a_title(final String thisTitle) {

        // given
        final Display window = new Window(thisTitle, ANY_WIDTH, ANY_HEIGHT);

        // when

        // then
        assertThat(window.title()).isEqualTo(thisTitle);

    }

    @ParameterizedTest
    @ValueSource(ints = {400, 800})
    void have_a_width(final int thisWidth) {

        // given
        final Display window = new Window(ANY_TITLE, thisWidth, ANY_HEIGHT);

        // when

        // then
        assertThat(window.width()).isEqualTo(thisWidth);

    }

    @ParameterizedTest
    @ValueSource(ints = {320, 640})
    void have_a_height(final int thisHeight) {

        // given
        final Display window = new Window(ANY_TITLE, ANY_WIDTH, thisHeight);

        // when

        // then
        assertThat(window.height()).isEqualTo(thisHeight);

    }

}
