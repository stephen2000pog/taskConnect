package com.stephen.dto;

import com.stephen.model.enums.Plan;
import com.stephen.model.enums.SubscriptionType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class FreelanceDTO extends UserDTO {
    private String profileTitle;
    private String profileDescription;
    private List<String> serviceCategories;
    private String serviceArea;
    private String priceInfo;
    private Plan plan;
    private SubscriptionType subscriptionType;
    private LocalDate subscriptionEndDate;
    private Integer messageLimitRemaining;
}

