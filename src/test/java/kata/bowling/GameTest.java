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
    public void canScoreZeroString() {
        game.roll("00000000000000000000");
        assertEquals(0, game.calScore());
    }
    @Test
    public void canScoreNineZeroFrames() {
        game.roll("9-9-9-9-9-9-9-9-9-9-");
        assertEquals(90, game.calScore());
    }
    @Test
    public void canScoreStrikeFrames() {
        game.roll("XXXXXXXXXXXX");
        assertEquals(300, game.calScore());
    }
    @Test
    public void canScoreSpareFrames() {
        game.roll("5/5/5/5/5/5/5/5/5/5/5");
        assertEquals(150, game.calScore());
    }

}