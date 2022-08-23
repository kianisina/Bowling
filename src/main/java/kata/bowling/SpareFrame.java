package kata.bowling;

public class SpareFrame implements Frame{
    private final int pinsDownInFirstRoll;
    private final int scoreOfSpare = 10;

    public SpareFrame(int pinsDownInFirstRoll) {
        this.pinsDownInFirstRoll = pinsDownInFirstRoll;

    }
    @Override
    public int getScore() {
        return scoreOfSpare;
    }

    @Override
    public int getPinsDownInFirstRoll() {
        return pinsDownInFirstRoll;
    }

    @Override
    public FrameType getTypeOfFrame() {
        return FrameType.SPARE;
    }


}
