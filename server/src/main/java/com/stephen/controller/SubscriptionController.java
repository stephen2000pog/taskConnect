package com.stephen.controller;

import com.stephen.dto.SubscriptionDTO;
import com.stephen.service.SubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionDTO> getSubscription(@PathVariable Long id) {
        Optional<SubscriptionDTO> subscription = subscriptionService.getSubscriptionById(id);
        return subscription.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SubscriptionDTO> createSubscription(@RequestBody SubscriptionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionService.createSubscription(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelSubscription(@PathVariable Long id) {
        subscriptionService.cancelSubscription(id);
        return ResponseEntity.noContent().build();
    }
}

