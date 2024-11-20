package com.RestApiCrud.subscription.dao;

import com.RestApiCrud.subscription.SubscriptionApplication;
import com.RestApiCrud.subscription.entity.Subscription;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubscriptionDAOJpaImpl implements SubscriptionDAO{
    // Define field for entitymanager
    private EntityManager entityManager;



    // Set up constructor injection
    @Autowired
    public SubscriptionDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Subscription> findAll() {
        // Create a Query
        TypedQuery<Subscription> theQuery = entityManager.createQuery("from Subscription", Subscription.class);

        // Execute query and get result list
        List<Subscription> subscribers = theQuery.getResultList();

        // Return the results
        return subscribers;
            }

    @Override
    public Subscription findById(int theId) {
        // Get Subscription Details
        Subscription theSubscription = entityManager.find(Subscription.class,theId);

        // Return Subscription Details
        return theSubscription;
    }

    @Override
    public Subscription save(Subscription theSubscription) {
        // Save Subscription
        Subscription dbSubscription = entityManager.merge(theSubscription);

        // Return the Subscription ID from Database
        return dbSubscription;
    }

    @Override
    public void deleteById(int theId) {
        // Find Subscription Details
        Subscription theSubscription = entityManager.find(Subscription.class,theId);

        // Remove Subscription from Database
        entityManager.remove(theSubscription);



    }
}
