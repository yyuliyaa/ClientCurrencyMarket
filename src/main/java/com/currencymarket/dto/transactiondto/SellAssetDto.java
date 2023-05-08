package com.currencymarket.dto.transactiondto;

import java.io.Serializable;

public class SellAssetDto implements Serializable {
    private String companyName;
    private float price;
    private int counterOfStocks;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

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

    @Override
    public String toString() {
        return "SellAssetDto{" +
                "companyName='" + companyName + '\'' +
                ", price=" + price +
                ", counterOfStocks=" + counterOfStocks +
                '}';
    }
}
