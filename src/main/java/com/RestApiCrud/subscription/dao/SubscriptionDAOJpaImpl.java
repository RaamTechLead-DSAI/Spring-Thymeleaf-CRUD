package com.RestApiCrud.subscription.dao;

import com.RestApiCrud.subscription.SubscriptionApplication;
import com.RestApiCrud.subscription.entity.Subscription;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO implementation for the Subscription entity using JPA (Java Persistence API).
 * Provides methods to interact with the database to perform CRUD (Create, Read, Update, Delete) operations
 * on Subscription records.
 */
@Repository
public class SubscriptionDAOJpaImpl implements SubscriptionDAO{
    // EntityManager to interact with the JPA context and execute database operations
    private EntityManager entityManager;

    /**
     * Constructor for injecting the EntityManager dependency.
     *
     * @param theEntityManager the EntityManager to be used for database operations.
     */
    @Autowired
    public SubscriptionDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    /**
     * Retrieves all subscriptions from the database.
     *
     * @return a list of Subscription entities.
     */
    @Override
    public List<Subscription> findAll() {
        // Create a query to retrieve all Subscription records
        TypedQuery<Subscription> theQuery = entityManager.createQuery("from Subscription", Subscription.class);

        // Execute the query and get the list of Subscription records
        List<Subscription> subscribers = theQuery.getResultList();

        // Return the list of subscriptions
        return subscribers;
            }

    /**
     * Retrieves a subscription by its unique ID.
     *
     * @param theId the ID of the subscription to retrieve.
     * @return the Subscription entity if found, otherwise null.
     */
    @Override
    public Subscription findById(int theId) {
        // Get Subscription Details
        Subscription theSubscription = entityManager.find(Subscription.class,theId);

        // Return Subscription Details
        return theSubscription;
    }

    /**
     * Saves a new subscription or updates an existing subscription in the database.
     *
     * @param theSubscription the Subscription entity to save or update.
     * @return the saved or updated Subscription entity.
     */
    @Override
    public Subscription save(Subscription theSubscription) {
        // Use merge to either save a new Subscription or update an existing one
        Subscription dbSubscription = entityManager.merge(theSubscription);

        // Return the saved/updated Subscription entity with the database ID
        return dbSubscription;
    }

    /**
     * Deletes a subscription from the database by its ID.
     *
     * @param theId the ID of the subscription to delete.
     */
    @Override
    public void deleteById(int theId) {
        // Find the Subscription entity to delete
        Subscription theSubscription = entityManager.find(Subscription.class,theId);

        // Remove the Subscription from the database
        entityManager.remove(theSubscription);
    }
}
