package com.thestreet.itemBasedRecommender.weighting;

import java.util.Map;

/**
 * Created by philip.mortiboy on 15/05/2017.
 */
public class UnWeighted implements Weighting {
    public double getWeighting(String fieldName) {
        return 0;
    }

    public void add(Map<String, Double> weightings) {

    }
}
