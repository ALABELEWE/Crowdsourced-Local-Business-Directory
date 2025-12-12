package com.fetchdear.crowd_api.services.serviceImpl;

import com.fetchdear.crowd_api.models.Business;
import com.fetchdear.crowd_api.repositories.BusinessRepository;
import com.fetchdear.crowd_api.services.BusinessService;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService {

    BusinessRepository businessRepo;

    @Override
    public void registerBusiness(Business business){
        businessRepo.save(business);
    }

    @Override
    public void viewBusinessDetails(String name){
        businessRepo.findByName(name);
    }

    @Override
    public void updateBusiness(Business business){
        businessRepo.save(business);
    }

    @Override
    public void deleteBusiness(String name){
        businessRepo.deleteByName(name);
    }

    @Override
    public void showAllBusinesses(){
        businessRepo.findAll();
    }

}
