package com.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.flowable.rest.service.api.RestResponseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Overwrite {

    @Bean
    public RestResponseFactory restResponseFactory() {
        return new RestResponseFactory(new ObjectMapper());
    }
}
