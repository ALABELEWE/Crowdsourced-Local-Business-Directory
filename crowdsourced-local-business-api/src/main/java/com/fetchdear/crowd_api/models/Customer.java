package com.fetchdear.crowd_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int customerId;
    String lastName;
    String firstName;
    String username;
    String password;
    String email;
    LocalDateTime createdAt;

}
