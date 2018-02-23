package com.philipmortiboy.itemBasedRecommender;

public interface Database<TItemModel extends ItemModel> {
    TItemModel getItem(long id);
}
