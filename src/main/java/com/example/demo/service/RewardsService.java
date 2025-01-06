package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Transaction;

@Service
public class RewardsService {
	public int calculateRewardPoints(Transaction transaction) {
        double amount = transaction.getAmount();
        int points = 0;

        if (amount > 100) {
            points += (amount - 100) * 2; // 2 points per dollar over $100
            amount = 100;
        }

        if (amount > 50) {
            points += (amount - 50); // 1 point per dollar between $50 and $100
        }

        return points;
    }

    // Method to calculate reward points for a customer per month
    public int calculateMonthlyPoints(List<Transaction> transactions, String month) {
        int totalPoints = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getMonth().equals(month)) {
                totalPoints += calculateRewardPoints(transaction);
            }
        }
        return totalPoints;
    }

    // Method to calculate the total reward points for a customer
    public int calculateTotalPoints(List<Transaction> transactions) {
        int totalPoints = 0;
        for (Transaction transaction : transactions) {
            totalPoints += calculateRewardPoints(transaction);
        }
        return totalPoints;
    }

	
}
