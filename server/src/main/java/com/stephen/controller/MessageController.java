package com.stephen.controller;

import com.stephen.dto.MessageDTO;
import com.stephen.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/message/{messageId}")
    public ResponseEntity<MessageDTO> getMessage(@PathVariable Long messageId) {
        Optional<MessageDTO> message = messageService.getMessageById(messageId);
        return message.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MessageDTO> sendMessage(@RequestBody MessageDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(messageService.sendMessage(dto));
    }
}

