package com.currencymarket.dto;

import java.io.Serializable;

public class ChartDto implements Serializable {
    private String time;
    private float price;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ChartDto{" +
                "time='" + time + '\'' +
                ", price=" + price +
                '}';
    }
}
