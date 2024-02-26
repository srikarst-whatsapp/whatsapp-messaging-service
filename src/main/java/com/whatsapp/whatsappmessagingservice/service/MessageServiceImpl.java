package com.whatsapp.whatsappmessagingservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.whatsapp.whatsappmessagingservice.dto.UserMessage;
import com.whatsapp.whatsappmessagingservice.entity.Chat;
import com.whatsapp.whatsappmessagingservice.entity.Message;
import com.whatsapp.whatsappmessagingservice.entity.User;
import com.whatsapp.whatsappmessagingservice.repository.ChatRepository;
import com.whatsapp.whatsappmessagingservice.repository.MessageRepository;
import com.whatsapp.whatsappmessagingservice.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {
    UserRepository userRepository;

    @Override
    public Message postMessageToChat(String chatId, UserMessage userMessage) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String senderPhone = authentication.getPrincipal().toString();
        User sender = userRepository.findByPhone(senderPhone).get();
        Message message = newMessageFactory.getNewMessage(chat, sender, userMessage.getBody());
    }
}
