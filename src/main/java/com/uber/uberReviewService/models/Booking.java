package com.uber.uberReviewService.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseModel{

    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;
    
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Long totalDistance;

    @OneToOne(mappedBy = "booking",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Review review;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Driver driver;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Passenger passenger;
}
