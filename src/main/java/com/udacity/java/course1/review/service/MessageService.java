package com.udacity.java.course1.review.service;

import com.udacity.java.course1.review.mapper.MessageMapper;
import com.udacity.java.course1.review.model.ChatForm;
import com.udacity.java.course1.review.model.ChatMessage;
import com.udacity.java.course1.review.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private MessageMapper messageMapper;

    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService");
    }

    public void addMessage(ChatForm chatForm) {
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());

        switch (chatForm.getMessageType()) {
            case "Say":
                newMessage.setMessage(chatForm.getMessageText());
                break;
            case "Shout":
                newMessage.setMessage(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                newMessage.setMessage(chatForm.getMessageText().toLowerCase());
                break;
        }
        messageMapper.insert(newMessage);
    }

    public List<ChatMessage> getChatMessages() {
        return messageMapper.getMessages();
    }
}
