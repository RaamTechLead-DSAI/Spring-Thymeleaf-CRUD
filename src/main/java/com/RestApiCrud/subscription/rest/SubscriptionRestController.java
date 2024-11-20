package com.RestApiCrud.subscription.rest;

import com.RestApiCrud.subscription.dao.SubscriptionDAO;
import com.RestApiCrud.subscription.entity.Subscription;
import com.RestApiCrud.subscription.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubscriptionRestController {

    private SubscriptionService subscriptionService;

    // Need to refactor - temp solution: Inject Employee DAO (Use Constructor Injection)
    @Autowired
    public SubscriptionRestController(SubscriptionService theSubscriptionService) {
        subscriptionService = theSubscriptionService;
    }

    @GetMapping("/subscribers")
    public List<Subscription> findAll() {
        return subscriptionService.findAll();
    }

    // Add mapping for GET /subscribers/{subscriberId}
    @GetMapping("/subscribers/{subscriberId}")
    public Subscription getSubscription(@PathVariable int subscriberId) {
        Subscription theSubscription = subscriptionService.findById(subscriberId);

        if (theSubscription == null){
            throw new RuntimeException("Subscriber not found: " + subscriberId);
        }

        return theSubscription;
    }

    // Add mapping for POST /subscriber - add new subscription
    @PostMapping("/subscribers")
    public Subscription addSubscriber(@RequestBody Subscription theSubscription){
        // Just in case an ID is passed in JSON, set ID to 0
        // This is to force a save of new item... instead of update

        theSubscription.setSubscriberId(0);
        Subscription dbSubscription = subscriptionService.save(theSubscription);
        return dbSubscription;

    }

    // Add mapping for PUT /subscribers - update existing subscriber
    @PutMapping("/subscribers")
    public Subscription updateSubscription(@RequestBody Subscription theSubscription){
        Subscription dbSubscriber = subscriptionService.save(theSubscription);
        return dbSubscriber;
    }

}
