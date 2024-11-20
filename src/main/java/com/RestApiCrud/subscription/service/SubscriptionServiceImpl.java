package com.RestApiCrud.subscription.service;

import com.RestApiCrud.subscription.dao.SubscriptionDAO;
import com.RestApiCrud.subscription.entity.Subscription;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public Subscription findById(int theId) {
        return subscriptionDAO.findById(theId);
    }

    @Transactional
    @Override
    public Subscription save(Subscription theSubscription) {
        return subscriptionDAO.save(theSubscription);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        subscriptionDAO.deleteById(theId);

    }
}
