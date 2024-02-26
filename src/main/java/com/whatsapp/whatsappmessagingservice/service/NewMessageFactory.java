package com.whatsapp.whatsappmessagingservice.service;

import org.springframework.stereotype.Component;

import com.whatsapp.whatsappmessagingservice.entity.Chat;
import com.whatsapp.whatsappmessagingservice.entity.Message;
import com.whatsapp.whatsappmessagingservice.entity.User;

@Component
public class NewMessageFactory {
    public Message getNewMessage(Chat chat, User sender, String body) {
        Message message = new Message();
        message.setChat(chat);
        message.setSender(sender);
        message.setBody(body);
        return message;
    }
}
