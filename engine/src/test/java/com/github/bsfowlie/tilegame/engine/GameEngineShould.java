package com.github.bsfowlie.tilegame.engine;

import static org.mockito.BDDMockito.then;

import com.github.bsfowlie.tilegame.engine.graphics.Display;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GameEngineShould implements WithAssertions {

    @Mock private Game game;

    @Mock private Display display;

    private GameEngine engine;

    @BeforeEach void setupEngine() {

        // given
        engine = new GameEngine(game, display);

    }

    @Test void be_runnable() {

        // when

        // then
        assertThat(engine).isInstanceOf(Runnable.class);

    }

    @Test void initialize_game_and_display_when_run() {

        // when
        engine.run();

        // then
        then(game).should().init();
        then(display).should().show();

    }

}
