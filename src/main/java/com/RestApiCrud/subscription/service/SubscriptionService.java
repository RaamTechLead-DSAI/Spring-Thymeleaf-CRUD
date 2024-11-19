package com.RestApiCrud.subscription.service;

import com.RestApiCrud.subscription.entity.Subscription;

import java.util.List;

public interface SubscriptionService {
    List<Subscription> findAll();
}
