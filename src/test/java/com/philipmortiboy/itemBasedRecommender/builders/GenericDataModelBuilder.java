package com.philipmortiboy.itemBasedRecommender.builders;

import org.apache.mahout.cf.taste.impl.common.FastByIDMap;
import org.apache.mahout.cf.taste.impl.model.GenericDataModel;
import org.apache.mahout.cf.taste.model.PreferenceArray;

public class GenericDataModelBuilder {
    private FastByIDMap<PreferenceArray> userData = new FastByIDMap<PreferenceArray>();

    public GenericDataModel build() {
        return new GenericDataModel(this.userData);
    }

    public GenericDataModelBuilder withUserData(FastByIDMap<PreferenceArray> userData){
        this.userData = userData;
        return this;
    }
}
