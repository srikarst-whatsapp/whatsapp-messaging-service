package com.whatsapp.whatsappmessagingservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.whatsapp.whatsappmessagingservice.entity.ChatMessage;

public interface ChatMessageRepository extends CrudRepository<ChatMessage, String> {
}