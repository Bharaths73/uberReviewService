package com.uber.uberReviewService.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uber.uberReviewService.DTO.CreateReviewDto;
import com.uber.uberReviewService.DTO.ResponseReviewDto;
import com.uber.uberReviewService.Exception.CustomExceptions.BookingNotFoundException;
import com.uber.uberReviewService.Exception.CustomExceptions.ReviewAlreadyExists;
import com.uber.uberReviewService.Repository.BookingRepo;
import com.uber.uberReviewService.Repository.ReviewRepo;
import com.uber.uberReviewService.models.Booking;
import com.uber.uberReviewService.models.BookingStatus;
import com.uber.uberReviewService.models.Driver;
import com.uber.uberReviewService.models.Passenger;
import com.uber.uberReviewService.models.Review;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReviewServiceImpl implements ReviewService,CommandLineRunner{

    private ModelMapper modelMapper;
    private ReviewRepo reviewRepo;
    private BookingRepo bookingRepo;
    // private static final Logger logger=LoggerFactory.getLogger(ReviewServiceImpl.class);

    public ReviewServiceImpl(ModelMapper modelMapper,ReviewRepo reviewRepo,BookingRepo bookingRepo) {
        this.modelMapper = modelMapper;
        this.reviewRepo = reviewRepo;
        this.bookingRepo=bookingRepo;
    }

    @Override
    @Transactional
    public Optional<Review> findReviewById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findReviewById'");
    }

    @Override
    public List<Review> findAllReviews() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllReviews'");
    }

    @Override
    public boolean deleteReviewById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteReviewById'");
    }

    @Override
    @Transactional
    public ResponseReviewDto publishReview(CreateReviewDto createReviewDto) throws BookingNotFoundException {
        Long bookingId=createReviewDto.getBookingId();

        Booking booking=bookingRepo.findById(bookingId).orElseThrow(()->new BookingNotFoundException("Booking not found with id: " + bookingId));

        if(booking.getReview() != null) {
            log.error("Review already exists for booking with id: {}", bookingId);
            throw new ReviewAlreadyExists("Review already exists for booking with id: " + bookingId);
        }

        log.info("Booking found with id: {}", bookingId);

        Review review=Review.builder().content(createReviewDto.getContent()).booking(booking).rating(createReviewDto.getRating()).build();

        booking.setReview(review);
        Booking savedReview=bookingRepo.save(booking);
        log.info("Review published successfully for booking id: {}", bookingId);
        return modelMapper.map(savedReview.getReview(), ResponseReviewDto.class);
    }

    @Override
    public Review updateReview(Long id, Review review) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateReview'");
    }

    @Override
    public void run(String... args) throws Exception {
        // Driver driver = Driver.builder()
        //         .driverName("John Doe")
        //         .licenseNumber("DL123456789")
        //         .build();
        // Passenger passenger = Passenger.builder()
        //         .passengerName("Jane Smith")
        //         .build();
        // Booking booking = Booking.builder()
        //         .bookingStatus(BookingStatus.COMPLETED)
        //         .startTime(LocalDateTime.now().minusHours(1))
        //         .endTime(LocalDateTime.now())
        //         .driver(driver)
        //         .passenger(passenger)
        //         .totalDistance(1000L)
        //         .build();
        // bookingRepo.save(booking);
    }
    
}
