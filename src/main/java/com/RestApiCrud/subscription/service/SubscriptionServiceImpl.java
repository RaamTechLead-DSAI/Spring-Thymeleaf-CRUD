package com.RestApiCrud.subscription.service;

import com.RestApiCrud.subscription.dao.SubscriptionDAO;
import com.RestApiCrud.subscription.entity.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{

    private SubscriptionDAO subscriptionDAO;

    @Autowired
    public SubscriptionServiceImpl(SubscriptionDAO theSubscriptionDAO) {
        subscriptionDAO = theSubscriptionDAO;
    }

    @Override
    public List<Subscription> findAll() {
        return subscriptionDAO.findAll();
    }
}
