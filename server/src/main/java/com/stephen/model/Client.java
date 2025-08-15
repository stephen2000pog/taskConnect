package com.stephen.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "clients") //what
public class Client extends User {

    private String location;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Message> messages;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Review> reviews;
}

