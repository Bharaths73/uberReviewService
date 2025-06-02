package com.uber.uberReviewService.service;

import java.util.List;
import java.util.Optional;

import com.uber.uberReviewService.DTO.CreateReviewDto;
import com.uber.uberReviewService.DTO.ResponseReviewDto;
import com.uber.uberReviewService.models.Review;

public interface ReviewService {

    public Optional<Review> findReviewById(Long id);

    public List<Review> findAllReviews();

    public boolean deleteReviewById(Long id);

    public ResponseReviewDto publishReview(CreateReviewDto createReviewDto);

    public Review updateReview(Long id, Review review);
}

