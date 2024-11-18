package com.RestApiCrud.subscription.rest;

import com.RestApiCrud.subscription.dao.SubscriptionDAO;
import com.RestApiCrud.subscription.entity.Subscription;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubscriptionRestController {
    private SubscriptionDAO subscriptionDAO;

    // Need to refactor - temp solution: Inject Employee DAO (Use Constructor Injection)
    public SubscriptionRestController(SubscriptionDAO theSubscriptionDAO){
        subscriptionDAO = theSubscriptionDAO;
    }

    @GetMapping("/subscribers")
    public List<Subscription> findAll() {
        return subscriptionDAO.findAll();
    }
}
