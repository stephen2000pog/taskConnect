package com.stephen.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public ResponseEntity<String> getDashboard() {
        return ResponseEntity.ok("Admin dashboard data");
    }

    @PostMapping("/ban-user/{userId}")
    public ResponseEntity<Void> banUser(@PathVariable Long userId) {
        // Logic to ban user
        return ResponseEntity.noContent().build();
    }
}
