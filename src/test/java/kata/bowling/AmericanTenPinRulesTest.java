package kata.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AmericanTenPinRulesTest {

    AmericanTenPinRules aTenPin;

    @BeforeEach
    void setUp() {
        aTenPin = new AmericanTenPinRules();
    }

    @Test
    public void canScoreZero() {
        frame(10, new NormalFrame(0, 0));
        assertEquals(0, aTenPin.calScore());
    }

    @Test
    public void canScoreOneAndTwo() {
        aTenPin.addFrame(new NormalFrame(1, 2));
        frame(9, new NormalFrame(0, 0));
        assertEquals(3, aTenPin.calScore());
    }

    @Test
    public void canScoreMultipleNormalFrames() {
        aTenPin.addFrame(new NormalFrame(2, 3));
        aTenPin.addFrame(new NormalFrame(6, 2));
        aTenPin.addFrame(new NormalFrame(5, 1));
        aTenPin.addFrame(new NormalFrame(4, 3));
        aTenPin.addFrame(new NormalFrame(6, 3));
        aTenPin.addFrame(new NormalFrame(2, 4));
        aTenPin.addFrame(new NormalFrame(3, 6));
        aTenPin.addFrame(new NormalFrame(7, 2));
        aTenPin.addFrame(new NormalFrame(4, 3));
        aTenPin.addFrame(new NormalFrame(4, 3));
        assertEquals(73, aTenPin.calScore());
    }

    @Test
    public void canScoreSpare() {
        aTenPin.addFrame(new SpareFrame(5));
        aTenPin.addFrame(new NormalFrame(6, 0));
        aTenPin.addFrame(new SpareFrame(6));
        aTenPin.addFrame(new SpareFrame(7));
        aTenPin.addFrame(new NormalFrame(5, 3));
        frame(5, new NormalFrame(0, 0));
        assertEquals(62, aTenPin.calScore());
    }

    @Test
    public void canScoreStrike() {
        aTenPin.addFrame(new StrikeFrame());
        aTenPin.addFrame(new SpareFrame(3));
        aTenPin.addFrame(new NormalFrame(3, 3));
        frame(7, new NormalFrame(0, 0));
        assertEquals(39, aTenPin.calScore());
    }

    @Test
    public void canScoreBestStrike() {
        frame(12, new StrikeFrame());
        assertEquals(300, aTenPin.calScore());
    }

    @Test
    void canScoreAllSpare() {
        frame(11, new SpareFrame(5));
        assertEquals(150, aTenPin.calScore());
    }

    private void frame(int frames, Frame frame) {
        for (int i = 0; i < frames; i++) {
            aTenPin.addFrame(frame);
        }
    }
}