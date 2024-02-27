package com.whatsapp.whatsappmessagingservice.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "message")
public class ChatMessage {

    @Id
    @NotBlank(message = "Id cannot be blank")
    @NonNull
    private String id = UUID.randomUUID().toString();

    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "chat_id", referencedColumnName = "id")
    private Chat chat;

    @NotBlank(message = "Body cannot be blank")
    @NonNull
    @Column(name = "body", nullable = false)
    private String body;

    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "sender_phone", referencedColumnName = "phone")
    private User sender;

    @NotBlank(message = "Status cannot be blank")
    @NonNull
    @Column(name = "status", nullable = false)
    private String status;

    @Past(message = "The created time must be in the past")
    @NonNull
    @Column(name = "created_timestamp", nullable = false)
    private LocalDateTime createdTimestamp;
}
