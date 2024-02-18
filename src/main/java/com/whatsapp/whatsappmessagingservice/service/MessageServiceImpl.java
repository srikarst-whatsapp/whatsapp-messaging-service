package com.whatsapp.whatsappmessagingservice.service;

import java.util.List;
import java.util.Optional;

import com.whatsapp.whatsappmessagingservice.entity.Chat;
import com.whatsapp.whatsappmessagingservice.entity.Message;
import com.whatsapp.whatsappmessagingservice.entity.User;
import com.whatsapp.whatsappmessagingservice.repository.ChatRepository;
import com.whatsapp.whatsappmessagingservice.repository.MessageRepository;
import com.whatsapp.whatsappmessagingservice.repository.UserRepository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {

    MessageRepository messageRepository;
    UserRepository userRepository;
    ChatRepository chatRepository;

    ChatService chatService;

}
