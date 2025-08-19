package com.stephen.factory;

import com.stephen.model.Admin;
import com.stephen.model.Client;
import com.stephen.model.Freelance;
import com.stephen.model.User;
import com.stephen.model.enums.Role;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class UserFactory {

    public User create(String email, String encodedPassword, Role role) {
        return switch (role) {
            case CLIENT -> {
                Client client = new Client();
                client.setEmail(email);
                client.setPasswordHash(encodedPassword);
                client.setRole(Role.CLIENT);
                client.setRegistrationDate(LocalDate.now());
                yield client;
            }
            case FREELANCE -> {
                Freelance freelance = new Freelance();
                freelance.setEmail(email);
                freelance.setPasswordHash(encodedPassword);
                freelance.setRole(Role.FREELANCE);
                freelance.setRegistrationDate(LocalDate.now());
                freelance.setMessageLimitRemaining(3);
                yield freelance;
            }
            case ADMIN -> {
                Admin admin = new Admin();
                admin.setEmail(email);
                admin.setPasswordHash(encodedPassword);
                admin.setRole(Role.ADMIN);
                admin.setRegistrationDate(LocalDate.now());
                admin.setPermissions(List.of("MANAGE_USERS", "MODERATE_MESSAGES"));
                yield admin;
            }
            default -> throw new IllegalArgumentException("Unsupported role: " + role);
        };
    }
}
