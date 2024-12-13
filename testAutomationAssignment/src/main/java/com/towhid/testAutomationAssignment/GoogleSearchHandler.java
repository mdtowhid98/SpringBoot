package com.towhid.testAutomationAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class GoogleSearchHandler {
    private WebDriver driver;

    public GoogleSearchHandler() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Set path to your chromedriver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void closeDriver() {
        driver.quit();
    }

    // Method to search for a keyword and return longest and shortest options
    public String[] searchKeyword(String keyword) {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(keyword);

        // Wait for suggestions to load
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@role='listbox']//li//span"));
        String longest = "", shortest = suggestions.get(0).getText();

        for (WebElement suggestion : suggestions) {
            String suggestionText = suggestion.getText();
            if (suggestionText.length() > longest.length()) {
                longest = suggestionText;
            }
            if (suggestionText.length() < shortest.length()) {
                shortest = suggestionText;
            }
        }

        return new String[] { longest, shortest };
    }
}
