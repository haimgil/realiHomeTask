package com.reali.hometask.config;

import com.reali.hometask.mappers.MapGeometry;
import com.reali.hometask.mappers.MapListingToFeature;
import com.reali.hometask.mappers.MapProperties;
import com.reali.hometask.services.GeoJsonGeneratorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeojsonConfig {

    @Bean
    public GeoJsonGeneratorService mapListingToGeoJsonService(){
        return new GeoJsonGeneratorService();
    }
    @Bean
    public MapListingToFeature mapListingToFeature(){
        return new MapListingToFeature();
    }
    @Bean
    public MapGeometry mapGeometry(){
        return new MapGeometry();
    }
    @Bean
    public MapProperties mapProperties(){
        return new MapProperties();
    }
}
