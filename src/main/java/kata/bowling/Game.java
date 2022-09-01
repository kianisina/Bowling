package kata.bowling;

public class Game {
    private AmericanTenPinRules americanTenPinRules;

    public Game() {
        americanTenPinRules = new AmericanTenPinRules();
    }

    public void addFrame(Frame frame) {
        americanTenPinRules.addFrame(frame);
    }

    public int calculateScore() {
        return americanTenPinRules.calculateScore();
    }

    public void rollConvertor(String rolls) {
        NotationToFramesConverter notationToFramesConverter = new NotationToFramesConverter();
        notationToFramesConverter.rollParser(rolls);
        for (Frame frame : notationToFramesConverter.getFrames()) {
            addFrame(frame);
        }
    }
}
