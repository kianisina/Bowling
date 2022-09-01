package kata.bowling;

import java.util.List;

public class SpareFrame implements Frame {
    private final int pinsDownInFirstRoll;
    private final int scoreOfSpare = 10;
    private int pinsDownInFirstRollOfNextFrame;

    public SpareFrame(int pinsDownInFirstRoll) {
        this.pinsDownInFirstRoll = pinsDownInFirstRoll;

    }

    @Override
    public int getScore() {
        return scoreOfSpare + pinsDownInFirstRollOfNextFrame;
    }

    @Override
    public int getPinsDownInFirstRoll() {
        return pinsDownInFirstRoll;
    }

    @Override
    public void calculateScoreForSpareAndStrike(List<Frame> frames, int currentFrame) {
        pinsDownInFirstRollOfNextFrame = frames.get(currentFrame + 1).getPinsDownInFirstRoll();

    }


}
