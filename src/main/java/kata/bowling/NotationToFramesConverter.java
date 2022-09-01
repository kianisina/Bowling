package kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class NotationToFramesConverter {
    private List<Frame> frames;

    public NotationToFramesConverter() {
        frames = new ArrayList<>();

    }

    public void rollParser(String rolls) {
        String frameToAnalyze = "";
        for (int i = 0; i < rolls.length(); i++) {
            if (rolls.charAt(i) == 'X') {
                frameToAnalyze = String.valueOf(rolls.charAt(i)); //Strike
            } else if (i >= 20) {
                frameToAnalyze = rolls.charAt(i) + "-";//last frame is spare
            } else {
                frameToAnalyze = rolls.substring(i, i + 2);//spare and normal
                i++;
            }
            analyzeFrame(frameToAnalyze);
        }

    }

    private void analyzeFrame(String frameToAnalyze) {

        if (frameToAnalyze.length() == 1) {//strike
            setFrames(new StrikeFrame());
        } else {
            int firstRoll = Integer.parseInt(String.valueOf(frameToAnalyze.charAt(0)));
            if (frameToAnalyze.contains("/")) {//spare
                setFrames(new SpareFrame(firstRoll));
            } else if (frameToAnalyze.contains("-")) {//normal with - sign
                setFrames(new NormalFrame(firstRoll, 0));
            } else {//normal
                int secondRoll = Integer.parseInt(String.valueOf(frameToAnalyze.charAt(1)));
                setFrames(new NormalFrame(firstRoll, secondRoll));
            }
        }
    }

    private void setFrames(Frame frame) {
        frames.add(frame);
    }

    public List<Frame> getFrames() {
        return frames;
    }

}
