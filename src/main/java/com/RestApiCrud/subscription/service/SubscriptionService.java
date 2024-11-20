package com.RestApiCrud.subscription.service;

import com.RestApiCrud.subscription.entity.Subscription;

import java.util.List;

public interface SubscriptionService {
    List<Subscription> findAll();

    Subscription findById(int theId);
    Subscription save(Subscription theSubscription);
    void deleteById(int theId);
}
