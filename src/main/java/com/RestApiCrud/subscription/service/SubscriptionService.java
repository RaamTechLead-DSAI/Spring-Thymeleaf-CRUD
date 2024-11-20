package com.RestApiCrud.subscription.service;

import com.RestApiCrud.subscription.entity.Subscription;

import java.util.List;

/**
 * Service interface for managing Subscription entities.
 * This interface defines the contract for the business logic layer,
 * which will be implemented by the service classes.
 *
 * Responsibilities:
 * - Fetching all subscriptions
 * - Fetching a subscription by its ID
 * - Saving or updating a subscription
 * - Deleting a subscription by its ID
 */
public interface SubscriptionService {
    /**
     * Retrieves all subscription records from the database.
     *
     * @return a list of all Subscription entities
     */
    List<Subscription> findAll();

    /**
     * Finds a specific subscription by its unique ID.
     *
     * @param theId the ID of the subscription to retrieve
     * @return the Subscription entity with the given ID, or null if not found
     */
    Subscription findById(int theId);

    /**
     * Saves a new subscription or updates an existing one.
     *
     * @param theSubscription the Subscription entity to be saved or updated
     * @return the saved or updated Subscription entity
     */
    Subscription save(Subscription theSubscription);

    /**
     * Deletes a subscription by its unique ID.
     *
     * @param theId the ID of the subscription to be deleted
     */
    void deleteById(int theId);
}
