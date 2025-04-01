package com.edureka.selenium.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class is part of the Demoblaze automation framework.
 */
public class HomePage {

    WebDriver webDriver;
    WebDriverWait wait;

    private By logo = By.id("nava");  // Brand logo or homepage anchor

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public String getHomePageTitle() {
        return webDriver.getTitle();
    }

    public boolean isLogoDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logo)).isDisplayed();
    }
}
