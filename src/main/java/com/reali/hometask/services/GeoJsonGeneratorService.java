package com.reali.hometask.services;

import com.reali.hometask.datainfo.GeoJsonInfo;
import com.reali.hometask.mappers.MapListingToFeature;
import com.reali.hometask.persistence.Listing;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GeoJsonGeneratorService {

    @Autowired
    private MapListingToFeature mapListingToFeature;

    public GeoJsonInfo map(List<Listing> listings){

        GeoJsonInfo geoJsonInfo = new GeoJsonInfo();
        geoJsonInfo.setType("FeatureCollection");
        geoJsonInfo.setFeatures(new ArrayList<>());
        if (listings == null || listings.isEmpty()){
            return geoJsonInfo;
        }
        for (Listing listing : listings) {
            geoJsonInfo.getFeatures().add(mapListingToFeature.map(listing));
        }

        return geoJsonInfo;
    }
}
