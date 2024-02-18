package com.whatsapp.whatsappmessagingservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.whatsapp.whatsappmessagingservice.dto.QueueMessage;
import com.whatsapp.whatsappmessagingservice.entity.Chat;
import com.whatsapp.whatsappmessagingservice.entity.Message;
import com.whatsapp.whatsappmessagingservice.entity.User;
import com.whatsapp.whatsappmessagingservice.exception.ChatNotFoundException;
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

    @SuppressWarnings("null")
    public Chat saveChat(String receiverPhone, Message message) {
        Chat chat = new Chat();
        chat.setLatestMessage(message);
        List<Message> messages = new ArrayList<>();
        messages.add(message);
        chat.setMessages(messages);
        List<User> participants = new ArrayList<>();
        participants.add(userRepository.findByPhone(receiverPhone).get());
        chat.setParticipants(participants);
        message.setChat(chat);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        message.setSender(userRepository.findByPhone(receiverPhone).get());
        chatRepository.save(chat);
        log.info(message.toString());
        return chat;
    }

}
