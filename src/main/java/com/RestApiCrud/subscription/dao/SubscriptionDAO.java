package com.RestApiCrud.subscription.dao;

import com.RestApiCrud.subscription.entity.Subscription;

import java.util.List;

public interface SubscriptionDAO {

    List<Subscription> findAll();

}
