package com.reali.hometask.helper;

public class Pair {
    Double lat;
    Double lng;

    public Pair(double lat, double lng) {
        this.lat=lat;
        this.lng=lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
