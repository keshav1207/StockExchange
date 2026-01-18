package com.stockexchange.priceconsumer.service;


import com.common.dto.StockPrice;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class WebSocketService {

    private final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    public void registerSession(WebSocketSession session) {
        sessions.add(session);
    }

    public void removeSession(WebSocketSession session) {
        sessions.remove(session);
    }

    public void pushPriceUpdate(StockPrice price) {
        sessions.forEach(session -> {
            try {
                session.sendMessage(new TextMessage(price.toString()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
