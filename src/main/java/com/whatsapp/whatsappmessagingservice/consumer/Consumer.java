package com.whatsapp.whatsappmessagingservice.consumer;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.whatsappmessagingservice.dto.QueueMessage;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Consumer {
    @SqsListener("process-message.fifo")
    public void recieveMessage(Message<String> SqsObject) throws InterruptedException {
        try {
            QueueMessage receivedQueueMessage = new ObjectMapper().reader().forType(QueueMessage.class)
                    .readValue(SqsObject.getPayload());
            log.info(new ObjectMapper().writeValueAsString(receivedQueueMessage));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}