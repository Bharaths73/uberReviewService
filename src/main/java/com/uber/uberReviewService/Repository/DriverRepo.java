package com.uber.uberReviewService.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uber.uberReviewService.models.Driver;

@Repository
public interface DriverRepo extends JpaRepository<Driver,Long>{
    // List<Driver> findAllByIdIn(Long id);
}
