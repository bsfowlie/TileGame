package com.github.bsfowlie.tilegame;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class MainShould implements WithAssertions {

    @Test
    void output_greeting() {

        // given
        final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        final PrintStream original = System.out;
        try (PrintStream stream = new PrintStream(buffer, true, StandardCharsets.UTF_8)) {
            System.setOut(stream);

            // when
            Main.main(new String[] {});
        } finally {
            System.setOut(original);
        }

        // then
        assertThat(buffer.toString(StandardCharsets.UTF_8)).contains("Hello, world!");

    }

}
