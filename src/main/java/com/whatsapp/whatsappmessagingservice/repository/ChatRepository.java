package com.whatsapp.whatsappmessagingservice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.whatsapp.whatsappmessagingservice.entity.Chat;
import com.whatsapp.whatsappmessagingservice.entity.ChatId;

public interface ChatRepository extends CrudRepository<Chat, ChatId> {
    Optional<Chat> findBySenderIdAndReceiverIdOrReceiverIdAndSenderId(Long senderId, Long receiverId, Long receiverId2,
            Long senderId2);
}