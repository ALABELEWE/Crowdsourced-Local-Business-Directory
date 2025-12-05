package com.fetchdear.crowd_api.services;

import com.fetchdear.crowd_api.models.Customer;
import com.fetchdear.crowd_api.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    CustomerRepository customerRepo;

    public void registerCustomer(Customer customer){
        customerRepo.save(customer);
    }

    public void viewCustomerDetails(){
    }

    public void updateCustomerDetails(Customer customer){
        customerRepo.save(customer);
    }

    public void deleteCustomerDetails(){

    }
}
