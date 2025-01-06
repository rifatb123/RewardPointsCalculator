package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Transaction;
import com.example.demo.service.RewardsService;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
	private final RewardsService rewardsService = new RewardsService();

    @Test
    public void testCalculateRewardPoints() {
        Transaction transaction = new Transaction(120, "January");
        int points = rewardsService.calculateRewardPoints(transaction);
        assertEquals(90, points);
    }

    @Test
    public void testCalculateMonthlyPoints() {
        // transactions and test of monthly calculation
    	List<Transaction> transactions=Arrays.asList(
    			new Transaction(120, "January"),
    	        new Transaction(75, "January"),
    	        new Transaction(50, "January"),
    	        new Transaction(200, "February"),
    	        new Transaction(30, "February")) ;//90+25=115
    	int monthlyRewardPoint=rewardsService.calculateMonthlyPoints(transactions, "January");
    	assertEquals(115, monthlyRewardPoint);
    }

    @Test
    public void testCalculateTotalPoints() {
        // transactions and test of total points calculation
    	List<Transaction> transactions = Arrays.asList(
    	        new Transaction(120, "January"),
    	        new Transaction(75, "January"),
    	        new Transaction(50, "January"),
    	        new Transaction(200, "February"),
    	        new Transaction(30, "February")
    	    );

    	    int totalPoints = rewardsService.calculateTotalPoints(transactions);
    	    // Points for January = 90 + 25 + 0 = 115
    	    // Points for February = 2 * (200-100) + 1 * (100-50) + 1 * (30-50) = 200 + 50 + 0 = 250
    	    // Total = 115 + 250 = 365
    	    assertEquals(365, totalPoints);
    }
}
