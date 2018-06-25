package lv.shebaka.bowlingGameKata;

public class Game {
    private int[] rolls = new int[20];
    private int currentRoll = 0;
    public boolean gameOver = false;
    public String errorMsg;

    public void roll(int pinCount) {
        if (isViableForGame(pinCount))
            rolls[currentRoll++] = pinCount;
        else {
            errorMsg = "Wrong number";
            System.out.println(errorMsg);
        }
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) {
                score += 10 + strikeBonus(frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += sumOfPinsInFrame(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private int sumOfPinsInFrame(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }

    private int spareBonus(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] +
                rolls[frameIndex + 2];
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }

    private boolean isViableForGame(int pins) {
        return pins >= 0 && pins <= 10;
    }
}
