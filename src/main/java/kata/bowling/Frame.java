package kata.bowling;

import java.util.List;

public interface Frame {
    int getScore();

    int getPinsDownInFirstRoll();

    void calculateScoreForSpareAndStrike(List<Frame> frames, int currentFrame);
}
