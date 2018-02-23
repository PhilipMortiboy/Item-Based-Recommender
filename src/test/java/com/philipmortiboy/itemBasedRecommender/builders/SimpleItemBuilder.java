package com.philipmortiboy.itemBasedRecommender.builders;

import com.philipmortiboy.itemBasedRecommender.builders.models.SimpleComparable;
import com.philipmortiboy.itemBasedRecommender.builders.models.SimpleItem;

public class SimpleItemBuilder {
    private SimpleComparable[] comparableCollection;
    private String[] stringCollection;
    private long id;

    public SimpleItem build(){
        SimpleItem simpleItem = new SimpleItem();

        simpleItem.setId(id);
        simpleItem.setComparableCollection(comparableCollection);
        simpleItem.setStringCollection(stringCollection);

        return simpleItem;
    }

    public SimpleItemBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public SimpleItemBuilder withComparableCollection(SimpleComparable[] comparableCollection){
        this.comparableCollection = comparableCollection;
        return this;
    }

    public SimpleItemBuilder withStringCollection(String[] stringCollection){
        this.stringCollection = stringCollection;
        return this;
    }
}
