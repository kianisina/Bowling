package kata.bowling;

public class Game {
    private AmericanTenPinRules americanTenPinRules;

    public Game() {
        americanTenPinRules = new AmericanTenPinRules();
    }

    public void roll(String rolls) {
        String frameToAnalyze = "";
        for (int i = 0; i < rolls.length(); i++) {
            if (rolls.charAt(i) == 'X') {
                frameToAnalyze = rolls.charAt(i) + "";
            } else {
                if (i >= 20) {
                    frameToAnalyze = rolls.charAt(i) + "-";
                } else {
                    frameToAnalyze = rolls.substring(i, i + 2);
                    i++;
                }
            }
            analyzeFrame(frameToAnalyze);
        }

    }

    private void analyzeFrame(String frameToAnalyze) {
        if (frameToAnalyze.length() == 1) {
            addFrame(new StrikeFrame());
        } else if (frameToAnalyze.contains("/")) {
            addFrame(new SpareFrame(Integer.parseInt(frameToAnalyze.charAt(0) + "")));
        } else {
            int firstRoll = Integer.parseInt(frameToAnalyze.charAt(0) + "");
            if (frameToAnalyze.contains("-")) {
                addFrame(new NormalFrame(firstRoll, 0));
            } else {
                int secondRoll = Integer.parseInt(frameToAnalyze.charAt(1) + "");
                addFrame(new NormalFrame(firstRoll, secondRoll));
            }
        }

    }

    private void addFrame(Frame frame) {
        americanTenPinRules.addFrame(frame);

    }

    public int calScore() {
        return americanTenPinRules.calScore();
    }

}
