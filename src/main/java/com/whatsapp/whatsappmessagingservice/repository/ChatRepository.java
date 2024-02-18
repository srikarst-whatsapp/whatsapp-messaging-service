package com.whatsapp.whatsappmessagingservice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.whatsapp.whatsappmessagingservice.entity.Chat;

public interface ChatRepository extends CrudRepository<Chat, String> {
}