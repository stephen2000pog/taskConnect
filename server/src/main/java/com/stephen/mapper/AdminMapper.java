package com.stephen.mapper;

import com.stephen.dto.AdminDTO;
import com.stephen.model.Admin;

public class AdminMapper {
    public Admin toEntity(AdminDTO dto) {
        Admin admin = new Admin();
        admin.setId(dto.getId());
        admin.setEmail(dto.getEmail());
        admin.setFullName(dto.getFullName());
        admin.setPhotoUrl(dto.getPhotoUrl());
        admin.setRole(dto.getRole());
        admin.setRegistrationDate(dto.getRegistrationDate());
        admin.setLastLoginDate(dto.getLastLoginDate());
        admin.setStatus(dto.getStatus());
        admin.setPermissions(dto.getPermissions());
        return admin;
    }

    public AdminDTO toDto(Admin admin) {
        AdminDTO dto = new AdminDTO();
        dto.setId(admin.getId());
        dto.setEmail(admin.getEmail());
        dto.setFullName(admin.getFullName());
        dto.setPhotoUrl(admin.getPhotoUrl());
        dto.setRole(admin.getRole());
        dto.setRegistrationDate(admin.getRegistrationDate());
        dto.setLastLoginDate(admin.getLastLoginDate());
        dto.setStatus(admin.getStatus());
        dto.setPermissions(admin.getPermissions());
        return dto;
    }
}

