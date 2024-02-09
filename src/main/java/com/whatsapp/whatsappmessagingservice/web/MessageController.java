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
    ChatService chatService;

    @GetMapping("/sender/{senderId}/receiver/{receiverId}")
    public ResponseEntity<List<Message>> getMessagesInChat(@PathVariable Long senderId, @PathVariable Long receiverId) {
        return new ResponseEntity<>(chatService.getMessagesInChat(senderId, receiverId), HttpStatus.OK);
    }

    @PostMapping("/sender/{senderId}/receiver/{receiverId}")
    public ResponseEntity<Message> sendMessage(@Valid @RequestBody Message message, @PathVariable Long senderId,
            @PathVariable Long receiverId) {
        return new ResponseEntity<>(messageService.addMessageToChat(message, senderId, receiverId), HttpStatus.CREATED);
    }
}
