package com.whatsapp.whatsappmessagingservice.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.whatsapp.whatsappmessagingservice.dto.QueueMessage;
import com.whatsapp.whatsappmessagingservice.dto.UserMessage;
import com.whatsapp.whatsappmessagingservice.entity.Chat;
import com.whatsapp.whatsappmessagingservice.entity.ChatMessage;
import com.whatsapp.whatsappmessagingservice.entity.User;
import com.whatsapp.whatsappmessagingservice.repository.ChatRepository;
import com.whatsapp.whatsappmessagingservice.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class NewChatMessageFactory {
    ChatRepository chatRepository;
    UserRepository userRepository;

    public ChatMessage getNewChatMessage(Chat chat, User sender, UserMessage userMessage) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setChat(chat);
        chatMessage.setStatus(userMessage.getStatus());
        chatMessage.setSender(sender);
        chatMessage.setCreatedTimestamp(userMessage.getCreatedTimestamp());
        chatMessage.setBody(userMessage.getBody());
        return chatMessage;
    }

    @SuppressWarnings("null")
    public ChatMessage getNewChatMessage(QueueMessage queueMessage) {
        ChatMessage chatMessage = new ChatMessage();
        Chat chat = chatRepository.findById(queueMessage.getChatId()).get();
        User sender = userRepository.findById(queueMessage.getSender()).get();
        chatMessage.setChat(chat);
        chatMessage.setStatus(queueMessage.getStatus());
        chatMessage.setSender(sender);
        chatMessage.setCreatedTimestamp(LocalDateTime.parse(queueMessage.getCreatedTimestamp()));
        chatMessage.setBody(queueMessage.getBody());
        return chatMessage;
    }
}
