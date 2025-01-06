package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.service.RewardsService;

@RestController
@RequestMapping("/api/rewards")
public class RewardsController {
	@Autowired
    private RewardsService rewardsService;

	@GetMapping("/home")
	public String welcomeToRewardCalci() {
		return "welcome to reward calculator";
		
	}
    // Endpoint to calculate monthly reward points for a customer
    @GetMapping("/customer/{customerName}/month/{month}")
    public String getMonthlyRewards(@PathVariable String customerName, @PathVariable String month, @RequestBody List<Customer> customers) {
        Customer customer = customers.stream()
                .filter(c -> c.getName().equals(customerName))
                .findFirst()
                .orElseThrow(() -> new CustomerNotFoundException(customerName));
        return "monthly reward for "+customerName+" is: "+rewardsService.calculateMonthlyPoints(customer.getTransactions(), month);
    }

    // Endpoint to calculate total reward points for a customer
    @GetMapping("/customer/{customerName}/total")
    public String getTotalRewards(@PathVariable String customerName, @RequestBody List<Customer> customers) {
        Customer customer = customers.stream()
                .filter(c -> c.getName().equals(customerName))
                .findFirst()
                .orElseThrow(() -> new CustomerNotFoundException(customerName));
        return "The total reward for "+customerName+" is: "+rewardsService.calculateTotalPoints(customer.getTransactions());
    }
}
