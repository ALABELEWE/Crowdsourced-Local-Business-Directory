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

    private String getKeycloakUserId(Jwt jwt){
        String userId = jwt.getSubject();
        if(userId == null || userId.isEmpty()){
            throw new IllegalArgumentException("Invalid token: user ID not found");
        }
        return userId;
    }

    @PostMapping("/profile")
    public ResponseEntity<ApiResponse<CustomerResponse>> createProfile(
            @Valid @RequestBody CustomerRequest customerRequest,
            @AuthenticationPrincipal Jwt jwt) {

        String keycloakUserId = getKeycloakUserId(jwt); // Get Keycloak user ID from JWT
        CustomerResponse response = customerService.registerCustomer(customerRequest, keycloakUserId);
        ApiResponse<CustomerResponse> apiResponse = new ApiResponse<>(HttpStatus.CREATED, "Customer created successfully", response);
        log.info("");
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("profile")
    public ResponseEntity<ApiResponse<CustomerResponse>> getProfile(@AuthenticationPrincipal Jwt jwt){
        String keycloakUserId = getKeycloakUserId(jwt);
        CustomerResponse response = customerService.getCustomerByKeycloakUserId(keycloakUserId);
        ApiResponse<CustomerResponse> apiResponse = new ApiResponse<>(HttpStatus.OK, "Customer retrieved successfully", response);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
