package com.stephen.dto;

import com.stephen.model.enums.Role;
import com.stephen.model.enums.Status.AccountStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String email;
    private String fullName;
    private String photoUrl;
    private Role role;
    private LocalDate registrationDate;
    private LocalDate lastLoginDate;
    private AccountStatus status;
}

