package com.fetchdear.crowd_api.model;

import com.fetchdear.crowd_api.model.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity<Long> {

    String lastName;
    String firstName;
    String username;
    String email;

    @Column(unique = true, nullable = false)
    private String keycloakUserId;
}
