package com.reali.hometask.services;

import com.reali.hometask.persistence.Listing;

import java.util.List;
import java.util.stream.Collectors;

public class ListingFilterService {

    public List<Listing> filter(List<Listing> allListings, Long min_price, Long max_price, Long min_bed, Long max_bed, Long min_bath, Long max_bath){
        
        return allListings.stream()
                .filter(listing -> filterByPrice(listing, min_price, max_price))
                .filter(listing -> filterByBeds(listing, min_bed, max_bed))
                .filter(listing -> filterByBaths(listing, min_bath, max_bath))
                .collect(Collectors.toList());
    }

    private boolean filterByBaths(Listing listing, Long min_bath, Long max_bath) {
        if (min_bath==null && max_bath==null){
            return true;
        }
        if (min_bath == null){
            return listing.getBathrooms() <= max_bath;
        }
        if (max_bath == null){
            return listing.getBathrooms() >= min_bath;
        }
        return listing.getBathrooms() >= min_bath && listing.getBathrooms() <= max_bath;
    }

    private boolean filterByBeds(Listing listing, Long min_bed, Long max_bed) {
        if (min_bed==null && max_bed==null){
            return true;
        }
        if (min_bed == null){
            return listing.getPrice() <= max_bed;
        }
        if (max_bed == null){
            return listing.getPrice() >= min_bed;
        }
        return listing.getPrice() >= min_bed && listing.getPrice() <= max_bed;
    }

    private boolean filterByPrice(Listing listing, Long min_price, Long max_price) {
        if (min_price==null && max_price==null){
            return true;
        }
        if (min_price == null){
            return listing.getPrice() <= max_price;
        }
        if (max_price == null){
            return listing.getPrice() >= min_price;
        }
        return listing.getPrice() >= min_price && listing.getPrice() <= max_price;
    }
}
