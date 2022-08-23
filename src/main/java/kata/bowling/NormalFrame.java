package kata.bowling;

public class NormalFrame implements Frame {
    private final int pinsDownInFirstRoll;
    private final int pinsDownInSecondRoll;

    public NormalFrame(int pinsDownInFirstRoll, int pinsDownInSecondRoll) {
        this.pinsDownInFirstRoll = pinsDownInFirstRoll;
        this.pinsDownInSecondRoll = pinsDownInSecondRoll;
    }


    @Override
    public int getScore() {
        return pinsDownInFirstRoll + pinsDownInSecondRoll;
    }

    @Override
    public int getPinsDownInFirstRoll() {
        return pinsDownInFirstRoll;
    }

    @Override
    public FrameType getTypeOfFrame() {
        return FrameType.NORMAL;
    }


}
