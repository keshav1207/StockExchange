package com.stock.platform.stockpriceservice.config;

import com.common.dto.StockPrice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public KafkaTemplate<String, StockPrice> kafkaTemplate(
            ProducerFactory<String,StockPrice> producerFactory){
        return new KafkaTemplate<>(producerFactory);
    }

}
