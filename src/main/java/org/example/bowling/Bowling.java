package org.example.bowling;

public class Bowling {
    private int score = 0;

    public void roll(int pins) {
        score += pins;
    }

    public int score() {
        return score;
    }
}
