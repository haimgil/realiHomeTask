package com.reali.hometask.datainfo;

public class PropertiesInfo {

    private Long id;
    private Long price;
    private String street;
    private Integer bedrooms;
    private Integer bathrooms;
    private Integer sq_ft;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Integer getSq_ft() {
        return sq_ft;
    }

    public void setSq_ft(Integer sq_ft) {
        this.sq_ft = sq_ft;
    }
}
