package com.fetchdear.crowd_api.repositories;

import com.fetchdear.crowd_api.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByKeycloakUserId(String keycloakUserId);
    Optional<Customer> findByEmail(String email);
    boolean existsByKeycloakUserId(String keycloakUserId);
}
