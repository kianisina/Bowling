package kata.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    public void canScoreZero() {
        game.addFrame(0, 0);
        assertEquals(0, game.getScore());
    }

    @Test
    public void canScoreOneAndTwo() {
        game.addFrame(1, 2);
        assertEquals(3, game.getScore());
    }

    @Test
    public void canScoreMultipleNormalFrames() {
        game.addFrame(2, 3);
        game.addFrame(6, 2);
        game.addFrame(5, 1);
        game.addFrame(4, 3);
        game.addFrame(6, 3);
        game.addFrame(2, 4);
        game.addFrame(3, 6);
        game.addFrame(7, 2);
        game.addFrame(4, 3);
        game.addFrame(4, 3);
        assertEquals(73, game.getScore());
    }

    @Test
    public void canScoreSpare() {
        game.addFrame(5, 5);
        game.addFrame(6, 0);
        game.addFrame(6, 4);
        game.addFrame(7, 3);
        game.addFrame(5, 3);
        for (int i = 0; i < 5; i++) {
            game.addFrame(0, 0);
        }
        assertEquals(62, game.getScore());
    }

    @Test
    public void canScoreStrike() {
        game.addFrame(10, 0);
        game.addFrame(3, 7);
        game.addFrame(3, 3);
        for (int i = 0; i < 7; i++) {
            game.addFrame(0, 0);
        }
        assertEquals(39, game.getScore());
    }
}