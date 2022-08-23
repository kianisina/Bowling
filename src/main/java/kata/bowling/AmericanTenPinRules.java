package kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class AmericanTenPinRules {
    List<Frame> frames;

    public AmericanTenPinRules() {
        frames = new ArrayList<>();
    }

    public void addFrame(Frame frame) {
        frames.add(frame);
    }

    public int calScore() {
        int score = 0;
        FrameType frameType;
        for (int currentFrame = 0; currentFrame < 10; currentFrame++) {
            Frame frame = frames.get(currentFrame);
            frameType = frame.getTypeOfFrame();
            switch (frameType) {
                case SPARE -> score += frame.getScore() + frames.get(currentFrame + 1).getPinsDownInFirstRoll();
                /*the if Condition in strike case check if there is a Strikes after a Strike Frame*/
                case STRIKE -> score += frames.get(currentFrame + 1).getTypeOfFrame() == FrameType.STRIKE ?
                        frame.getScore() + frames.get(currentFrame + 1).getScore()
                                + frames.get(currentFrame + 2).getPinsDownInFirstRoll() :
                        frame.getScore() + frames.get(currentFrame + 1).getScore();
                case NORMAL -> score += frame.getScore();
            }
        }
        return score;
    }

}
