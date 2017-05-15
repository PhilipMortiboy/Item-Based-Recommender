package com.thestreet.itemBasedRecommender;

public class Comparison{
    private double scoreA = 0;
    private double scoreB = 0;
    private double weight = 0;

    public Comparison() {

    }

    Comparison(double weight) {
        this.weight = weight;
    }

    void setScoreA(double scoreA) {
        this.scoreA = scoreA;
    }

    void setScoreB(double scoreB) {
        this.scoreB = scoreB;
    }

    double getScoreA() {
        // Comparisons with a greater weight should be given more importance
        // As these scores will be used in a euclidean distance calculation, a smaller value is better
        // So divide each score by the weight
        return weight > 0 ? scoreA / weight : scoreA;
    }

    double getScoreB() {
        return weight > 0 ? scoreB / weight : scoreB;
    }
}
