package com.stephen.model;

import com.stephen.model.enums.Status.SubscriptionStatus;
import com.stephen.model.enums.SubscriptionType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Freelance freelance;

    @Enumerated(EnumType.STRING)
    private SubscriptionType type;

    private LocalDate startDate;
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private SubscriptionStatus status;

}


