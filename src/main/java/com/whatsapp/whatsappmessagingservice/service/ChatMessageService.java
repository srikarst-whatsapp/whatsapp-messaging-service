package com.whatsapp.whatsappmessagingservice.service;

import com.whatsapp.whatsappmessagingservice.entity.ChatMessage;

public interface ChatMessageService {
    ChatMessage postMessageToChat(ChatMessage chatMessage);
}
