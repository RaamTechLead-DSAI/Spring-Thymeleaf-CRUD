package com.RestApiCrud.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Spring Boot application.
 * This class is responsible for bootstrapping and launching the Subscription service.
 * The @SpringBootApplication annotation indicates this is a Spring Boot application.
 */
@SpringBootApplication
public class SubscribersMvcThymeleaf {

	/**
	 * The main method to launch the Spring Boot application.
	 *
	 * @param args command-line arguments (unused in this application).
	 */
	public static void main(String[] args) {
		SpringApplication.run(SubscribersMvcThymeleaf.class, args);
	}

}
