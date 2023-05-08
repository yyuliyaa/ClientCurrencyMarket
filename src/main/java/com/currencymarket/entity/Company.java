package com.currencymarket.entity;

import java.io.Serializable;

public class Company implements Serializable{
    private int companyId;
    private String companyName;
    private String companyInfo;
    private float stockPrice;
    private float counterOfStocks;
    private int ownerId;
    private String companyStatus;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
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

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(String companyStatus) {
        this.companyStatus = companyStatus;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyInfo='" + companyInfo + '\'' +
                ", stockPrice=" + stockPrice +
                ", counterOfStocks=" + counterOfStocks +
                ", ownerId=" + ownerId +
                ", companyStatus='" + companyStatus + '\'' +
                '}';
    }
}

