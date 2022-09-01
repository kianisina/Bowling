package kata.bowling;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AmericanTenPinRules {
    private List<Frame> frames;
    private final int numberOfFramesInOneLine = 10;

    public AmericanTenPinRules() {
        frames = new ArrayList<>();
    }

    public void addFrame(Frame frame) {
        frames.add(frame);
    }

    public int calculateScore() {
        int score = 0;
        Iterator<Frame> frameIterator = frames.listIterator();
        int currentFrame = 0;
        while (frameIterator.hasNext() && currentFrame < numberOfFramesInOneLine) {
            Frame frame = frames.get(currentFrame);
            frame.calculateScoreForSpareAndStrike(frames, currentFrame);
            score += frame.getScore();
            currentFrame++;
        }
        return score;
    }
}
