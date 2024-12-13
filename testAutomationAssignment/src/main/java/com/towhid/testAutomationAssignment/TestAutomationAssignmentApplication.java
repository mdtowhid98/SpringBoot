package com.towhid.testAutomationAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestAutomationAssignmentApplication {

	public static void main(String[] args) {

		SpringApplication.run(TestAutomationAssignmentApplication.class, args);

		try {
			// Step 1: Get keywords for today's date from Excel
			String[] keywords = ExcelHandler.getDataForToday();

			// Step 2: Set up Selenium
			GoogleSearchHandler googleSearchHandler = new GoogleSearchHandler();

			// Step 3: For each keyword, search Google and record longest and shortest suggestions
			for (String keyword : keywords) {
				System.out.println("Searching for: " + keyword);
				String[] results = googleSearchHandler.searchKeyword(keyword);
				String longest = results[0];
				String shortest = results[1];
				System.out.println("Longest: " + longest + " | Shortest: " + shortest);

				// Step 4: Write results back to Excel
				ExcelHandler.writeResults(keyword, longest, shortest);
			}

			googleSearchHandler.closeDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
