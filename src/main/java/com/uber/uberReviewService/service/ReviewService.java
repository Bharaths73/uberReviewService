package com.uber.uberReviewService.service;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.uber.uberReviewService.Repository.BookingRepo;
import com.uber.uberReviewService.Repository.ReviewRepo;
import com.uber.uberReviewService.models.Review;

@Service
public class ReviewService implements CommandLineRunner {

    private ReviewRepo reviewRepo;
    private BookingRepo bookingRepo;

    public ReviewService(ReviewRepo reviewRepo,BookingRepo bookingRepo) {
        this.reviewRepo = reviewRepo;
        this.bookingRepo = bookingRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("ReviewService is running...");
        Review r=Review.builder().content("Great service!").rating(3.5).build();
        reviewRepo.save(r);
        r=Review.builder().content("Good service!").rating(4.5).build();
        reviewRepo.save(r);
        List<Review> reviews=reviewRepo.findAll();
        reviews.forEach(review->System.out.println("Review ID: " + review.getId() + ", Content: " + review.getContent() + ", Rating: " + review.getRating()));
    }
    
}
