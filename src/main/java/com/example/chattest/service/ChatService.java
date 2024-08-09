package com.example.chattest.service;

import com.example.chattest.entity.Chat;
import com.example.chattest.model.ChatMsgRequest;
import com.example.chattest.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;

    public Flux<Chat> inRoom(int roomId) {
        return chatRepository.findByRoomId(roomId).subscribeOn(Schedulers.boundedElastic());

    }

    public Mono<Chat> setMsg(int roomId, ChatMsgRequest request) {
        Chat chat = new Chat();
        chat.setRoomId(roomId);
        chat.setChatMsg(request.chatMsg());
        chat.setSenderName(request.senderName());
        chat.setDateSend(LocalDateTime.now());
        return chatRepository.save(chat);
    }
}
