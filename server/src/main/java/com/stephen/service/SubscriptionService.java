package com.stephen.service;

import com.stephen.dto.SubscriptionDTO;
import com.stephen.mapper.SubscriptionMapper;
import com.stephen.model.Subscription;
import com.stephen.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;

    public SubscriptionService(SubscriptionRepository repo, SubscriptionMapper mapper) {
        this.subscriptionRepository = repo;
        this.subscriptionMapper = mapper;
    }

    public List<SubscriptionDTO> getAllSubscriptions() {
        return subscriptionRepository.findAll()
                .stream()
                .map(subscriptionMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<SubscriptionDTO> getSubscriptionById(Long id) {
        return subscriptionRepository.findById(id)
                .map(subscriptionMapper::toDto);
    }

    public SubscriptionDTO createSubscription(SubscriptionDTO dto) {
        Subscription entity = subscriptionMapper.toEntity(dto);
        Subscription saved = subscriptionRepository.save(entity);
        return subscriptionMapper.toDto(saved);
    }

    public void cancelSubscription(Long id) {
        subscriptionRepository.deleteById(id);
    }
}

