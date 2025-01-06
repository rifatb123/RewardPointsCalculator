package com.example.demo.model;

public class Transaction {
	  private double amount;
	    private String month;

	    public Transaction(double amount, String month) {
	        this.amount = amount;
	        this.month = month;
	    }

	    public double getAmount() {
	        return amount;
	    }

	    public void setAmount(double amount) {
	        this.amount = amount;
	    }

	    public String getMonth() {
	        return month;
	    }

	    public void setMonth(String month) {
	        this.month = month;
	    }
}
