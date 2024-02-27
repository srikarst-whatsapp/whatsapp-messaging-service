package com.whatsapp.whatsappmessagingservice.consumer;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.whatsappmessagingservice.dto.QueueMessage;
import com.whatsapp.whatsappmessagingservice.entity.ChatMessage;
import com.whatsapp.whatsappmessagingservice.service.ChatMessageService;
import com.whatsapp.whatsappmessagingservice.service.NewChatMessageFactory;

import io.awspring.cloud.sqs.annotation.SqsListener;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class Consumer {
    ChatMessageService chatMessageService;
    NewChatMessageFactory newChatMessageFactory;

    @SqsListener("process-message.fifo")
    public void recieveMessage(Message<String> SqsObject) throws InterruptedException {
        try {
            QueueMessage receivedQueueMessage = new ObjectMapper().reader().forType(QueueMessage.class)
                    .readValue(SqsObject.getPayload());
            ChatMessage message = newChatMessageFactory.getNewChatMessage(receivedQueueMessage);
            chatMessageService.postMessageToChat(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}