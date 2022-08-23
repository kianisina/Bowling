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
        game.frame(0);
        assertEquals(0, game.getScore());
    }
}