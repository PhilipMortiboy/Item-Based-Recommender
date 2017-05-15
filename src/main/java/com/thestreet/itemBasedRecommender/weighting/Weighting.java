package com.thestreet.itemBasedRecommender.weighting;

import java.util.Map;

/**
 * Used to apply weightings to comparison scores
 */
public interface Weighting {
    double getWeighting(String fieldName);
    void add(Map<String, Double> weightings);
}
