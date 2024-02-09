package com.whatsapp.whatsappmessagingservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.whatsapp.whatsappmessagingservice.entity.Chat;
import com.whatsapp.whatsappmessagingservice.entity.Message;
import com.whatsapp.whatsappmessagingservice.entity.User;
import com.whatsapp.whatsappmessagingservice.exception.ChatNotFoundException;
import com.whatsapp.whatsappmessagingservice.repository.ChatRepository;
import com.whatsapp.whatsappmessagingservice.repository.UserRepository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ChatServiceImpl implements ChatService {

    ChatRepository chatRepository;
    UserRepository userRepository;

    @Override
    public Optional<Chat> getChat(Long senderId, Long receiverId) {
        Optional<Chat> chat = chatRepository.findBySenderIdAndReceiverIdOrReceiverIdAndSenderId(senderId, receiverId,
                senderId,
                receiverId);
        return chat;
    }

    @Override
    public List<Message> getMessagesInChat(Long senderId, Long receiverId) {
        Optional<Chat> chat = getChat(senderId, receiverId);
        Chat unwrappedChat = unwrapChat(chat);
        return unwrappedChat.getMessages();
    }

    @Override
    public Chat getUnwrappedChat(Long senderId, Long receiverId) {
        Optional<Chat> chat = getChat(senderId, receiverId);
        return unwrapChat(chat);
    }

    @Override
    public Chat addMessageToChat(Optional<Chat> chat, User sender, User receiver, Message message) {
        Chat unwrappedChat;
        if (!chat.isPresent())
            unwrappedChat = new Chat(sender, receiver, new ArrayList<Message>(), message);
        else {
            unwrappedChat = chat.get();
            unwrappedChat.setSender(sender);
            unwrappedChat.setReceiver(receiver);
            unwrappedChat.setLatestMessage(message);
        }
        unwrappedChat.getMessages().add(message);
        return chatRepository.save(unwrappedChat);
    }

    static Chat unwrapChat(Optional<Chat> entity) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new ChatNotFoundException();
    }
}
