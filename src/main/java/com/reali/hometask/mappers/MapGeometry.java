package com.reali.hometask.mappers;

import com.reali.hometask.datainfo.GeometryInfo;
import com.reali.hometask.helper.Pair;
import com.reali.hometask.persistence.Listing;

public class MapGeometry {

    public GeometryInfo map(Listing listing){
        GeometryInfo geometry = new GeometryInfo();
        geometry.setType("Point");
        Pair pair = new Pair(listing.getLat(), listing.getLng());
        geometry.setCoordinates(pair);

        return geometry;
    }
}
