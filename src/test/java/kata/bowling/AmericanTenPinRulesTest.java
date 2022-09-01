package kata.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AmericanTenPinRulesTest {

    AmericanTenPinRules americanTenPinRules;

    @BeforeEach
    void setUp() {
        americanTenPinRules = new AmericanTenPinRules();
    }

    @Test
    public void canScoreZero() {
        frame(10, new NormalFrame(0, 0));
        assertEquals(0, americanTenPinRules.calculateScore());
    }

    @Test
    public void canScoreOneAndTwo() {
        americanTenPinRules.addFrame(new NormalFrame(1, 2));
        frame(9, new NormalFrame(0, 0));
        assertEquals(3, americanTenPinRules.calculateScore());
    }

    @Test
    public void canScoreNormalFrames() {
        americanTenPinRules.addFrame(new NormalFrame(2, 3));
        americanTenPinRules.addFrame(new NormalFrame(6, 2));
        americanTenPinRules.addFrame(new NormalFrame(5, 1));
        americanTenPinRules.addFrame(new NormalFrame(4, 3));
        americanTenPinRules.addFrame(new NormalFrame(6, 3));
        americanTenPinRules.addFrame(new NormalFrame(2, 4));
        americanTenPinRules.addFrame(new NormalFrame(3, 6));
        americanTenPinRules.addFrame(new NormalFrame(7, 2));
        americanTenPinRules.addFrame(new NormalFrame(4, 3));
        americanTenPinRules.addFrame(new NormalFrame(4, 3));
        assertEquals(73, americanTenPinRules.calculateScore());
    }

    @Test
    public void canScoreSpareAndNormal() {
        americanTenPinRules.addFrame(new SpareFrame(5));
        americanTenPinRules.addFrame(new NormalFrame(6, 0));
        americanTenPinRules.addFrame(new SpareFrame(6));
        americanTenPinRules.addFrame(new SpareFrame(7));
        americanTenPinRules.addFrame(new NormalFrame(5, 3));
        frame(5, new NormalFrame(0, 0));
        assertEquals(62, americanTenPinRules.calculateScore());
    }

    @Test
    public void canScoreStrikeSpareAndNormal() {
        americanTenPinRules.addFrame(new StrikeFrame());
        americanTenPinRules.addFrame(new SpareFrame(3));
        americanTenPinRules.addFrame(new NormalFrame(3, 3));
        frame(7, new NormalFrame(0, 0));
        assertEquals(39, americanTenPinRules.calculateScore());
    }

    @Test
    public void canScoreSpareStrike() {
        americanTenPinRules.addFrame(new SpareFrame(5));
        americanTenPinRules.addFrame(new SpareFrame(5));
        americanTenPinRules.addFrame(new StrikeFrame());
        americanTenPinRules.addFrame(new SpareFrame(5));
        americanTenPinRules.addFrame(new SpareFrame(5));
        americanTenPinRules.addFrame(new SpareFrame(5));
        americanTenPinRules.addFrame(new StrikeFrame());
        americanTenPinRules.addFrame(new SpareFrame(5));
        americanTenPinRules.addFrame(new SpareFrame(5));
        americanTenPinRules.addFrame(new SpareFrame(5));
        americanTenPinRules.addFrame(new SpareFrame(5));
        assertEquals(170, americanTenPinRules.calculateScore());
    }

    @Test
    public void canScoreBestStrike() {
        frame(12, new StrikeFrame());
        assertEquals(300, americanTenPinRules.calculateScore());
    }
    @Test
    public void canScoreTwoStrikesAfterEachOther() {
        americanTenPinRules.addFrame(new NormalFrame(2,3));
        americanTenPinRules.addFrame(new NormalFrame(8,1));
        americanTenPinRules.addFrame(new NormalFrame(4,3));
        americanTenPinRules.addFrame(new StrikeFrame());
        americanTenPinRules.addFrame(new StrikeFrame());
        americanTenPinRules.addFrame(new SpareFrame(5));
        americanTenPinRules.addFrame(new NormalFrame(0,0));
        americanTenPinRules.addFrame(new NormalFrame(1,8));
        americanTenPinRules.addFrame(new SpareFrame(9));
        americanTenPinRules.addFrame(new StrikeFrame());
        americanTenPinRules.addFrame(new StrikeFrame());
        americanTenPinRules.addFrame(new StrikeFrame());
        assertEquals(135,americanTenPinRules.calculateScore());
    }

    @Test
    void canScoreAllSpare() {
        frame(11, new SpareFrame(5));
        assertEquals(150, americanTenPinRules.calculateScore());
    }

    private void frame(int frames, Frame frame) {
        for (int i = 0; i < frames; i++) {
            americanTenPinRules.addFrame(frame);
        }
    }
}