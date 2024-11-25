package com.RestApiCrud.thymeleaf.service;

import com.RestApiCrud.thymeleaf.dao.SubscriptionDAO;
import com.RestApiCrud.thymeleaf.entity.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the SubscriptionService interface.
 * This class handles business logic for managing Subscription entities
 * and delegates data access operations to the SubscriptionDAO layer.
 *
 * It ensures transactional consistency for write operations.
 */
@Service
public class SubscriptionServiceImpl implements SubscriptionService{

    private final SubscriptionDAO subscriptionDAO;

    /**
     * Constructor-based dependency injection for SubscriptionDAO.
     *
     * @param theSubscriptionDAO the DAO layer responsible for accessing subscription data
     */
    @Autowired
    public SubscriptionServiceImpl(SubscriptionDAO theSubscriptionDAO) {
        subscriptionDAO = theSubscriptionDAO;
    }

    /**
     * Retrieves all subscriptions from the data source.
     *
     * @return a list of Subscription entities
     */
    @Override
    public List<Subscription> findAll() {
        return subscriptionDAO.findAllByOrderByLastNameAsc();
    }

    /**
     * Finds a subscription by its unique ID.
     *
     * @param theId the unique ID of the subscription
     * @return the Subscription entity if found, or null otherwise
     */
    @Override
    public Subscription findById(int theId) {

        Optional<Subscription> result = subscriptionDAO.findById(theId);

        if (result.isPresent()) {
            return result.get();  // Return the found subscription
        } else {
            // Subscriber not found
            throw new RuntimeException("Unable to find subscriber ID - " + theId);
        }
    }

    /**
     * Saves a new subscription or updates an existing one.
     * This method is transactional to ensure data consistency.
     *
     * @param theSubscription the Subscription entity to save or update
     * @return the saved Subscription entity
     */
    @Transactional
    @Override
    public Subscription save(Subscription theSubscription) {
        return subscriptionDAO.save(theSubscription);
    }

    /**
     * Deletes a subscription by its unique ID.
     * This method is transactional to ensure data consistency.
     *
     * @param theId the unique ID of the subscription to delete
     */
    @Transactional
    @Override
    public void deleteById(int theId) {
        subscriptionDAO.deleteById(theId);

    }
}
