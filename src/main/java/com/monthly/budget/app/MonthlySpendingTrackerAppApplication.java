package com.monthly.budget.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MonthlySpendingTrackerAppApplication {

	public String PORT = System.getenv("PORT");

	public static void main(String[] args) {
		SpringApplication.run(MonthlySpendingTrackerAppApplication.class, args);
	}

}
