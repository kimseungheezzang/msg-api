package com.example.chattest.model;

public record ChatMsgRequest(
        String chatMsg,
        String senderName
) {
}
