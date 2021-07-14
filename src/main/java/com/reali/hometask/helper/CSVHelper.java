package com.reali.hometask.helper;


import com.reali.hometask.persistence.Listing;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {

    public static String TYPE = "text/csv";
    static String[] HEADERS = {"id", "street", "status", "price","bedrooms", "bathrooms", "sq_ft", "lat", "lng"};

    public CSVHelper() throws IOException {
    }

    public static List<Listing> csvToListings(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Listing> listings = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                Listing listing = new Listing(Long.parseLong(csvRecord.get("id")),
                        csvRecord.get("street"),
                        csvRecord.get("status"),
                        Long.parseLong(csvRecord.get("price")),
                        Integer.parseInt(csvRecord.get("bedrooms")),
                        Integer.parseInt(csvRecord.get("bathrooms")),
                        Integer.parseInt(csvRecord.get("sq_ft")),
                        Double.parseDouble(csvRecord.get("lat")),
                        Double.parseDouble(csvRecord.get("lng")));
                listings.add(listing);
            }
            return listings;
        }catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

}