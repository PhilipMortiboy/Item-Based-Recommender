package com.thestreet.itemBasedRecommender;

public class Comparison{
    private double scoreA = 0;
    private double scoreB = 0;

    void setScoreA(double scoreA) {
        this.scoreA = scoreA;
    }

    void setScoreB(double scoreB) {
        this.scoreB = scoreB;
    }

    public double getScoreA() {
        return scoreA;
    }

    public double getScoreB() {
        return scoreB;
    }
}
