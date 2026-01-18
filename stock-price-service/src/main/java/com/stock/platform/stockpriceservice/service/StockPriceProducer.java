package com.stock.platform.stockpriceservice.service;

import com.common.dto.StockPrice;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class StockPriceProducer {
    private static final String TOPIC = "stock-prices";

    private final KafkaTemplate<String, StockPrice> kafkaTemplate;
    private final Random random = new Random();
    private final Map<String, Double> prices = new HashMap<>();

    public StockPriceProducer(KafkaTemplate<String,StockPrice> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
        prices.put("META", 180.0);
        prices.put("GOOG", 200.0);
        prices.put("NVDA", 300.0);
    }

    @Scheduled(fixedRate = 1000)
    public void publishPrices(){
            prices.forEach((symbol,oldPrice) -> {
                double newPrice = oldPrice + (random.nextDouble()-0.5);
                prices.put(symbol, newPrice);

                StockPrice price = new StockPrice(symbol,newPrice, System.currentTimeMillis());
                kafkaTemplate.send(TOPIC, symbol, price);
            });
    }
}
