package com.stephen.mapper;

import com.stephen.dto.UserDTO;
import com.stephen.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setFullName(dto.getFullName());
        user.setPhotoUrl(dto.getPhotoUrl());
        user.setRole(dto.getRole());
        user.setRegistrationDate(dto.getRegistrationDate());
        user.setLastLoginDate(dto.getLastLoginDate());
        user.setStatus(dto.getStatus());
        return user;
    }

    public UserDTO toDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setFullName(user.getFullName());
        dto.setPhotoUrl(user.getPhotoUrl());
        dto.setRole(user.getRole());
        dto.setRegistrationDate(user.getRegistrationDate());
        dto.setLastLoginDate(user.getLastLoginDate());
        dto.setStatus(user.getStatus());
        return dto;
    }
}



