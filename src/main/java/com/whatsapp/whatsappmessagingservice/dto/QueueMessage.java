package com.whatsapp.whatsappmessagingservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QueueMessage extends BaseMessage {

    public String id;
    public Long chatId;
    public String body;
    public Long sender;
    public String status;
}
