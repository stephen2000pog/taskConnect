package com.stephen.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "admins")
public class Admin extends User {
    @ElementCollection
    private List<String> permissions; // Exemple : ["MANAGE_USERS", "MODERATE_MESSAGES"]
}

