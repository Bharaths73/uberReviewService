package com.uber.uberReviewService.Exception.CustomExceptions;

public class ReviewAlreadyExists extends RuntimeException {

    public ReviewAlreadyExists(String message) {
        super(message);
    }
    
}
