package com.philipmortiboy.itemBasedRecommender.vectors;

import com.philipmortiboy.itemBasedRecommender.Comparable;
import com.philipmortiboy.itemBasedRecommender.ItemModel;
import com.philipmortiboy.itemBasedRecommender.ItemModelHelper;
import com.philipmortiboy.itemBasedRecommender.comparison.Comparison;
import com.philipmortiboy.itemBasedRecommender.comparison.ComparisonService;
import com.philipmortiboy.itemBasedRecommender.weighting.Weighting;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Created by philip.mortiboy on 16/06/2017.
 */
public class GenericVector implements Vector {
    private double[] a;
    private double[] b;

    public void build(ItemModel a, ItemModel b, Weighting weighting) {
        ComparisonService comparisonService = new ComparisonService();

        // Probably best not to do this with reflection
        Field[] aFields = a.getClass().getDeclaredFields();
        Field[] bFields = b.getClass().getDeclaredFields();

        // This assumes item1 and item2 are the same type
        for (int i = 0; i < aFields.length; i++) {
            try {
                // String comparison
                if (aFields[i].getType() == String[].class) {
                    aFields[i].setAccessible(true);
                    bFields[i].setAccessible(true);
                    Object fieldValA = aFields[i].get(a);
                    Object fieldValB = bFields[i].get(b);

                    String[] value1 = ItemModelHelper.unpack(fieldValA, String.class);
                    String[] value2 = ItemModelHelper.unpack(fieldValB, String.class);

                    double fieldWeight = weighting.getWeighting(aFields[i].getName());

                    comparisonService.stringCompare(Arrays.asList(value1), Arrays.asList(value2), fieldWeight);
                }
                // Comparable comparison
                else if(aFields[i].getType() == Comparable[].class) {
                    aFields[i].setAccessible(true);
                    bFields[i].setAccessible(true);
                    Object fieldValA = aFields[i].get(a);
                    Object fieldValB = bFields[i].get(b);

                    Comparable[] value1 = ItemModelHelper.unpack(fieldValA, Comparable.class);
                    Comparable[] value2 = ItemModelHelper.unpack(fieldValB, Comparable.class);

                    double fieldWeight = weighting.getWeighting(aFields[i].getName());

                    comparisonService.compare(Arrays.asList(value1), Arrays.asList(value2), fieldWeight);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // Build param arrays for euclidean distance calculation
        int size = comparisonService.getComparisons().size();
        double[] paramsA = new double[size];
        double[] paramsB = new double[size];

        Comparison[] conceptComparisons = comparisonService.getComparisons().values().toArray(new Comparison[size]);
        for (int i = 0; i < conceptComparisons.length; i++) {
            paramsA[i] = conceptComparisons[i].getScoreA();
            paramsB[i] = conceptComparisons[i].getScoreB();
        }

        this.a = paramsA;
        this.b = paramsB;
    }

    public double[] getA() {
        return a;
    }

    public double[] getB() {
        return b;
    }
}
