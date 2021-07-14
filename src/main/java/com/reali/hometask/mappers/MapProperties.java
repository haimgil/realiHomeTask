package com.reali.hometask.mappers;

import com.reali.hometask.datainfo.PropertiesInfo;
import com.reali.hometask.persistence.Listing;

public class MapProperties {

    public PropertiesInfo map(Listing listing) {
        PropertiesInfo propertiesInfo = new PropertiesInfo();
        propertiesInfo.setId(listing.getId());
        propertiesInfo.setPrice(listing.getPrice());
        propertiesInfo.setStreet(listing.getStreet());
        propertiesInfo.setBedrooms(listing.getBedrooms());
        propertiesInfo.setBathrooms(listing.getBathrooms());
        propertiesInfo.setSq_ft(listing.getSq_ft());

        return propertiesInfo;
    }
}
