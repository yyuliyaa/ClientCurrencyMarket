package com.currencymarket.dto.admindto;

import java.io.Serializable;

public class CompanyRequestStatus implements Serializable {
    private String owner;
    private String companyName;
    private String companyStatus;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(String companyStatus) {
        this.companyStatus = companyStatus;
    }

    @Override
    public String toString() {
        return "CompanyRequestStatus{" +
                "owner='" + owner + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyStatus='" + companyStatus + '\'' +
                '}';
    }
}
