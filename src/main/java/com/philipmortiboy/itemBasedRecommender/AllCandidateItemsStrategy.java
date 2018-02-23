package com.philipmortiboy.itemBasedRecommender;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.FastIDSet;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.recommender.AbstractCandidateItemsStrategy;
import org.apache.mahout.cf.taste.model.DataModel;

public class AllCandidateItemsStrategy extends AbstractCandidateItemsStrategy {
    protected FastIDSet doGetCandidateItems(long[] longs, DataModel dataModel, boolean b) throws TasteException {
        FastIDSet idSet = new FastIDSet(dataModel.getNumItems());

        for (LongPrimitiveIterator it = dataModel.getItemIDs(); it.hasNext(); ) {
            idSet.add(it.next());
        }

        return idSet;
    }
}
