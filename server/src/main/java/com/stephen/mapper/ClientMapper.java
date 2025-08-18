package com.stephen.mapper;

import com.stephen.dto.ClientDTO;
import com.stephen.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public Client toEntity(ClientDTO dto) {
        Client client = new Client();
        client.setId(dto.getId());
        client.setEmail(dto.getEmail());
        client.setFullName(dto.getFullName());
        client.setPhotoUrl(dto.getPhotoUrl());
        client.setRole(dto.getRole());
        client.setRegistrationDate(dto.getRegistrationDate());
        client.setLastLoginDate(dto.getLastLoginDate());
        client.setStatus(dto.getStatus());
        client.setLocation(dto.getLocation());
        return client;
    }

    public ClientDTO toDto(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setEmail(client.getEmail());
        dto.setFullName(client.getFullName());
        dto.setPhotoUrl(client.getPhotoUrl());
        dto.setRole(client.getRole());
        dto.setRegistrationDate(client.getRegistrationDate());
        dto.setLastLoginDate(client.getLastLoginDate());
        dto.setStatus(client.getStatus());
        dto.setLocation(client.getLocation());
        return dto;
    }
}
