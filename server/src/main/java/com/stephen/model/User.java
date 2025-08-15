package com.stephen.model;

import com.stephen.model.enums.Role;
import com.stephen.model.enums.Status.AccountStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Getter
    private String passwordHash;

    private String fullName;
    private String photoUrl;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDate registrationDate;
    private LocalDate lastLoginDate;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;
}
