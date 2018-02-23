package com.philipmortiboy.itemBasedRecommender.builders.models;

import com.philipmortiboy.itemBasedRecommender.Comparable;

public class SimpleComparable implements Comparable {
    private String label;
    private double score;

    public SimpleComparable(String label, double score){
        this.label = label;
        this.score = score;
    }

    public String getLabel() {
        return label;
    }

    public double getScore() {
        return score;
    }
}
