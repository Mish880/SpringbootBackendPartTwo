package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class WebAppConfig {
    @Bean
    public ModelMapper modelMapper() {
        System.out.println("WebAppConfig");
        return new ModelMapper();
    }

}

