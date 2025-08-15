package com.stephen.service;

import com.stephen.dto.MessageDTO;
import com.stephen.mapper.MessageMapper;
import com.stephen.model.Message;
import com.stephen.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public MessageService(MessageRepository repo, MessageMapper mapper) {
        this.messageRepository = repo;
        this.messageMapper = mapper;
    }

    public List<MessageDTO> getAllMessages() {
        return messageRepository.findAll()
                .stream()
                .map(messageMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<MessageDTO> getMessageById(Long id) {
        return messageRepository.findById(id)
                .map(messageMapper::toDto);
    }

    public MessageDTO sendMessage(MessageDTO dto) {
        Message entity = messageMapper.toEntity(dto);
        Message saved = messageRepository.save(entity);
        return messageMapper.toDto(saved);
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}

