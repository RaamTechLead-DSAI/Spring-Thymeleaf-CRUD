package com.RestApiCrud.subscription.rest;

import com.RestApiCrud.subscription.dao.SubscriptionDAO;
import com.RestApiCrud.subscription.entity.Subscription;
import com.RestApiCrud.subscription.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing Subscription entities.
 * Provides endpoints for performing CRUD operations on subscriptions.
 *
 * Endpoints:
 * - GET    /api/subscribers        : Retrieve all subscriptions
 * - GET    /api/subscribers/{id}   : Retrieve a specific subscription by ID
 * - POST   /api/subscribers        : Create a new subscription
 * - PUT    /api/subscribers        : Update an existing subscription
 * - DELETE /api/subscribers/{id}   : Delete a subscription by ID
 *
 * This controller delegates all business logic to the SubscriptionService.
 */

@RestController
@RequestMapping("/api")
public class SubscriptionRestController {

    private SubscriptionService subscriptionService;

    /**
     * Constructor-based dependency injection for SubscriptionService.
     * Constructor injection is preferred for mandatory dependencies, ensuring immutability
     * and better testability.
     *
     * @param theSubscriptionService the service layer for subscription operations
     */
    @Autowired
    public SubscriptionRestController(SubscriptionService theSubscriptionService) {
        subscriptionService = theSubscriptionService;
    }

    /**
     * Retrieves a list of all subscriptions.
     *
     * @return List of Subscription entities
     */
    @GetMapping("/subscribers")
    public List<Subscription> findAll() {
        return subscriptionService.findAll();
    }

    /**
     * Retrieves a specific subscription by its ID.
     * If the subscription is not found, an exception is thrown.
     *
     * @param subscriberId the unique ID of the subscription
     * @return the Subscription entity with the specified ID
     * @throws RuntimeException if the subscription is not found
     */
    @GetMapping("/subscribers/{subscriberId}")
    public Subscription getSubscription(@PathVariable int subscriberId) {
        Subscription theSubscription = subscriptionService.findById(subscriberId);

        if (theSubscription == null) {
            throw new RuntimeException("Subscriber not found: " + subscriberId);
        }

        return theSubscription;
    }

    /**
     * Adds a new subscription.
     * If an ID is provided in the request body, it is ignored to ensure a new subscription is created.
     *
     * @param theSubscription the subscription entity to be added
     * @return the saved Subscription entity
     */
    @PostMapping("/subscribers")
    public Subscription addSubscriber(@RequestBody Subscription theSubscription) {
        // Just in case an ID is passed in JSON, set ID to 0
        // This is to force a save of new item... instead of update

        theSubscription.setSubscriberId(0);
        Subscription dbSubscription = subscriptionService.save(theSubscription);
        return dbSubscription;

    }

    /**
     * Updates an existing subscription.
     * The subscription entity must include a valid ID to be updated.
     *
     * @param theSubscription the subscription entity with updated details
     * @return the updated Subscription entity
     */
    @PutMapping("/subscribers")
    public Subscription updateSubscription(@RequestBody Subscription theSubscription){
        Subscription dbSubscriber = subscriptionService.save(theSubscription);
        return dbSubscriber;
    }

    /**
     * Deletes a subscription by its ID.
     * If the subscription is not found, an exception is thrown.
     *
     * @param subscriberId the unique ID of the subscription to be deleted
     * @return a confirmation message
     * @throws RuntimeException if the subscription ID is not found
     */
    @DeleteMapping("/subscribers/{subscriberId}")
    public String deleteSubscriber(@PathVariable int subscriberId) {
        Subscription tempSubscriber = subscriptionService.findById(subscriberId);
        // Throw exception if null
        if (tempSubscriber == null) {
            throw new RuntimeException("Subscription ID is not found - " + subscriberId);
        }
        subscriptionService.deleteById(subscriberId);
        return "Deleted Subscription Id: " + subscriberId;
    }
}
