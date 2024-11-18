package com.RestApiCrud.subscription.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="subscription")
public class Subscription {
    // Define Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="subscriber_id")
    private int subscriberId;
    @Column(name="status")
    private String status;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="contact_num")
    private String contactNum;
    @Column(name="start_date")
    private Date startDate;

    // Define constructors
    // Define No Argument Constructor required by JPA
    public Subscription(){

    }
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
