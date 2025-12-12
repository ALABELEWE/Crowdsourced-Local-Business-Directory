package com.fetchdear.crowd_api.controller;

import com.fetchdear.crowd_api.dto.ApiResponse;
import com.fetchdear.crowd_api.dto.CustomerRequest;
import com.fetchdear.crowd_api.dto.response.CustomerResponse;
import com.fetchdear.crowd_api.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/profile")
    public ResponseEntity<ApiResponse<CustomerResponse>> createProfile(
            @Valid @RequestBody CustomerRequest customerRequest,
            @AuthenticationPrincipal Jwt jwt) {

        String keycloakUserId = jwt.getSubject(); // Get Keycloak user ID from JWT
        CustomerResponse response = customerService.registerCustomer(customerRequest, keycloakUserId);
        ApiResponse<CustomerResponse> apiResponse = new ApiResponse<>(HttpStatus.CREATED, "Customer created successfully", response);
        log.info("");
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

}
