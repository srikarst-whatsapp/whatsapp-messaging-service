package com.whatsapp.whatsappmessagingservice.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whatsapp.whatsappmessagingservice.dto.UserMessage;
import com.whatsapp.whatsappmessagingservice.service.ChatService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatController {
    ChatService chatService;

    @PostMapping("/receiver/{receiverPhone}")
    public ResponseEntity<HttpStatus> saveChat(@Valid @RequestBody UserMessage userMessage,
            @PathVariable String receiverPhone) {
        chatService.saveChat(receiverPhone, userMessage);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
