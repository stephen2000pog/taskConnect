package com.stephen.mapper;

import com.stephen.dto.MessageDTO;
import com.stephen.model.Message;
import com.stephen.repository.UserRepository;

public class MessageMapper {

    private final UserRepository userRepository;

    public MessageMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Message toEntity(MessageDTO dto) {
        Message message = new Message();
        message.setId(dto.getId());
        message.setSender(userRepository.findById(dto.getSenderId()).orElse(null));
        message.setReceiver(userRepository.findById(dto.getReceiverId()).orElse(null));
        message.setContent(dto.getContent());
        message.setSentDate(dto.getSentDate());
        message.setStatus(dto.getStatus());
        return message;
    }

    public MessageDTO toDto(Message message) {
        MessageDTO dto = new MessageDTO();
        dto.setId(message.getId());
        dto.setSenderId(message.getSender() != null ? message.getSender().getId() : null);
        dto.setReceiverId(message.getReceiver() != null ? message.getReceiver().getId() : null);
        dto.setContent(message.getContent());
        dto.setSentDate(message.getSentDate());
        dto.setStatus(message.getStatus());
        return dto;
    }
}


