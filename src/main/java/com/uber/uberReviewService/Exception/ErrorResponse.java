package com.uber.uberReviewService.Exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse<T> {
    private T message;
    private Boolean status;
    private int code;
    private LocalDateTime timestamp;
}
