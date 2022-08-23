package kata.bowling;

public class Game {
    private AmericanTenPinsRules americanTenPinsRules;
    public Game() {
        americanTenPinsRules = new AmericanTenPinsRules();
    }

    public void addFrame(Frame frame) {
        americanTenPinsRules.addFrame(frame);

    }

    public int getScore() {
        return americanTenPinsRules.calScore();
    }


}
