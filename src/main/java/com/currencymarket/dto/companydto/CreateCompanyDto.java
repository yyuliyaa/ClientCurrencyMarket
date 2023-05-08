package com.currencymarket.dto.companydto;

import java.io.Serializable;

public class CreateCompanyDto implements Serializable {
    private int owner_id;
    private String companyName;
    private String companyInfo;
    private float stockPrice;
    private float counterOfStocks;

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    public float getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(float stockPrice) {
        this.stockPrice = stockPrice;
    }

    public float getCounterOfStocks() {
        return counterOfStocks;
    }

    public void setCounterOfStocks(float counterOfStocks) {
        this.counterOfStocks = counterOfStocks;
    }

    @Override
    public String toString() {
        return "CreateCompanyDto{" +
                "owner_id=" + owner_id +
                ", companyName='" + companyName + '\'' +
                ", companyInfo='" + companyInfo + '\'' +
                ", stockPrice=" + stockPrice +
                ", counterOfStocks=" + counterOfStocks +
                '}';
    }
}
