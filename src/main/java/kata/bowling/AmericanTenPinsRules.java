package kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class AmericanTenPinsRules {
    List<Frame> frames;
    public AmericanTenPinsRules() {
        frames = new ArrayList<>();
    }
    public void addFrame(Frame frame) {
        frames.add(frame);
    }
    public int calScore() {
        int score = 0;
        for (int currentFrame = 0; currentFrame < frames.size(); currentFrame++) {
            if (isStrike(currentFrame)) {
                score += frames.get(currentFrame).getScore() + frames.get(currentFrame + 1).getScore();

            } else if (isSpare(currentFrame)) {
                score += frames.get(currentFrame).getScore() + frames.get(currentFrame + 1).getPinsDownInFirstRoll();
            } else {
                score += frames.get(currentFrame).getScore();
            }
        }
        return score;
    }
    private boolean isStrike(int currentFrame) {
        return frames.get(currentFrame).getPinsDownInFirstRoll() == 10;
    }

    private boolean isSpare(int currentFrame) {
        return frames.get(currentFrame).getScore() == 10;
    }
}
