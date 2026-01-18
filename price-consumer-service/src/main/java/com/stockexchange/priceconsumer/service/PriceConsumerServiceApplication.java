package com.stockexchange.priceconsumer.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class})
public class PriceConsumerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PriceConsumerServiceApplication.class, args);
    }
}
