package com.RestApiCrud.thymeleaf.controller;

import com.RestApiCrud.thymeleaf.entity.Subscription;
import com.RestApiCrud.thymeleaf.service.SubscriptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/subscribers")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService theSubscriptionService) {
        subscriptionService = theSubscriptionService;
    }

    // Add mapping for "/List"
    @GetMapping("/list")
    public String listSubscription(Model theModel) {

        // Get the subscribers from DB
        List<Subscription> theSubscribers = subscriptionService.findAll();

        // Add to the spring model
        theModel.addAttribute("subscribers", theSubscribers);

        return "list-subscribers";

    }
}
