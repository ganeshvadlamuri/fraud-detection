package com.example.fraud.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private double amount;
    private String location;
    private LocalDateTime timestamp;
    private boolean fraudulent;

    // ✅ Manually add missing getter methods (if Lombok doesn't work)
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isFraudulent() {
        return fraudulent;
    }

    public void setFraudulent(boolean fraudulent) {
        this.fraudulent = fraudulent;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}