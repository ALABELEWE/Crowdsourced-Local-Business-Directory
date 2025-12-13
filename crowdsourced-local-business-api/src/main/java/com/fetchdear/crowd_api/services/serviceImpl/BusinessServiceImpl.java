package com.fetchdear.crowd_api.services.serviceImpl;

import com.fetchdear.crowd_api.model.Business;
import com.fetchdear.crowd_api.repositories.BusinessRepository;
import com.fetchdear.crowd_api.services.BusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BusinessServiceImpl implements BusinessService {

    private final BusinessRepository businessRepo;
    private final String MY_CACHE_NAME = "businesses";

    @Override
    @CachePut(value = MY_CACHE_NAME, key = "#result.id")
    public void registerBusiness(Business business){
        businessRepo.save(business);
    }

    @Override
    @Cacheable(value = MY_CACHE_NAME, key = "#id")
    public void viewBusinessDetails(String name){
        businessRepo.findByName(name);
    }

    @Override
    @CachePut(value = MY_CACHE_NAME, key = "#result.id")
    public void updateBusiness(Business business){
        businessRepo.save(business);
    }

    @Override
    @CacheEvict(value = MY_CACHE_NAME, key = "#id")
    public void deleteBusiness(String name){
        businessRepo.deleteByName(name);
    }

    @Override
    @Cacheable(value = "MY_CACHE_NAME", key = "#id")
    public void showAllBusinesses(){
        businessRepo.findAll();
    }

}
