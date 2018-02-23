package com.philipmortiboy.itemBasedRecommender.weighting;

import java.util.HashMap;
import java.util.Map;

public class SimpleWeighting implements Weighting {
    private Map<String, Double> weightings;

    public SimpleWeighting() {
        weightings = new HashMap<String, Double>();
    }

    public double getWeighting(String fieldName) {
        return weightings.get(fieldName);
    }

    public void add(Map<String, Double> weightings) {
        this.weightings.putAll(weightings);
    }
}
