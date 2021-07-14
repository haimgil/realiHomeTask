package com.reali.hometask.controllers;

import com.reali.hometask.datainfo.GeoJsonInfo;
import com.reali.hometask.persistence.Listing;
import com.reali.hometask.helper.CSVHelper;
import com.reali.hometask.persistence.ListingRepository;
import com.reali.hometask.services.CSVService;
import com.reali.hometask.services.GeoJsonGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<List<GeoJsonInfo>> getAllListings(@RequestParam(required = false) Long min_price, @RequestParam(required = false) Long max_price, @RequestParam(required = false) Long min_bed, @RequestParam(required = false) Integer max_bed, @RequestParam(required = false) Long min_bath, @RequestParam(required = false) Long max_bath){

        List<GeoJsonInfo> geoJsons = new ArrayList<>();
        for (Listing listing : listingRepository.findAll()) {
            geoJsons.add(geoJsonGeneratorService.map(listing));
        }
        return ResponseEntity.ok(geoJsons);
    }
}