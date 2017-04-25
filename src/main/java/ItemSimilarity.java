import org.apache.commons.math3.ml.distance.EuclideanDistance;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.similarity.AbstractItemSimilarity;

import java.lang.reflect.Field;
import java.util.Arrays;

import static java.lang.System.in;

public class ItemSimilarity extends AbstractItemSimilarity {
    private Database database;

    protected ItemSimilarity(ItemModel dataModel, Database database) {
        super(dataModel);
        this.database = database;
    }


    public double itemSimilarity(long l, long l1) throws TasteException {
         ItemModel item1 = database.getItem(l);
         ItemModel item2 = database.getItem(l1);

        ComparisonService comparisonService = new ComparisonService();

        // Probably best not to do this with reflection
        Field[] item1Fields = item1.getClass().getDeclaredFields();
        Field[] item2Fields = item2.getClass().getDeclaredFields();

        // This assumes item1 and item2 are the same type
        for (int i = 0; i < item1Fields.length; i++) {
            try {
                // String comparison
                if (item1Fields[i].getType() == String[].class) {
                    String[] value1 = new String[]{}, value2 = new String[]{};
                    item1Fields[i].get(value1);
                    item2Fields[i].get(value2);

                    comparisonService.stringCompare(Arrays.asList(value1), Arrays.asList(value2));
                }
                // Comparable comparison
                if(item1Fields[i].getType() == Comparable[].class) {
                    Comparable[] value1 = new Comparable[]{}, value2 = new Comparable[]{};
                    item1Fields[i].get(value1);
                    item2Fields[i].get(value2);

                    comparisonService.compare(Arrays.asList(value1), Arrays.asList(value2));
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

        // Calculate euclidean distance - https://en.wikipedia.org/wiki/Euclidean_distance
        double distance = new EuclideanDistance().compute(paramsA, paramsB);
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
