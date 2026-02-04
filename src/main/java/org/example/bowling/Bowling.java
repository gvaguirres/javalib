package org.example.bowling;

public class Bowling {
    private int[] rolls = new int[21];
    private int rollCount = 0;

    public void roll(int pins) {
        rolls[rollCount++] = pins;
        if (pins == 10 && isNotFinalFrame()) rollCount++;
    }

    private boolean isNotFinalFrame() {
        return rollCount < 19;
    }

    public int score() {
        int score = 0;

        for (int i = 0; i < 20; i += 2) {
            if (isStrike(i)) score += rolls[i] + strikeBonus(i);
            else if (isSpare(i)) score += rolls[i] + rolls[i + 1] + spareBonus(i);
            else score += rolls[i] + rolls[i + 1];
        }
        return score;
    }

    private int spareBonus(int i) {
        return rolls[i + 2];
    }

    private int strikeBonus(int i) {
        if (i == 16) return rolls[i + 2] + rolls[i + 3];
        if (i == 18) return rolls[i + 1] + rolls[i + 2];
        if (rolls[i + 2] == 10) return rolls[i + 2] + rolls[i + 4];
        return rolls[i + 2] + rolls[i + 3];
    }

    private boolean isStrike(int i) {
        return rolls[i] == 10;
    }

    private boolean isSpare(int i) {
        return rolls[i] + rolls[i + 1] == 10;
    }
}
