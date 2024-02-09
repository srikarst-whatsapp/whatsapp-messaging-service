package com.whatsapp.whatsappmessagingservice.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whatsapp.whatsappmessagingservice.entity.Chat;
import com.whatsapp.whatsappmessagingservice.service.ChatService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatController {
    ChatService chatService;

    @GetMapping("/sender/{senderId}/receiver/{receiverId}")
    public ResponseEntity<Chat> getChat(@PathVariable Long senderId, @PathVariable Long receiverId) {
        return new ResponseEntity<>(chatService.getUnwrappedChat(senderId, receiverId), HttpStatus.OK);
    }
}
