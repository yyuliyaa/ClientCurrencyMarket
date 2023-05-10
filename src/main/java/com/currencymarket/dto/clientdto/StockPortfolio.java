package com.currencymarket.dto.clientdto;

import java.io.Serializable;

public class StockPortfolio implements Serializable {
    private String companyName;
    private Double counterOfStocks;

    public StockPortfolio(String companyName, Double counterOfStocks) {
        this.companyName = companyName;
        this.counterOfStocks = counterOfStocks;
    }

    public StockPortfolio() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getCounterOfStocks() {
        return counterOfStocks;
    }

    public void setCounterOfStocks(Double counterOfStocks) {
        this.counterOfStocks = counterOfStocks;
    }


    @Override
    public String toString() {
        return "StockPortfolio{" +
                "companyName='" + companyName + '\'' +
                ", counterOfStocks=" + counterOfStocks +
                '}';
    }
}