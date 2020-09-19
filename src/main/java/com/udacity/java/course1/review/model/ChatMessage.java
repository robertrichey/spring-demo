package com.udacity.java.course1.review.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ChatMessage {
    private int id;
    private String username;
    private String message;
    private static Set<String> bannedWordList = new HashSet<>(Arrays.asList("a", "b", "c"));

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean hasBannedWord() {
        for (String s : bannedWordList) {
            if (message.contains(s)) {
                return true;
            }
        }
        return false;
    }
}
