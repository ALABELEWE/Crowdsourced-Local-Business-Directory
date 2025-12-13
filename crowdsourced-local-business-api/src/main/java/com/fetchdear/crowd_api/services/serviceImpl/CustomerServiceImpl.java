package com.fetchdear.crowd_api.services.serviceImpl;

import com.fetchdear.crowd_api.dto.CustomerRequest;
import com.fetchdear.crowd_api.model.Customer;
import com.fetchdear.crowd_api.repositories.CustomerRepository;
import com.fetchdear.crowd_api.services.CustomerService;
import com.fetchdear.crowd_api.dto.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepo;

    @Override
    public CustomerResponse registerCustomer(CustomerRequest customer, String keycloakUserId) {
        // Check for customer profile first
        if(customerRepo.existsByKeycloakUserId(keycloakUserId)){
            throw new RuntimeException("Customer with provided credentials already exists!");
        }

        // Otherwise build new customer
        Customer newCustomer = Customer.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .username(customer.getUsername())
                .email(customer.getEmail())
                .keycloakUserId(keycloakUserId)
                .build();

        newCustomer = customerRepo.save(newCustomer);
        return CustomerResponse.from(newCustomer);
    }

    @Override
    public CustomerResponse getCustomerByKeycloakUserId(String keycloakUserId) {
        // Check for user existence first
        if(!customerRepo.existsByKeycloakUserId(keycloakUserId)){
            throw new RuntimeException("Invalid customer!");
        }
        // Then get user details
        Customer customer = customerRepo.findByKeycloakUserId(keycloakUserId);
        return CustomerResponse.from(customer);
    }

    @Override
    public void viewCustomerDetails(){
    }

    @Override
    public void updateCustomerDetails(Customer customer){
        customerRepo.save(customer);
    }

    @Override
    public void deleteCustomerDetails(){
    }

}
