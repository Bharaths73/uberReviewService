package com.uber.uberReviewService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uber.uberReviewService.models.Booking;

public interface BookingRepo extends JpaRepository<Booking,Long>{
    
}
