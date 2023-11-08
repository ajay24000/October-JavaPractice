package com.ecommerceapi.Exercise6.config;

import com.ecommerceapi.Exercise6.controller.CustomerController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerConfig {
    @Bean
    public Logger logger() {
        return LoggerFactory.getLogger(CustomerController.class);
    }
}
