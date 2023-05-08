package com.currencymarket.dto.clientdto;

import java.io.Serializable;

public class UpdateCashDto implements Serializable {
    private int id;
    private float cash;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCash() {
        return cash;
    }

    public void setCash(float cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "UpdateCashDto{" +
                "id=" + id +
                ", cash=" + cash +
                '}';
    }
}
