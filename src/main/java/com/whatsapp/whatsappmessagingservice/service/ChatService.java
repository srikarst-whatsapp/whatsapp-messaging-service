package com.whatsapp.whatsappmessagingservice.service;

import com.whatsapp.whatsappmessagingservice.entity.Chat;
import com.whatsapp.whatsappmessagingservice.entity.Message;

public interface ChatService {
    Chat saveChat(String receiverPhone, Message message);
}
