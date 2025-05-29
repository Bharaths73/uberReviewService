package com.uber.uberReviewService.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Passenger extends BaseModel {
    private String passengerName;

    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings;
}
