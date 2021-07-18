package com.reali.hometask.controllers;

import com.reali.hometask.datainfo.GeoJsonInfo;
import com.reali.hometask.persistence.Listing;
import com.reali.hometask.persistence.ListingRepository;
import com.reali.hometask.services.GeoJsonGeneratorService;
import com.reali.hometask.services.ListingFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v0")
public class ListingController {

    @Autowired
    private ListingRepository listingRepository;

    @Autowired
    private GeoJsonGeneratorService geoJsonGeneratorService;
    @Autowired
    private ListingFilterService filterService;

    @GetMapping("/listings")
    @ResponseBody
    public ResponseEntity<GeoJsonInfo> getAllListings(@RequestParam(required = false, name= "min_price") Long minPrice, @RequestParam(required = false, name= "max_price") Long maxPrice, @RequestParam(required = false,name= "min_bed") Long minBed, @RequestParam(required = false,name= "max_bed") Long maxBed, @RequestParam(required = false,name= "min_bath") Long minBath, @RequestParam(required = false,name= "max_bath") Long maxBath) {

        List<GeoJsonInfo> geoJsons = new ArrayList<>();
        List<Listing> filteredListings = filterService.filter(listingRepository.findAll(), minPrice, maxPrice, minBed, maxBed, minBath, maxBath);
        return ResponseEntity.ok(geoJsonGeneratorService.map(filteredListings));
    }
}