package com.stephen.mapper;

import com.stephen.dto.FreelanceDTO;
import com.stephen.model.Freelance;
import com.stephen.model.enums.Role;
import org.springframework.stereotype.Component;

@Component
public class FreelanceMapper {

    public Freelance toEntity(FreelanceDTO dto) {
        Freelance freelance = new Freelance();
        freelance.setId(dto.getId());
        freelance.setEmail(dto.getEmail());
        freelance.setFullName(dto.getFullName());
        freelance.setPhotoUrl(dto.getPhotoUrl());
        freelance.setRole(Role.FREELANCE);
        freelance.setRegistrationDate(dto.getRegistrationDate());
        freelance.setLastLoginDate(dto.getLastLoginDate());
        freelance.setStatus(dto.getStatus());

        freelance.setProfileTitle(dto.getProfileTitle());
        freelance.setProfileDescription(dto.getProfileDescription());
        freelance.setServiceCategories(dto.getServiceCategories());
        freelance.setServiceAreas(dto.getServiceAreas());
        freelance.setPriceInfo(dto.getPriceInfo());
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
        dto.setServiceAreas(freelance.getServiceAreas());
        dto.setPriceInfo(freelance.getPriceInfo());
        dto.setSubscriptionType(freelance.getSubscriptionType());
        dto.setSubscriptionEndDate(freelance.getSubscriptionEndDate());
        dto.setMessageLimitRemaining(freelance.getMessageLimitRemaining());

        return dto;
    }
}


