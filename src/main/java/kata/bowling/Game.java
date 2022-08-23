package kata.bowling;

public class Game {
    private int score;
    public void frame(int pinsDownInFirstRoll, int pinsDownInSecondRoll) {
        score += pinsDownInFirstRoll + pinsDownInSecondRoll;
    }

    public int getScore() {
        return score;
    }
}
