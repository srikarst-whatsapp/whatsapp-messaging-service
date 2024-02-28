package com.whatsapp.whatsappmessagingservice.entity;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chat")
public class Chat {

    @Id
    @NotBlank(message = "Id cannot be blank")
    @NonNull
    private String id = UUID.randomUUID().toString();

    @NonNull
    @ManyToMany
    private List<User> participants;

    @NonNull
    @JsonIgnore
    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)
    @OrderBy("createdTimestamp DESC")
    private List<ChatMessage> messages;

    @NonNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "latest_message_id", referencedColumnName = "id")
    private ChatMessage latestMessage;
}
