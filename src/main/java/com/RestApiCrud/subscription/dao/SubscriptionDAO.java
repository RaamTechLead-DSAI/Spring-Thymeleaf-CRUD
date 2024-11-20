package com.RestApiCrud.subscription.dao;

import com.RestApiCrud.subscription.entity.Subscription;

import java.util.List;

public interface SubscriptionDAO {

    List<Subscription> findAll();
    Subscription findById(int theId);
    Subscription save(Subscription theSubscription);
    void deleteById(int theId);


}
