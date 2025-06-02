package com.uber.uberReviewService.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uber.uberReviewService.DTO.CreateReviewDto;
import com.uber.uberReviewService.DTO.ResponseReviewDto;
import com.uber.uberReviewService.Exception.CustomExceptions.BookingNotFoundException;
import com.uber.uberReviewService.Response.ApiResponse;
import com.uber.uberReviewService.service.ReviewService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {
    
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/publish")
    public ResponseEntity<ApiResponse<?>> postReview(@RequestBody @Valid CreateReviewDto createReviewDto) throws BookingNotFoundException {
        ApiResponse<ResponseReviewDto> response =ApiResponse.<ResponseReviewDto>builder().status(true).data(reviewService.publishReview(createReviewDto))
                .code(HttpStatus.CREATED.value())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.ok().body(response);
    }
}
