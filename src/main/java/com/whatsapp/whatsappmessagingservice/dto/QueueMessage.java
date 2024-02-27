package com.whatsapp.whatsappmessagingservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class QueueMessage extends BaseMessage {

    @NotBlank(message = "Sender cannot be blank")
    @NonNull
    private String sender;

    @NotBlank(message = "ChatId cannot be blank")
    @NonNull
    private String chatId;

    @NotBlank(message = "CreatedTimestamp cannot be blank")
    @NonNull
    private String createdTimestamp;
}
