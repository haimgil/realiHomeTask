package com.reali.hometask.persistence;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "listings")
@EntityListeners(AuditingEntityListener.class)
public class Listing {

    private Long id;

    public Listing(Long id, String street, String status, long price, int bedrooms, int bathrooms, int sq_ft, double lat, double lng) {
        this.id = id;
        this.street = street;
        this.status = status;
        this.price = price;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.sq_ft = sq_ft;
        this.lat = lat;
        this.lng = lng;
    }

    @Column(name="street", nullable = false)
    private String street;
    @Column(name="status", nullable = false)
    private String status;
    @Column(name="price", nullable = false)
    private long price;
    @Column(name="bedrooms", nullable = false)
    private int bedrooms;
    @Column(name="bathrooms", nullable = false)
    private int bathrooms;
    @Column(name="sq_ft", nullable = false)
    private int sq_ft;
    @Column(name="lat", nullable = false)
    private double lat;
    @Column(name="lng", nullable = false)
    private double lng;

    public Listing(){}

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getSq_ft() {
        return sq_ft;
    }

    public void setSq_ft(int sq_ft) {
        this.sq_ft = sq_ft;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
