package com.currencymarket.dto.companydto;

import java.io.Serializable;

public class CurrentCompanyStatusDto implements Serializable {
    private int id;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CurrentCompanyStatusDto{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
