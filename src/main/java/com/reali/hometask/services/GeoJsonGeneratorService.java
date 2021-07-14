package com.reali.hometask.services;

import com.reali.hometask.datainfo.GeoJsonInfo;
import com.reali.hometask.mappers.MapListingToFeature;
import com.reali.hometask.persistence.Listing;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class GeoJsonGeneratorService {

    @Autowired
    private MapListingToFeature mapListingToFeature;

    public GeoJsonInfo map(Listing listing){

        GeoJsonInfo geoJsonInfo = new GeoJsonInfo();
        geoJsonInfo.setType("FeatureCollection");
        geoJsonInfo.setFeatures(new ArrayList<>());
        if (listing == null){
            return geoJsonInfo;
        }
        geoJsonInfo.getFeatures().add(mapListingToFeature.map(listing));

        return geoJsonInfo;
    }
}
