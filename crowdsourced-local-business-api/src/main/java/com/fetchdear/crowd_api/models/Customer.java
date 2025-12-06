package com.fetchdear.crowd_api.models;

import com.fetchdear.crowd_api.model.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Customer extends BaseEntity<Long> {

    String lastName;
    String firstName;
    String username;
    String password;
    String email;
    LocalDateTime createdAt;

}
