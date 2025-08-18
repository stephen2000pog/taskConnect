package com.stephen.mapper;

import com.stephen.dto.SubscriptionDTO;
import com.stephen.model.Subscription;
import com.stephen.repository.FreelanceRepository;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionMapper {

    private final FreelanceRepository freelanceRepository;

    public SubscriptionMapper(FreelanceRepository freelanceRepository) {
        this.freelanceRepository = freelanceRepository;
    }

    public Subscription toEntity(SubscriptionDTO dto) {
        Subscription subscription = new Subscription();
        subscription.setId(dto.getId());
        subscription.setFreelance(freelanceRepository.findById(dto.getFreelanceId()).orElse(null));
        subscription.setType(dto.getType());
        subscription.setStartDate(dto.getStartDate());
        subscription.setEndDate(dto.getEndDate());
        subscription.setStatus(dto.getStatus());
        return subscription;
    }

    public SubscriptionDTO toDto(Subscription subscription) {
        SubscriptionDTO dto = new SubscriptionDTO();
        dto.setId(subscription.getId());
        dto.setFreelanceId(subscription.getFreelance() != null ? subscription.getFreelance().getId() : null);
        dto.setType(subscription.getType());
        dto.setStartDate(subscription.getStartDate());
        dto.setEndDate(subscription.getEndDate());
        dto.setStatus(subscription.getStatus());
        return dto;
    }
}
