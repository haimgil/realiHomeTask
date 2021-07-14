package com.reali.hometask.datainfo;

public class FeatureInfo {

    private String type;
    private GeometryInfo geometry;
    private PropertiesInfo properties;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public GeometryInfo getGeometry() {
        return geometry;
    }

    public void setGeometry(GeometryInfo geometry) {
        this.geometry = geometry;
    }

    public PropertiesInfo getProperties() {
        return properties;
    }

    public void setProperties(PropertiesInfo properties) {
        this.properties = properties;
    }
}
