package com.currencymarket.dto.transactiondto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class HistoryDto implements Serializable {

    private float price;
    private int counterOfStocks;
    private String status;
    private LocalDateTime localDateTime;


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCounterOfStocks() {
        return counterOfStocks;
    }

    public void setCounterOfStocks(int counterOfStocks) {
        this.counterOfStocks = counterOfStocks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "HistoryDto{" +
                ", price=" + price +
                ", counterOfStocks=" + counterOfStocks +
                ", status='" + status + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
