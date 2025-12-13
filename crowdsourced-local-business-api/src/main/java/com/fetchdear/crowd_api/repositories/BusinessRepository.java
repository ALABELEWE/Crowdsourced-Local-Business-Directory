package com.fetchdear.crowd_api.repositories;

import com.fetchdear.crowd_api.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {

    public Business findByName(String name);
    public void deleteByName(String name);
}
