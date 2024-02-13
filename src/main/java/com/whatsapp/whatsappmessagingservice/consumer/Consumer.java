package com.whatsapp.whatsappmessagingservice.consumer;

import org.springframework.stereotype.Component;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Consumer {
    @SqsListener("process-message.fifo")
    public void recieveMessage(String stringJson) throws InterruptedException {
        log.info("Message Received using SQS Listner " + stringJson);
    }
}