package kata.bowling;

import java.util.List;

public class StrikeFrame implements Frame {

    private final int scoreOfStrike = 10;
    private int scoreOfNextFrame;

    public StrikeFrame() {
    }

    @Override
    public int getScore() {
        return scoreOfStrike + scoreOfNextFrame;
    }

    @Override
    public int getPinsDownInFirstRoll() {
        return scoreOfStrike;
    }


    @Override
    public void calculateScoreForSpareAndStrike(List<Frame> frames, int currentFrame) {
        if (frames.get(currentFrame + 1).getPinsDownInFirstRoll() == 10) {
            scoreOfNextFrame = frames.get(currentFrame + 1).getPinsDownInFirstRoll() + frames.get(currentFrame + 2).getPinsDownInFirstRoll();
        } else {
            scoreOfNextFrame = frames.get(currentFrame + 1).getScore();
        }


    }


}
