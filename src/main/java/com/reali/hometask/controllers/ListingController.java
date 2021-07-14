package com.reali.hometask.controllers;

import com.reali.hometask.Listing;
import com.reali.hometask.helper.CSVHelper;
import com.reali.hometask.persistence.ListingRepository;
import com.reali.hometask.services.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v0")
public class ListingController {

    @Autowired
    private ListingRepository listingRepository;

    @Autowired
    CSVService fileService;

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
    public List<Listing> getAllListings(@RequestParam(required = false) long min_price, @RequestParam(required = false) long max_price, @RequestParam(required = false) long min_bed, @RequestParam(required = false) int max_bed, @RequestParam(required = false) long min_bath, @RequestParam(required = false) long max_bath){



        return listingRepository.findAll();
    }
}
