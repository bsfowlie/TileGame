package com.github.bsfowlie.tilegame.engine.graphics;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WindowShould implements WithAssertions {

    @ParameterizedTest
    @CsvSource({"testing", "title"})
    void have_a_title(final String title) {

        // given
        final Display window = new Window(title);

        // when

        // then
        assertThat(window.title()).isEqualTo(title);

    }

}