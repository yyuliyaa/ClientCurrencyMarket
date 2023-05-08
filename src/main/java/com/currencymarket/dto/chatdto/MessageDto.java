package com.currencymarket.dto.chatdto;

import java.io.Serializable;

public class MessageDto implements Serializable {
    private int id;
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
