package com.uber.uberReviewService.Repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uber.uberReviewService.models.Review;


@Repository
public interface ReviewRepo extends JpaRepository<Review,Long>{
    
}

