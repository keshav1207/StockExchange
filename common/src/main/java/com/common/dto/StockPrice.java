package com.common.dto;

import java.io.Serializable;

public class StockPrice implements Serializable {
    private String symbol;
    private double value;
    private long timestamp;

    public StockPrice(){}


    public StockPrice(String symbol, double value, long timestamp){
        this.symbol = symbol;
        this.value = value;
        this.timestamp = timestamp;
    }

    public String getSymbol(){
        return symbol;
    }
    public double getValue(){
        return value;
    }
    public long getTimestamp(){
        return timestamp;
    }

    public void setSymbol(String symbol){
        this.symbol = symbol;
    }
    public void setValue(double value){
        this.value = value;
    }

    public void setTimestamp(long timestamp){
        this.timestamp = timestamp;
    }
}
