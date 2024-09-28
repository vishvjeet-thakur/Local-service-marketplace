package com.marketplace.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long serviceRequestId;
    private Long providerId;
    private Double amount;
    private String status; // "PENDING", "ACCEPTED", "REJECTED"

    // getters and setters
}
