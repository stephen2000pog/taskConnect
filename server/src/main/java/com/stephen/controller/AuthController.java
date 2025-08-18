package com.stephen.controller;

import com.stephen.dto.auth.LoginDTO;
import com.stephen.dto.auth.RegisterDTO;
import com.stephen.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO request) {
        String token = authService.authenticate(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO request) {
        String token = authService.register(request.getEmail(), request.getPassword(), request.getRole());
        return ResponseEntity.ok(token);
    }

}

