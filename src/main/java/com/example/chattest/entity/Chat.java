package com.example.chattest.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "chat")
public class Chat {
    @Id
    private String id;

    private Integer roomId;

    private String chatMsg;
    private String senderName;
    private LocalDateTime dateSend;
}
