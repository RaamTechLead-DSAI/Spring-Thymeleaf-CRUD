package com.RestApiCrud.thymeleaf.controller;

import com.RestApiCrud.thymeleaf.entity.Subscription;
import com.RestApiCrud.thymeleaf.service.SubscriptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing Subscription entities.
 * Handles HTTP requests and responses related to subscriber operations,
 * including listing, adding, updating, and deleting subscriptions.
 *
 * This class follows the MVC (Model-View-Controller) pattern, where:
 * - Model: Represents the data (Subscription entities).
 * - View: Represents the UI templates (Thymeleaf templates).
 * - Controller: Manages incoming requests and prepares data for the view.
 */
@Controller
@RequestMapping("/subscribers")
public class SubscriptionController {

    // Dependency injection of SubscriptionService to handle business logic.
    private final SubscriptionService subscriptionService;

    /**
     * Constructor injection for the SubscriptionService.
     *
     * @param theSubscriptionService The service layer responsible for subscription-related operations.
     */
    public SubscriptionController(SubscriptionService theSubscriptionService) {
        subscriptionService = theSubscriptionService;
    }

    /**
     * Handles the "/list" endpoint to display all subscribers.
     *
     * @param theModel The model to pass data to the view.
     * @return The Thymeleaf template name for displaying the subscriber list.
     */
    @GetMapping("/list")
    public String listSubscription(Model theModel) {
        // Retrieve all subscribers from the database.
        List<Subscription> theSubscribers = subscriptionService.findAll();

        // Add the subscriber list to the model to be displayed in the view.
        theModel.addAttribute("subscribers", theSubscribers);

        return "subscribers/list-subscribers";
    }

    /**
     * Displays the form for adding a new subscriber.
     *
     * @param theModel The model to bind form data.
     * @return The Thymeleaf template for the subscription form.
     */
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        // Create a new Subscription object to bind form data.
        Subscription theSubscription = new Subscription();
        theModel.addAttribute("subscription", theSubscription);
        return "subscribers/subscriber-form";
    }

    /**
     * Displays the form for updating an existing subscriber.
     *
     * @param theId The ID of the subscriber to be updated.
     * @param theModel The model to pre-populate the form with existing data.
     * @return The Thymeleaf template for the subscription form.
     */
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("subscriberId") int theId, Model theModel) {
        // Retrieve the existing subscriber based on the provided ID.
        Subscription theSubscription = subscriptionService.findById(theId);

        // Add the subscriber to the model to pre-populate the form.
        theModel.addAttribute("subscription", theSubscription);

        return "subscribers/subscriber-form";
    }

    /**
     * Saves a new or updated subscriber to the database.
     *
     * @param theSubscription The subscription entity populated from the form data.
     * @param result BindingResult to handle validation errors.
     * @param model Model to handle data binding.
     * @return Redirects to the subscriber list page after saving.
     */
    @PostMapping("/save")
    public String saveSubscriber(@ModelAttribute("subscriber") Subscription theSubscription,
                                 BindingResult result, Model model) {

        // Check for validation errors and return the form with errors if any.
        if (result.hasErrors()) {
            return "subscribers/subscriber-form";
        }

        // Save the subscription entity using the service layer.
        subscriptionService.save(theSubscription);

        // Redirect to the list of subscribers to avoid duplicate form submissions.
        return "redirect:/subscribers/list";
    }

    /**
     * Deletes an existing subscriber based on the provided ID.
     *
     * @param theId The ID of the subscriber to be deleted.
     * @return Redirects to the subscriber list page after deletion.
     */
    @GetMapping("/delete")
    public String delete(@RequestParam("subscriberId") int theId) {
        // Delete the subscriber from the database using the service layer.
        subscriptionService.deleteById(theId);

        // Redirect to the list of subscribers.
        return "redirect:/subscribers/list";
    }
}
