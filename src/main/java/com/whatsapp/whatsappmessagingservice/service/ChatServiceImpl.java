package com.whatsapp.whatsappmessagingservice.service;

import java.util.ArrayList;
import java.util.List;

import com.whatsapp.whatsappmessagingservice.dto.UserMessage;
import com.whatsapp.whatsappmessagingservice.entity.Chat;
import com.whatsapp.whatsappmessagingservice.entity.ChatMessage;
import com.whatsapp.whatsappmessagingservice.entity.User;
import com.whatsapp.whatsappmessagingservice.repository.ChatRepository;
import com.whatsapp.whatsappmessagingservice.repository.UserRepository;

import lombok.AllArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ChatServiceImpl implements ChatService {

    ChatRepository chatRepository;
    UserRepository userRepository;
    NewChatMessageFactory newMessageFactory;

    public Chat saveChat(String receiverPhone, UserMessage userMessage) {
        Chat chat = new Chat();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String senderPhone = authentication.getPrincipal().toString();
        User sender = userRepository.findByPhone(senderPhone).get();
        User receiver = userRepository.findByPhone(receiverPhone).get();
        ChatMessage chatMessage = newMessageFactory.getNewChatMessage(chat, sender, userMessage);
        chat.setLatestMessage(chatMessage);
        List<ChatMessage> chatMessages = new ArrayList<>();
        chatMessages.add(chatMessage);
        chat.setMessages(chatMessages);
        List<User> participants = new ArrayList<>();
        participants.add(sender);
        participants.add(receiver);
        chat.setParticipants(participants);
        chatRepository.save(chat);
        return chat;
    }

}
