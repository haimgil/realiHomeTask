package com.reali.hometask.controllers;

import com.reali.hometask.datainfo.GeoJsonInfo;
import com.reali.hometask.persistence.Listing;
import com.reali.hometask.helper.CSVHelper;
import com.reali.hometask.persistence.ListingRepository;
import com.reali.hometask.services.CSVService;
import com.reali.hometask.services.GeoJsonGeneratorService;
import com.reali.hometask.services.ListingFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v0")
public class ListingController {

    @Autowired
    private ListingRepository listingRepository;

    @Autowired
    CSVService fileService;
    @Autowired
    private GeoJsonGeneratorService geoJsonGeneratorService;
    @Autowired
    private ListingFilterService filterService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (CSVHelper.hasCSVFormat(file)) {
            try {
                fileService.save(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(message);
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            }
        }
        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @GetMapping("/listings")
    @ResponseBody
    public ResponseEntity<GeoJsonInfo> getAllListings(@RequestParam(required = false, name= "minPrice") Long minPrice, @RequestParam(required = false, name= "maxPrice") Long maxPrice, @RequestParam(required = false,name= "minBed") Long minBed, @RequestParam(required = false,name= "maxBed") Long maxBed, @RequestParam(required = false,name= "minBath") Long minBath, @RequestParam(required = false,name= "maxBath") Long maxBath) {

        List<GeoJsonInfo> geoJsons = new ArrayList<>();
        List<Listing> filteredListings = filterService.filter(listingRepository.findAll(), minPrice, maxPrice, minBed, maxBed, minBath, maxBath);
        return ResponseEntity.ok(geoJsonGeneratorService.map(filteredListings));
    }
}