package com.uber.uberReviewService.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Data;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Data
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "created_at",nullable = false,updatable = false)
    // @Temporal(TemporalType.TIMESTAMP)//tells format
    @CreatedDate//tells to set the date when the entity is created
    protected LocalDateTime createdAt;

    @Column(name = "updated_at",nullable = false)
    // @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate//tells to set the date when the entity is updated
    protected LocalDateTime updatedAt;

    // @Version
    // protected Long version;
}
