package com.thestreet.itemBasedRecommender;

import com.thestreet.itemBasedRecommender.builders.GenericDataModelBuilder;
import com.thestreet.itemBasedRecommender.builders.SimpleItemBuilder;
import com.thestreet.itemBasedRecommender.builders.models.SimpleComparable;
import com.thestreet.itemBasedRecommender.builders.models.TestItemModel;
import com.thestreet.itemBasedRecommender.mocks.MockDatabase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ItemSimilarityTests {

    /**
     * Test that two items with identical attributes discarded as outliers
     */
    @Test
    public void SameItemsAreDiscarded() {
        try {
            MockDatabase db = new MockDatabase();
            db.addItems(new TestItemModel[] {
                    new SimpleItemBuilder()
                            .withId(1)
                            .withComparableCollection(
                                    new SimpleComparable[]{new SimpleComparable("test", 1)})
                            .withStringCollection(
                                    new String[]{"test"})
                            .build(),
                    new SimpleItemBuilder()
                            .withId(2)
                            .withComparableCollection(
                                    new SimpleComparable[]{new SimpleComparable("test", 1)})
                            .withStringCollection(
                                    new String[]{"test"})
                            .build()
            });

            ItemSimilarity itemSimilarity = new ItemSimilarity(
                    new GenericDataModelBuilder().build(),
                    db
            );
            double score = itemSimilarity.itemSimilarity(1, 2);

            assertEquals(0, score, 0);

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
