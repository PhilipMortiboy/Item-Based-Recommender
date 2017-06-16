package com.thestreet.itemBasedRecommender;

import com.thestreet.itemBasedRecommender.vectors.GenericVector;
import com.thestreet.itemBasedRecommender.vectors.Vector;
import com.thestreet.itemBasedRecommender.weighting.UnWeighted;
import com.thestreet.itemBasedRecommender.weighting.Weighting;
import org.apache.commons.math3.ml.distance.EuclideanDistance;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.similarity.AbstractItemSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;

public class ItemSimilarity<TItemModel extends ItemModel> extends AbstractItemSimilarity {
    private Database<TItemModel> database;
    private Weighting weighting;
    private Vector vector;

    public ItemSimilarity(DataModel dataModel, Database<TItemModel> database) {
        super(dataModel);
        this.database = database;
        this.weighting = new UnWeighted();
        this.vector = new GenericVector();
    }


    public ItemSimilarity(DataModel dataModel, Database<TItemModel> database, Vector vector) {
        super(dataModel);
        this.database = database;
        this.weighting = new UnWeighted();
        this.vector = vector;
    }

    public ItemSimilarity(DataModel dataModel, Database<TItemModel> database, Weighting weighting) {
        super(dataModel);
        this.database = database;
        this.weighting = weighting;
    }

    public double itemSimilarity(long l, long l1) throws TasteException {
         TItemModel item1 = database.getItem(l);
         TItemModel item2 = database.getItem(l1);

         if(item1 == null || item2 == null)
             return 0;

        // Build a vector for these two articles
        vector.build(item1, item2, weighting);

        // Calculate euclidean distance - https://en.wikipedia.org/wiki/Euclidean_distance
        double distance = new EuclideanDistance().compute(vector.getA(), vector.getB());
        // Discard outliers
        if(distance == 0)
            return 0;
        // A small euclidean distance indicates to items are similar
        // So make sure the items with the smallest distance receive the biggest item similarity score
        return 100 - distance;
    }

    public double[] itemSimilarities(long l, long[] longs) throws TasteException {
        return new double[0];
    }
}
