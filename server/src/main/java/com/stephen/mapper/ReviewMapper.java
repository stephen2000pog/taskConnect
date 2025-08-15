package com.stephen.mapper;

import com.stephen.dto.ReviewDTO;
import com.stephen.model.Client;
import com.stephen.model.Freelance;
import com.stephen.model.Review;
import com.stephen.repository.ClientRepository;
import com.stephen.repository.FreelanceRepository;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    private final ClientRepository clientRepository;
    private final FreelanceRepository freelanceRepository;

    public ReviewMapper(ClientRepository clientRepository, FreelanceRepository freelanceRepository) {
        this.clientRepository = clientRepository;
        this.freelanceRepository = freelanceRepository;
    }

    public Review toEntity(ReviewDTO dto) {
        Review review = new Review();
        review.setId(dto.getId());

        Client client = clientRepository.findById(dto.getClientId()).orElse(null);
        Freelance freelance = freelanceRepository.findById(dto.getFreelanceId()).orElse(null);

        review.setClient(client);
        review.setFreelance(freelance);
        review.setRating(dto.getRating());
        review.setComment(dto.getComment());
        review.setReviewDate(dto.getReviewDate());

        return review;
    }

    public ReviewDTO toDto(Review review) {
        ReviewDTO dto = new ReviewDTO();
        dto.setId(review.getId());

        dto.setClientId(review.getClient() != null ? review.getClient().getId() : null);
        dto.setFreelanceId(review.getFreelance() != null ? review.getFreelance().getId() : null);
        dto.setRating(review.getRating());
        dto.setComment(review.getComment());
        dto.setReviewDate(review.getReviewDate());

        return dto;
    }
}

