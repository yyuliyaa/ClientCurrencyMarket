package com.currencymarket.dto.clientdto;

import java.io.Serializable;

public class AssetDto implements Serializable {
    private String companyName;
    private int counterOfStocks;
    private float percentOfCounterStock;

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

    public float getPercentOfCounterStock() {
        return percentOfCounterStock;
    }

    public void setPercentOfCounterStock(float percentOfCounterStock) {
        this.percentOfCounterStock = percentOfCounterStock;
    }

    @Override
    public String toString() {
        return "AssetDto{" +
                "companyName='" + companyName + '\'' +
                ", counterOfStocks=" + counterOfStocks +
                ", percentOfCounterStock=" + percentOfCounterStock +
                '}';
    }
}
