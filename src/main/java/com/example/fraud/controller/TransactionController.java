package com.example.fraud.controller;

import com.example.fraud.model.Transaction;
import com.example.fraud.service.FraudDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private FraudDetectionService fraudDetectionService;

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return fraudDetectionService.addTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return fraudDetectionService.getAllTransactions();
    }

    @GetMapping("/{userId}")
    public List<Transaction> getUserTransactions(@PathVariable String userId) {
        return fraudDetectionService.getUserTransactions(userId);
    }
}