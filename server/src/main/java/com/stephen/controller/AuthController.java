package com.stephen.controller;

import com.stephen.dto.auth.AuthResponse;
import com.stephen.dto.auth.LoginDTO;
import com.stephen.dto.auth.RegisterDTO;
import com.stephen.mapper.UserMapper;
import com.stephen.service.AuthService;
import com.stephen.utils.JwtUtil;
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

    @Autowired
    private JwtUtil jwtUtils;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginDTO request) {
        return ResponseEntity.ok(authService.login(request.getEmail(), request.getPassword()));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterDTO request) {
        return ResponseEntity.ok(authService.register(request.getEmail(), request.getPassword(), request.getRole()));
    }

}

