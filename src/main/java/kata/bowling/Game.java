package kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Frame> frames;

    public Game() {
        frames = new ArrayList<>();
    }

    public void addFrame(int pinsDownInFirstRoll, int pinsDownInSecondRoll) {
        frames.add(new Frame(pinsDownInFirstRoll, pinsDownInSecondRoll));

    }

    public int getScore() {
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
