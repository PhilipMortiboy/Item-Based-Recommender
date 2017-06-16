package com.thestreet.itemBasedRecommender.vectors;

import com.thestreet.itemBasedRecommender.ItemModel;
import com.thestreet.itemBasedRecommender.weighting.Weighting;

/**
 * Builds a vector from two ItemModels that can be used in a Euclidean distance calculation
 */
public interface Vector {
    /**
     * Builds a vector
     * @param a The first ItemModel
     * @param b The second ItemModel
     */
    <TItemModel extends ItemModel, TWeighting extends Weighting> void build(TItemModel a, TItemModel b, TWeighting weighting);

    /**
     * Get all the points of ItemModel A
     */
    double[] getA();

    /**
     * Get all the points of ItemModel B
     */
    double[] getB();
}
