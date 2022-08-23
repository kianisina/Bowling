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
        frame(10, new NormalFrame(0, 0));
        assertEquals(0, game.getScore());
    }

    @Test
    public void canScoreOneAndTwo() {
        game.addFrame(new NormalFrame(1, 2));
        frame(9, new NormalFrame(0, 0));
        assertEquals(3, game.getScore());
    }

    @Test
    public void canScoreMultipleNormalFrames() {
        game.addFrame(new NormalFrame(2, 3));
        game.addFrame(new NormalFrame(6, 2));
        game.addFrame(new NormalFrame(5, 1));
        game.addFrame(new NormalFrame(4, 3));
        game.addFrame(new NormalFrame(6, 3));
        game.addFrame(new NormalFrame(2, 4));
        game.addFrame(new NormalFrame(3, 6));
        game.addFrame(new NormalFrame(7, 2));
        game.addFrame(new NormalFrame(4, 3));
        game.addFrame(new NormalFrame(4, 3));
        assertEquals(73, game.getScore());
    }

    @Test
    public void canScoreSpare() {
        game.addFrame(new SpareFrame(5));
        game.addFrame(new NormalFrame(6, 0));
        game.addFrame(new SpareFrame(6));
        game.addFrame(new SpareFrame(7));
        game.addFrame(new NormalFrame(5, 3));
        frame(5, new NormalFrame(0, 0));
        assertEquals(62, game.getScore());
    }

    @Test
    public void canScoreStrike() {
        game.addFrame(new StrikeFrame());
        game.addFrame(new SpareFrame(3));
        game.addFrame(new NormalFrame(3, 3));
        frame(7, new NormalFrame(0, 0));
        assertEquals(39, game.getScore());
    }

    @Test
    public void canScoreBestStrike() {
        for (int i = 0; i < 12; i++) {
            game.addFrame(new StrikeFrame());
        }
        assertEquals(300, game.getScore());
    }

    @Test
    void canScoreAllSpare() {
        for (int i = 0; i < 11; i++) {
            game.addFrame(new SpareFrame(5));
        }
        assertEquals(150, game.getScore());
    }

    private void frame(int frames, Frame frame) {
        for (int i = 0; i < frames; i++) {
            game.addFrame(frame);
        }
    }
}