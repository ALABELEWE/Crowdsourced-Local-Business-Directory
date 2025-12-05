package com.fetchdear.crowd_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Review {

    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    int reviewId;
    String title;
    int user_id;
    int business_id;
    String content;
    int ratings;
    LocalDateTime createdAt;
    String createdBy;


}
