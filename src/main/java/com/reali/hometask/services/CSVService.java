package com.reali.hometask.services;

import com.reali.hometask.persistence.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import static com.reali.hometask.helper.CSVHelper.readCsvData;

@Service
public class CSVService {

    @Autowired
    ListingRepository repository;

    @PostConstruct
    public void initData(){
        repository.saveAll(readCsvData());
    }
}
