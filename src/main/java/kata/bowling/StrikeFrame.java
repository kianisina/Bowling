package kata.bowling;

public class StrikeFrame implements Frame {

    private final int scoreOfStrike = 10;

    public StrikeFrame() {
    }

    @Override
    public int getScore() {
        return scoreOfStrike;
    }

    @Override
    public int getPinsDownInFirstRoll() {
        return scoreOfStrike;
    }

    @Override
    public FrameType getTypeOfFrame() {
        return FrameType.STRIKE;
    }


}
