package com.thestreet.itemBasedRecommender;

import java.util.Collection;
import java.util.HashMap;

public class ComparisonService {
    private HashMap<String, Comparison> comparisons;

    ComparisonService(){
        this.comparisons = new HashMap<String, Comparison>();
    }

    <T extends Comparable> void compare(Iterable<T> a1, Iterable<T> a2){
        this.compare(a1, a2, 0);
    }

    <T extends Comparable> void compare(Iterable<T> a1, Iterable<T> a2, double weight){
        for(T item : a1){
            Comparison comparison = new Comparison(weight);
            comparison.setScoreA(item.getScore());
            comparisons.put(item.getLabel(), comparison);
        }
        for(T item : a2){
            Comparison comparison = getComparisons().get(item.getLabel());
            if(comparison == null)
                comparison = new Comparison(weight);
            comparison.setScoreB(item.getScore());
            comparisons.put(item.getLabel(), comparison);
        }
    }

    void stringCompare(Collection<String> a1, Collection<String> a2) {
        this.stringCompare(a1, a2, 0);
    }

    void stringCompare(Collection<String> a1, Collection<String> a2, double weight) {
        for(String item : a1){
            Comparison comparison = new Comparison(weight);
            comparison.setScoreA(1);
            comparisons.put(item, comparison);
        }
        for(String item : a2){
            Comparison comparison = comparisons.get(item);
            if(comparison == null)
                comparison = new Comparison(weight);
            comparison.setScoreB(1);
            comparisons.put(item, comparison);
        }
    }

    void stringCompare(String a1, String a2) {

    }

    HashMap<String, Comparison> getComparisons() {
        return comparisons;
    }
}
