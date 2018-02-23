package com.philipmortiboy.itemBasedRecommender.comparison;

import com.philipmortiboy.itemBasedRecommender.Comparable;

import java.util.Collection;
import java.util.HashMap;

public class ComparisonService {
    private HashMap<String, Comparison> comparisons;

    public ComparisonService(){
        this.comparisons = new HashMap<String, Comparison>();
    }

    public <T extends Comparable> void compare(Iterable<T> a1, Iterable<T> a2){
        this.compare(a1, a2, 0);
    }

    public <T extends Comparable> void compare(Iterable<T> a1, Iterable<T> a2, double weight){
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

    public void stringCompare(Collection<String> a1, Collection<String> a2) {
        this.stringCompare(a1, a2, 0);
    }

    public void stringCompare(Collection<String> a1, Collection<String> a2, double weight) {
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

    public void stringCompare(String a1, String a2) {

    }

    public HashMap<String, Comparison> getComparisons() {
        return comparisons;
    }
}
