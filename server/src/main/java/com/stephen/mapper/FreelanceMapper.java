package com.stephen.mapper;

import com.stephen.dto.FreelanceDTO;
import com.stephen.model.Freelance;

public class FreelanceMapper {
    public Freelance toEntity(FreelanceDTO dto) {
        Freelance freelance = new Freelance();
        freelance.setId(dto.getId());
        freelance.setEmail(dto.getEmail());
        freelance.setFullName(dto.getFullName());
        freelance.setPhotoUrl(dto.getPhotoUrl());
        freelance.setRole(dto.getRole());
        freelance.setRegistrationDate(dto.getRegistrationDate());
        freelance.setLastLoginDate(dto.getLastLoginDate());
        freelance.setStatus(dto.getStatus());
        freelance.setProfileTitle(dto.getProfileTitle());
        freelance.setProfileDescription(dto.getProfileDescription());
        freelance.setServiceCategories(dto.getServiceCategories());
        freelance.setServiceArea(dto.getServiceArea());
        freelance.setPriceInfo(dto.getPriceInfo());
        freelance.setPlan(dto.getPlan());
        freelance.setSubscriptionType(dto.getSubscriptionType());
        freelance.setSubscriptionEndDate(dto.getSubscriptionEndDate());
        freelance.setMessageLimitRemaining(dto.getMessageLimitRemaining());
        return freelance;
    }

    public FreelanceDTO toDto(Freelance freelance) {
        FreelanceDTO dto = new FreelanceDTO();
        dto.setId(freelance.getId());
        dto.setEmail(freelance.getEmail());
        dto.setFullName(freelance.getFullName());
        dto.setPhotoUrl(freelance.getPhotoUrl());
        dto.setRole(freelance.getRole());
        dto.setRegistrationDate(freelance.getRegistrationDate());
        dto.setLastLoginDate(freelance.getLastLoginDate());
        dto.setStatus(freelance.getStatus());
        dto.setProfileTitle(freelance.getProfileTitle());
        dto.setProfileDescription(freelance.getProfileDescription());
        dto.setServiceCategories(freelance.getServiceCategories());
        dto.setServiceArea(freelance.getServiceArea());
        dto.setPriceInfo(freelance.getPriceInfo());
        dto.setPlan(freelance.getPlan());
        dto.setSubscriptionType(freelance.getSubscriptionType());
        dto.setSubscriptionEndDate(freelance.getSubscriptionEndDate());
        dto.setMessageLimitRemaining(freelance.getMessageLimitRemaining());
        return dto;
    }
}

