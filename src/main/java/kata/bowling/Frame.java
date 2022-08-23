package kata.bowling;

public class Frame {
    private final int pinsDownInFirstRoll;
    private final int pinsDownInSecondRoll;
    public Frame(int pinsDownInFirstRoll, int pinsDownInSecondRoll) {
        this.pinsDownInFirstRoll = pinsDownInFirstRoll;
        this.pinsDownInSecondRoll = pinsDownInSecondRoll;
    }

    public int getScore() {
        return pinsDownInFirstRoll + pinsDownInSecondRoll;
    }

    public int getPinsDownInFirstRoll() {
        return pinsDownInFirstRoll;
    }
}
