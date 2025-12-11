package com.fetchdear.crowd_api.models;

import com.fetchdear.crowd_api.model.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity {

    String lastName;
    String firstName;
    String username;
    String email;

    @Column(unique = true, nullable = false)
    private String keycloakUserId;
}
