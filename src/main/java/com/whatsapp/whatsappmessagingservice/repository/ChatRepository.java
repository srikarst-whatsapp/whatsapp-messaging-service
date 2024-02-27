package com.whatsapp.whatsappmessagingservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.whatsapp.whatsappmessagingservice.entity.Chat;

public interface ChatRepository extends CrudRepository<Chat, String> {
}