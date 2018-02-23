package com.philipmortiboy.itemBasedRecommender.mocks;

import com.philipmortiboy.itemBasedRecommender.Database;
import com.philipmortiboy.itemBasedRecommender.builders.models.TestItemModel;

import java.util.HashMap;
import java.util.Map;

public class MockDatabase implements Database<TestItemModel> {
    private Map<Long, TestItemModel> collection = new HashMap<Long, TestItemModel>();

    public void addItems(TestItemModel[] items) {
        for (TestItemModel item : items)
            this.addItem(item);
    }

    public void addItem(TestItemModel item) {
        collection.put(item.getId(), item);
    }

    public TestItemModel getItem(long id) {
        return collection.get(id);
    }
}
