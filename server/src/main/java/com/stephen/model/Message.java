package com.stephen.model;

import com.stephen.model.enums.Status.MessageStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    
    @ManyToOne
    private User sender;

    @ManyToOne
    private User receiver;

    @Column(length = 2000)
    private String content;

    private LocalDate sentDate;

    @Enumerated(EnumType.STRING)
    private MessageStatus status;

}

