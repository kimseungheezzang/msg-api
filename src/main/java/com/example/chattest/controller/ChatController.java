package com.example.chattest.controller;

import com.example.chattest.entity.Chat;
import com.example.chattest.model.ChatMsgRequest;
import com.example.chattest.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;

    @GetMapping(value = "/room/{roomId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Chat> inRoom(@PathVariable int roomId) {
        return chatService.inRoom(roomId);
    }

    @PostMapping(value = "/send/msg/room/{roomId}")
    public Mono<Chat> sendMsg(@PathVariable int roomId, @RequestBody ChatMsgRequest request) {
        return chatService.setMsg(roomId, request);
    }
}
