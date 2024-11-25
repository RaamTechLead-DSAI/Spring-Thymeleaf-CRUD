package com.RestApiCrud.thymeleaf.controller;

import com.RestApiCrud.thymeleaf.entity.Subscription;
import com.RestApiCrud.thymeleaf.service.SubscriptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.concurrent.Flow;

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

        return "subscribers/list-subscribers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        // Create model attribute to bind form data
        Subscription theSubscription = new Subscription();
        theModel.addAttribute("subscription", theSubscription);
        return "subscribers/subscriber-form";
    }

    @PostMapping("/save")
    public String saveSubscriber(@ModelAttribute("subscriber") Subscription theSubscription,
                                 BindingResult result, Model model) {

        // Return form with errors
        if (result.hasErrors()) {
            return "subscribers/subscriber-form";
        }

        // Save the Subscription
        subscriptionService.save(theSubscription);

        // Use a redirect to prevent duplicate submissions
        return "redirect:/subscribers/list";

    }
}
