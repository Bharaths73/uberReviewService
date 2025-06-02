package com.uber.uberReviewService.DTO;

import java.time.LocalDateTime;

import com.uber.uberReviewService.models.BookingStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private BookingStatus bookingStatus;
    
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Long totalDistance;

    // private Driver driver;

    // private Passenger passenger;
}
