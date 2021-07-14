package com.reali.hometask.datainfo;

import java.util.List;

public class GeoJsonInfo {

    private String type;
    private List<FeatureInfo> features;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<FeatureInfo> getFeatures() {
        return features;
    }

    public void setFeatures(List<FeatureInfo> features) {
        this.features = features;
    }
}
