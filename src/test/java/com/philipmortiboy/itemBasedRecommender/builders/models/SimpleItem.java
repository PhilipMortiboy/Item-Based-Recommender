package com.philipmortiboy.itemBasedRecommender.builders.models;

public class SimpleItem implements TestItemModel {
    private SimpleComparable[] comparableCollection;
    private String[] stringCollection;
    private long id;


    public SimpleComparable[] getComparableCollection() {
        return comparableCollection;
    }

    public void setComparableCollection(SimpleComparable[] comparableCollection) {
        this.comparableCollection = comparableCollection;
    }

    public String[] getStringCollection() {
        return stringCollection;
    }

    public void setStringCollection(String[] stringCollection) {
        this.stringCollection = stringCollection;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
