package com.stephen.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReviewDTO {
    private Long id;
    private Long clientId;
    private Long freelanceId;
    private int rating;
    private String comment;
    private LocalDate reviewDate;
}

