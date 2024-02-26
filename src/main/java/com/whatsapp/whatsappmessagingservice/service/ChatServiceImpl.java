package com.whatsapp.whatsappmessagingservice.service;

import java.util.ArrayList;
import java.util.List;

import com.whatsapp.whatsappmessagingservice.dto.UserMessage;
import com.whatsapp.whatsappmessagingservice.entity.Chat;
import com.whatsapp.whatsappmessagingservice.entity.Message;
import com.whatsapp.whatsappmessagingservice.entity.User;
import com.whatsapp.whatsappmessagingservice.repository.ChatRepository;
import com.whatsapp.whatsappmessagingservice.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class ChatServiceImpl implements ChatService {

    ChatRepository chatRepository;
    UserRepository userRepository;
    NewMessageFactory newMessageFactory;

    @SuppressWarnings("null")
    public Chat saveChat(String receiverPhone, UserMessage userMessage) {
        Chat chat = new Chat();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String senderPhone = authentication.getPrincipal().toString();
        User sender = userRepository.findByPhone(senderPhone).get();
        User receiver = userRepository.findByPhone(receiverPhone).get();
        Message message = newMessageFactory.getNewMessage(chat, sender, userMessage.getBody());
        chat.setLatestMessage(message);
        List<Message> messages = new ArrayList<>();
        messages.add(message);
        chat.setMessages(messages);
        List<User> participants = new ArrayList<>();
        participants.add(sender);
        participants.add(receiver);
        chat.setParticipants(participants);
        chatRepository.save(chat);
        log.info(message.toString());
        return chat;
    }

}
