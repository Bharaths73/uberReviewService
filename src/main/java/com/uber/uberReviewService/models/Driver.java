package com.uber.uberReviewService.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends BaseModel {

    private String driverName;

    @Column(unique = true,nullable = false)
    private String licenseNumber;

    @OneToMany(mappedBy = "driver")
    private List<Booking> bookings;

}
