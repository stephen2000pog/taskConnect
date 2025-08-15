package com.stephen.dto;

import com.stephen.model.enums.Status.MessageStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MessageDTO {
    private Long id;
    private Long senderId;
    private Long receiverId;
    private String content;
    private LocalDate sentDate;
    private MessageStatus status;
}

