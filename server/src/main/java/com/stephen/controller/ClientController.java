package com.stephen.controller;

import com.stephen.dto.ClientDTO;
import com.stephen.mapper.ClientMapper;
import com.stephen.model.Client;
import com.stephen.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    public ClientController(ClientService clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable Long id) {
        Optional<Client> optionalClient = clientService.getClientById(id);

        return optionalClient
                .map(client -> ResponseEntity.ok(clientMapper.toDto(client)))
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO dto) {
        ClientDTO created = clientService.createClient(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

}

