package com.fetchdear.crowd_api.services;

import com.fetchdear.crowd_api.dto.CustomerRequest;
import com.fetchdear.crowd_api.models.Customer;
import com.fetchdear.crowd_api.dto.response.CustomerResponse;

public interface CustomerService {

    CustomerResponse registerCustomer(CustomerRequest customer, String keycloakUserId);

    Customer getCustomerByKeycloakUserId(String keycloakUserId);

    void viewCustomerDetails();

    void updateCustomerDetails(Customer customer);

    void deleteCustomerDetails();
}
