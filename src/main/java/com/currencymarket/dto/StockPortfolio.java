package com.currencymarket.dto;

import java.io.Serializable;

public class StockPortfolio implements Serializable {
    private String companyName;
    private int counterOfStocks;
    private float percentAssetsOfCompany;

    public StockPortfolio(String companyName, int counterOfStocks, float percentAssetsOfCompany) {
        this.companyName = companyName;
        this.counterOfStocks = counterOfStocks;
        this.percentAssetsOfCompany = percentAssetsOfCompany;
    }

    public StockPortfolio() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCounterOfStocks() {
        return counterOfStocks;
    }

    public void setCounterOfStocks(int counterOfStocks) {
        this.counterOfStocks = counterOfStocks;
    }

    public float getPercentAssetsOfCompany() {
        return percentAssetsOfCompany;
    }

    public void setPercentAssetsOfCompany(float percentAssetsOfCompany) {
        this.percentAssetsOfCompany = percentAssetsOfCompany;
    }

    @Override
    public String toString() {
        return "StockPortfolio{" +
                "companyName='" + companyName + '\'' +
                ", counterOfStocks=" + counterOfStocks +
                ", percentAssetsOfCompany=" + percentAssetsOfCompany +
                '}';
    }
}
