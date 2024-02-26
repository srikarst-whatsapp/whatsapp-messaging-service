package com.whatsapp.whatsappmessagingservice.service;

import com.whatsapp.whatsappmessagingservice.dto.UserMessage;
import com.whatsapp.whatsappmessagingservice.entity.Message;

public interface MessageService {
    Message postMessageToChat(String chatId, UserMessage userMessage);
}
