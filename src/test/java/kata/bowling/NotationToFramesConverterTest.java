package kata.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotationToFramesConverterTest {

    NotationToFramesConverter notationToFramesConverter;

    @BeforeEach
    void setUp() {
        notationToFramesConverter = new NotationToFramesConverter();
    }

    @Test
    void canConvertNormalFrame() {
        notationToFramesConverter.rollParser("9-");
        int frame = new NormalFrame(9, 0).getScore();
        int frame1 = notationToFramesConverter.getFrames().get(0).getScore();
        assertEquals(frame, frame1);
    }

    @Test
    void canConvertSpareFrame() {
        notationToFramesConverter.rollParser("5/");
        Frame frame = new SpareFrame(5);
        int frame1 = notationToFramesConverter.getFrames().get(0).getScore();
        assertEquals(frame.getScore(), frame1);
    }

    @Test
    void canConvertStrikeFrame() {
        notationToFramesConverter.rollParser("X");
        Frame frame = new StrikeFrame();
        int frame1 = notationToFramesConverter.getFrames().get(0).getScore();
        assertEquals(frame.getScore(), frame1);
    }
}