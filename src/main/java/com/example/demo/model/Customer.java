package com.example.demo.model;

import java.util.List;

public class Customer {
	private String name;
    private List<Transaction> transactions;

    // Constructors, Getters, Setters
    public Customer(String name, List<Transaction> transactions) {
        this.name = name;
        this.transactions = transactions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
