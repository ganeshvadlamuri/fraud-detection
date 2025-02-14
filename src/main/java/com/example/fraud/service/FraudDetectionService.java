package com.example.fraud.service;

import com.example.fraud.model.Transaction;
import com.example.fraud.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FraudDetectionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction addTransaction(Transaction transaction) {
        if (transaction.getAmount() > 5000) {
            transaction.setFraudulent(true);
        }

        List<Transaction> recentTransactions = transactionRepository.findByUserId(transaction.getUserId());
        for (Transaction t : recentTransactions) {
            if (t.getTimestamp().isAfter(LocalDateTime.now().minusSeconds(10))) {
                transaction.setFraudulent(true);
            }
        }

        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getUserTransactions(String userId) {
        return transactionRepository.findByUserId(userId);
    }
}