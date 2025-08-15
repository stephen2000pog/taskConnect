package com.stephen.dto;

import com.stephen.model.enums.Status.SubscriptionStatus;
import com.stephen.model.enums.SubscriptionType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SubscriptionDTO {
    private Long id;
    private Long freelanceId;
    private SubscriptionType type;
    private LocalDate startDate;
    private LocalDate endDate;
    private SubscriptionStatus status;
}

