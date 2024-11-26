package com.RestApiCrud.thymeleaf.dao;

import com.RestApiCrud.thymeleaf.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * DAO (Data Access Object) interface for managing Subscription entities.
 * Provides methods for common CRUD (Create, Read, Update, Delete) operations
 * on the Subscription table in the database.
 *
 * Extends the JpaRepository interface to leverage Spring Data JPA's built-in functionalities,
 * reducing the need for boilerplate code and simplifying database interactions.
 */
public interface SubscriptionDAO extends JpaRepository<Subscription, Integer> {

    // JPA handles CRUD implementations implicitly; no custom implementation is required here.
    // Method names follow Spring Data JPA conventions for query generation.

    /**
     * Retrieves all Subscription entities from the database, sorted in ascending order by the last name.
     *
     * @return A list of Subscription entities sorted by last name in ascending order.
     */
    List<Subscription> findAllByOrderByLastNameAsc();
}
