package com.whatsapp.whatsappmessagingservice.dto;

import jakarta.validation.constraints.NotBlank;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class BaseMessage {

    BaseMessage(BaseMessage baseMessage) {
        this.id = baseMessage.getId();
        this.body = baseMessage.body;
    }

    @NonNull
    private String id;

    @NotBlank(message = "Body cannot be blank")
    @NonNull
    private String body;
}
