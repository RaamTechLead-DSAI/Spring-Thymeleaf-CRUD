package com.RestApiCrud.thymeleaf.dao;

import com.RestApiCrud.thymeleaf.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * DAO (Data Access Object) interface for managing Subscription entities.
 * Provides methods for common CRUD (Create, Read, Update, Delete) operations
 * on the Subscription table in the database.
 */



public interface SubscriptionDAO extends JpaRepository<Subscription, Integer> {

    // JPA handles everything in the background and no JPA implementation required

    // Add a method to sort by Last Name
    public  List<Subscription> findAllByOrderByLastNameAsc();

}
