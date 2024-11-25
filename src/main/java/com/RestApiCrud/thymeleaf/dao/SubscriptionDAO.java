package com.RestApiCrud.thymeleaf.dao;

import com.RestApiCrud.thymeleaf.entity.Subscription;

import java.util.List;

/**
 * DAO (Data Access Object) interface for managing Subscription entities.
 * Provides methods for common CRUD (Create, Read, Update, Delete) operations
 * on the Subscription table in the database.
 */
public interface SubscriptionDAO {

    /**
     * Retrieves all subscriptions from the database.
     *
     * @return a list of all Subscription entities.
     */
    List<Subscription> findAll();

    /**
     * Retrieves a specific subscription by its ID.
     *
     * @param theId the unique ID of the subscription.
     * @return the Subscription entity if found; otherwise, null.
     */
    Subscription findById(int theId);

    /**
     * Saves a new subscription or updates an existing subscription in the database.
     *
     * @param theSubscription the Subscription entity to save or update.
     * @return the saved or updated Subscription entity.
     */
    Subscription save(Subscription theSubscription);

    /**
     * Deletes a subscription from the database by its ID.
     *
     * @param theId the unique ID of the subscription to delete.
     */
    void deleteById(int theId);
}
