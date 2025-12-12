package com.fetchdear.crowd_api.services;

import com.fetchdear.crowd_api.model.Business;

public interface BusinessService {

    public void registerBusiness(Business business);

    public void viewBusinessDetails(String name);

    public void updateBusiness(Business business);

    public void deleteBusiness(String name);

    public void showAllBusinesses();
}
