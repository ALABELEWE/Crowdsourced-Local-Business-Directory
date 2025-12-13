package com.fetchdear.crowd_api.services;

import com.fetchdear.crowd_api.dto.CustomerRequest;
import com.fetchdear.crowd_api.model.Customer;
import com.fetchdear.crowd_api.dto.response.CustomerResponse;

import java.util.Optional;

public interface CustomerService {

    CustomerResponse registerCustomer(CustomerRequest customer, String keycloakUserId);

    CustomerResponse getCustomerByKeycloakUserId(String keycloakUserId);

    void viewCustomerDetails();

    void updateCustomerDetails(Customer customer);

    void deleteCustomerDetails();
}
