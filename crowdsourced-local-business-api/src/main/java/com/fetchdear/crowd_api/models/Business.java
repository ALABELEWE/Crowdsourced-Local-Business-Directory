package com.fetchdear.crowd_api.models;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int businessId;
    private String name;
    private String address;
    private String description;
    private String media;
    private String category;
    private int customerId;
    private int reviewId;
    private int favouriteId;
    private LocalDateTime createdAt;
    private String createdBy;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String, String> workingHours = new HashMap<>();
}
