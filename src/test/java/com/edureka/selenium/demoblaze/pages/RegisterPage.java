package com.edureka.selenium.demoblaze.pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is part of the Demoblaze automation framework.
 */
public class RegisterPage {

    WebDriver webDriver;
    WebDriverWait wait;

    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "signin2")
    WebElement signUpLink;

    @FindBy(id = "sign-username")
    WebElement signUpUsername;

    @FindBy(id = "sign-password")
    WebElement signUpPassword;

    @FindBy(xpath = "//button[text()='Sign up']")
    WebElement signUpButton;

    /**
 * This method implements test step logic.
 */
public void clickSignUpLink() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpLink)).click();
    }

    /**
 * This method implements test step logic.
 */
public void enterSignupUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(signUpUsername)).sendKeys(username);
    }

    /**
 * This method implements test step logic.
 */
public void enterSignupPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(signUpPassword)).sendKeys(password);
    }

    /**
 * This method implements test step logic.
 */
public void clickSignUpButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
    }

    public String handleAlert() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = webDriver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Signup alert: " + alertText);
            alert.accept();
            return alertText;
        } catch (TimeoutException e) {
            System.out.println("No signup alert appeared.");
            return null;
        }
    }

    /**
 * This method implements test step logic.
 */
public void signUp(String username, String password) {
        clickSignUpLink();
        enterSignupUsername(username);
        enterSignupPassword(password);
        clickSignUpButton();
    }
}
