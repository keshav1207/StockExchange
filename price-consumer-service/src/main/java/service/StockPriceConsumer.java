package service;

import com.common.dto.StockPrice;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StockPriceConsumer {
    private final RedisTemplate<String, Double> redisTemplate;
    private final WebSocketService webSocketService;

    public StockPriceConsumer(RedisTemplate<String,Double> redisTemplate, WebSocketService webSocketService){
        this.redisTemplate = redisTemplate;
        this.webSocketService = webSocketService;
    }

    @KafkaListener(topics="stock-prices", groupId = "price-consumer-service")
    public void consume(StockPrice price){
        // Store latest price in Redis
        redisTemplate.opsForValue()
                .set(price.getSymbol(), price.getValue());

        //  Push price to WebSocket clients
        webSocketService.pushPriceUpdate(price);
    }

}
