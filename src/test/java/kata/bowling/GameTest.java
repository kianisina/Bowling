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
        game.rollConvertor("00000000000000000000");
        assertEquals(0, game.calculateScore());
    }

    @Test
    public void canScoreNineZeroFrames() {
        game.rollConvertor("9-9-9-9-9-9-9-9-9-9-");
        assertEquals(90, game.calculateScore());
    }

    @Test
    public void canScoreStrikeFrames() {
        game.rollConvertor("XXXXXXXXXXXX");
        assertEquals(300, game.calculateScore());
    }

    @Test
    public void canScoreSpareFrames() {
        game.rollConvertor("5/5/5/5/5/5/5/5/5/5/5");
        assertEquals(150, game.calculateScore());
    }

    @Test
    public void canScoreSpareStrikeFrames() {
        game.rollConvertor("238143XX5/0-189/XXX");
        assertEquals(135, game.calculateScore());
    }

}