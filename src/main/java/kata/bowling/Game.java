package kata.bowling;

public class Game {
    private AmericanTenPinRules americanTenPinRules;

    public Game() {
        americanTenPinRules = new AmericanTenPinRules();
    }

    public void addFrame(Frame frame) {
        americanTenPinRules.addFrame(frame);

    }

    public int getScore() {
        return americanTenPinRules.calScore();
    }


}
