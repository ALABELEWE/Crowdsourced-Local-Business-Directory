package com.fetchdear.crowd_api.services;

import com.fetchdear.crowd_api.repositories.BusinessRepository;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    BusinessRepository businessRepo;

    public void registerBusiness(Business business){
        businessRepo.save(business);
    }

    public void viewBusinessDetails(String name){
        businessRepo.findByName(name);
    }

    public void updateBusiness(Business business){
        businessRepo.save(business);
    }

    public void deleteBusiness(String name){
        businessRepo.deleteByName(name);
    }

    public void showAllBusinesses(){
        businessRepo.findAll();
    }

}
