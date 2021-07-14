package com.reali.hometask.services;

import com.reali.hometask.persistence.Listing;
import com.reali.hometask.helper.CSVHelper;
import com.reali.hometask.persistence.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CSVService {
    @Autowired
    ListingRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Listing> tutorials = CSVHelper.csvToListings(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<Listing> getAllTutorials() {
        return repository.findAll();
    }
}
