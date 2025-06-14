package com.uber.uberReviewService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uber.uberReviewService.models.Booking;
import com.uber.uberReviewService.models.Driver;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Long>{
    // List<Booking> findAllByDriverIn(List<Driver> drivers);
}
