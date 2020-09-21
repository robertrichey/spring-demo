package com.udacity.java.course1.review.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ChatMessage {
    private Integer messageid;
    private String username;
    private String messagetext;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return messagetext;
    }

    public void setMessage(String message) {
        this.messagetext = message;
    }
}
