package com.thestreet.itemBasedRecommender.mocks;

import com.thestreet.itemBasedRecommender.Database;
import com.thestreet.itemBasedRecommender.ItemModel;
import com.thestreet.itemBasedRecommender.builders.models.TestItemModel;

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
