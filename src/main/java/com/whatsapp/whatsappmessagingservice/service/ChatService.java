package com.whatsapp.whatsappmessagingservice.service;

import com.whatsapp.whatsappmessagingservice.dto.UserMessage;
import com.whatsapp.whatsappmessagingservice.entity.Chat;

public interface ChatService {
    Chat saveChat(String receiverPhone, UserMessage userMessage);
}
