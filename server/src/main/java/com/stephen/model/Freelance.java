package com.stephen.model;

import com.stephen.model.enums.Plan;
import com.stephen.model.enums.SubscriptionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "freelances")
public class Freelance extends User {

    private String profileTitle;

    @Column(length = 2000)
    private String profileDescription;

    @ElementCollection
    private List<String> serviceCategories;
    private String serviceArea;
    private String priceInfo;

    @Enumerated(EnumType.STRING)
    private Plan Plan;

    @Enumerated(EnumType.STRING)
    private SubscriptionType subscriptionType;

    private LocalDate subscriptionEndDate;

    private Integer messageLimitRemaining = 3; // par client/mois

    @OneToMany(mappedBy = "freelance", cascade = CascadeType.ALL)
    private List<Review> reviews;

}

