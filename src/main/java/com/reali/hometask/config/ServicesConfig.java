package com.reali.hometask.config;

import com.reali.hometask.services.ListingFilterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfig {

    @Bean
    public ListingFilterService listingFilterService(){
        return new ListingFilterService();
    }
}
