package com.stephen.service;

import com.stephen.dto.ReviewDTO;
import com.stephen.mapper.ReviewMapper;
import com.stephen.model.Review;
import com.stephen.repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    public ReviewService(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    public List<ReviewDTO> getAllReviews() {
        return reviewRepository.findAll().stream()
                .map(reviewMapper::toDto)
                .collect(Collectors.toList());
    }

    public ReviewDTO getReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Review not found"));
        return reviewMapper.toDto(review);
    }

    public ReviewDTO addReview(ReviewDTO dto) {
        Review review = reviewMapper.toEntity(dto);
        Review saved = reviewRepository.save(review);
        return reviewMapper.toDto(saved);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}


