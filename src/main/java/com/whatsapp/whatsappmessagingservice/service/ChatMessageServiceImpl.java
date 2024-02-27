package com.whatsapp.whatsappmessagingservice.service;

import com.whatsapp.whatsappmessagingservice.entity.ChatMessage;
import com.whatsapp.whatsappmessagingservice.repository.ChatRepository;
import com.whatsapp.whatsappmessagingservice.repository.ChatMessageRepository;
import com.whatsapp.whatsappmessagingservice.repository.UserRepository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ChatMessageServiceImpl implements ChatMessageService {
    UserRepository userRepository;
    NewChatMessageFactory newChatMessageFactory;
    ChatMessageRepository chatMessageRepository;
    ChatRepository chatRepository;

    @SuppressWarnings("null")
    @Override
    public ChatMessage postMessageToChat(ChatMessage chatMessage) {
        chatMessageRepository.save(chatMessage);
        return chatMessage;
    }
}
