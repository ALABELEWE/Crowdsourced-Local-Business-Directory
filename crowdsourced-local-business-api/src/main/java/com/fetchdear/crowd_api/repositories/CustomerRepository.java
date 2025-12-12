package com.fetchdear.crowd_api.repositories;

import com.fetchdear.crowd_api.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByKeycloakUserId(String keycloakUserId);
    Optional<Customer> findByEmail(String email);
    boolean existsByKeycloakUserId(String keycloakUserId);
}
