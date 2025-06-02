package com.uber.uberReviewService.Exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.uber.uberReviewService.Exception.CustomExceptions.BookingNotFoundException;
import com.uber.uberReviewService.Exception.CustomExceptions.ReviewAlreadyExists;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse<Map<String, String>>> methodArgumentNotFound(MethodArgumentNotValidException ex){
        Map<String,String> errors=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        ErrorResponse<Map<String, String>> errorResponse = ErrorResponse.<Map<String, String>>builder()
                .message(errors)
                .status(false)
                .code(400)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<ErrorResponse<String>> bookingNotFoundException(BookingNotFoundException ex) {
        ErrorResponse<String> errorResponse = ErrorResponse.<String>builder()
                .message(ex.getMessage())
                .status(false)
                .code(500)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(500).body(errorResponse);
    }

    @ExceptionHandler(ReviewAlreadyExists.class)
    public ResponseEntity<ErrorResponse<String>> reviewExistsException(ReviewAlreadyExists ex){
        ErrorResponse<String> errorResponse=ErrorResponse.<String>builder().message(ex.getMessage()).status(false).code(HttpStatus.BAD_REQUEST.value()).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
