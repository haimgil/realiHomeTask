package com.reali.hometask.mappers;

import com.reali.hometask.datainfo.GeometryInfo;
import com.reali.hometask.persistence.Listing;

import java.util.ArrayList;
import java.util.List;

public class MapGeometry {

    public GeometryInfo map(Listing listing){
        GeometryInfo geometry = new GeometryInfo();
        geometry.setType("Point");
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(listing.getLng());
        coordinates.add(listing.getLat());
        geometry.setCoordinates(coordinates);

        return geometry;
    }
}
