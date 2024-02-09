package com.whatsapp.whatsappmessagingservice.service;

import java.util.List;

import com.whatsapp.whatsappmessagingservice.entity.Message;

public interface MessageService {
    List<Message> getMessages(Long senderId, Long receiverId);

    Message addMessageToChat(Message message, Long senderId, Long receiverId);
}
