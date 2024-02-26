package com.whatsapp.whatsappmessagingservice.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whatsapp.whatsappmessagingservice.dto.UserMessage;
import com.whatsapp.whatsappmessagingservice.entity.Message;
import com.whatsapp.whatsappmessagingservice.service.ChatService;
import com.whatsapp.whatsappmessagingservice.service.MessageService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/message")
public class MessageController {
    MessageService messageService;

    @PostMapping("/receiver/{receiverPhone}")
    public ResponseEntity<HttpStatus> postMessageToChat(@Valid @RequestBody UserMessage message,
            @PathVariable String receiverPhone) {
        messageService.postMessageToChat(receiverPhone, message);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
