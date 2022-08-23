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
        game.frame(0, 0);
        assertEquals(0, game.getScore());
    }

    @Test
    public void canScoreOneAndTwo() {
        game.frame(1, 2);
        assertEquals(3, game.getScore());
    }

    @Test
    public void canScoreMultipleNormalFrames() {
        game.frame(2, 3);
        game.frame(6, 2);
        game.frame(5, 1);
        game.frame(4, 3);
        game.frame(6, 3);
        game.frame(2, 4);
        game.frame(3, 6);
        game.frame(7, 2);
        game.frame(4, 3);
        game.frame(4, 3);
        assertEquals(73, game.getScore());
    }
}