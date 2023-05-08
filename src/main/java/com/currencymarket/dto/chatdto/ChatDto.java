package com.currencymarket.dto.chatdto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ChatDto implements Serializable {
    private String username;
    private LocalDateTime date;
    private String message;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ChatDto{" +
                "username='" + username + '\'' +
                ", date=" + date +
                ", message='" + message + '\'' +
                '}';
    }
}
