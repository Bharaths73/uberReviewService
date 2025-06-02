package com.uber.uberReviewService.DTO;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateReviewDto {

    private String content;

    @DecimalMin(value="1.0", inclusive = true,message = "Rating must be at least 1")
    @DecimalMax(value="5.0", inclusive = true,message = "Rating must be at most 5")
    private Double rating;

    @NotNull(message = "Booking Id cannot be blank")
    private Long bookingId;
}
