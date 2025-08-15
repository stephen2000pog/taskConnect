package com.stephen.controller;

import com.stephen.dto.FreelanceDTO;
import com.stephen.service.FreelanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/freelances")
public class FreelanceController {

    private final FreelanceService freelanceService;

    public FreelanceController(FreelanceService freelanceService) {
        this.freelanceService = freelanceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FreelanceDTO> getFreelance(@PathVariable Long id) {
        FreelanceDTO dto = freelanceService.getFreelanceById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Freelance non trouvé"));
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<FreelanceDTO> createFreelance(@RequestBody FreelanceDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(freelanceService.createFreelance(dto));
    }
}

