package com.reali.hometask.mappers;

import com.reali.hometask.datainfo.FeatureInfo;
import com.reali.hometask.persistence.Listing;
import org.springframework.beans.factory.annotation.Autowired;

public class MapListingToFeature {

    @Autowired
    private MapGeometry mapGeometry;
    @Autowired
    private MapProperties mapProperties;

    public FeatureInfo map(Listing listing){
        FeatureInfo feature = new FeatureInfo();
        feature.setType("Feature");
        feature.setGeometry(mapGeometry.map(listing));
        feature.setProperties(mapProperties.map(listing));
        return feature;
    }
}
