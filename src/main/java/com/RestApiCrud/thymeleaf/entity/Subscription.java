package com.RestApiCrud.thymeleaf.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Entity class representing the subscription details.
 * This class maps to the "subscription" table in the database
 * and defines its fields, constructors, and accessors.
 */
@Entity
@Table(name="subscription")
public class Subscription {
    // Define Fields
    /**
     * Primary key for the subscription table.
     * Auto-generated using the IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="subscriber_id")
    private int subscriberId;
    /**
     * Subscription status (e.g., ACTIVE, INACTIVE).
     */
    @Column(name="status")
    private String status;
    /**
     * First name of the subscriber.
     */
    @Column(name="first_name")
    private String firstName;
    /**
     * Last name of the subscriber.
     */
    @Column(name="last_name")
    private String lastName;
    /**
     * Email address of the subscriber.
     */
    @Column(name="email")
    private String email;
    /**
     * Contact number of the subscriber.
     */
    @Column(name="contact_num")
    private String contactNum;
    /**
     * The start date of the subscription.
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="start_date")
    private Date startDate;

    // Define constructors
    /**
     * Default no-argument constructor required by JPA.
     */
    public Subscription(){

    }

    /**
     * Constructor to initialize the Subscription object with all fields except the subscriber ID.
     *
     * @param status      the subscription status
     * @param firstName   the subscriber's first name
     * @param lastName    the subscriber's last name
     * @param email       the subscriber's email
     * @param contactNum  the subscriber's contact number
     * @param startDate   the subscription start date
     */
    public Subscription(String status, String firstName, String lastName, String email, String contactNum, Date startDate) {
        this.status = status;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNum = contactNum;
        this.startDate = startDate;
    }

    // Define Getter and Setter
    public int getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(int subscriberId) {
        this.subscriberId = subscriberId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    // Define toString
    /**
     * Provides a string representation of the Subscription object,
     * including all its fields.
     *
     * @return a string representation of the Subscription
     */
    @Override
    public String toString() {
        return "Subscription{" +
                "subscriberId=" + subscriberId +
                ", status='" + status + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", contactNum='" + contactNum + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
