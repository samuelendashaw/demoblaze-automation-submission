package com.edureka.selenium.demoblaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class is part of the Demoblaze automation framework.
 */
public class LoginPage {
    WebDriver webDriver;
    WebDriverWait wait;

    private By loginTab = By.id("login2");
    private By usernameField = By.id("loginusername");
    private By passwordField = By.id("loginpassword");
    private By loginButton = By.xpath("//button[text()='Log in']");
    private By welcomeMessage = By.id("nameofuser");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    /**
 * This method implements test step logic.
 */
public void clickLoginTab() {
        webDriver.findElement(loginTab).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
    }

    /**
 * This method implements test step logic.
 */
public void enterUsername(String username) {
        webDriver.findElement(usernameField).clear();
        webDriver.findElement(usernameField).sendKeys(username);
    }

    /**
 * This method implements test step logic.
 */
public void enterPassword(String password) {
        webDriver.findElement(passwordField).clear();
        webDriver.findElement(passwordField).sendKeys(password);
    }

    /**
 * This method implements test step logic.
 */
public void clickLoginButton() {
        webDriver.findElement(loginButton).click();
    }

    public boolean isLoginSuccessful(String expectedMessage) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage));
            return webDriver.findElement(welcomeMessage).getText().equalsIgnoreCase(expectedMessage);
        } catch (Exception e) {
            return false;
        }
    }

    public String getLoggedInUsernameText() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage));
            return webDriver.findElement(welcomeMessage).getText();
        } catch (Exception e) {
            return null;
        }
    }

    public String getLoginErrorAlertMessage() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = webDriver.switchTo().alert();
            String message = alert.getText();
            alert.accept();
            return message;
        } catch (Exception e) {
            return null;
        }
    }

    // Optional: One method to complete login in one call
    /**
 * This method implements test step logic.
 */
public void login(String username, String password) {
        clickLoginTab();
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
    
    /**
 * This method implements test step logic.
 */
public void waitForLoginSuccess(String expectedMessage) {
        try {
            wait.until(ExpectedConditions.textToBe(welcomeMessage, expectedMessage));
        } catch (Exception e) {
            throw new AssertionError("Login did not succeed or welcome message did not appear.");
        }
    }

}
