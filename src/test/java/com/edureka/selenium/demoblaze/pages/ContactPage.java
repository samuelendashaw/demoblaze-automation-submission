package com.edureka.selenium.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class is part of the Demoblaze automation framework.
 */
public class ContactPage {
    WebDriver webDriver;
    WebDriverWait wait;

    public ContactPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    private By contactLink = By.xpath("//a[text()='Contact']");
    private By contactEmail = By.id("recipient-email");
    private By contactName = By.id("recipient-name");
    private By messageBox = By.id("message-text");
    private By sendMessageButton = By.xpath("//button[text()='Send message']");

    /**
 * This method implements test step logic.
 */
public void clickContactLink() {
        wait.until(ExpectedConditions.elementToBeClickable(contactLink)).click();
    }

    /**
 * This method implements test step logic.
 */
public void fillContactForm(String email, String name, String message) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactEmail)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactName)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageBox)).sendKeys(message);
    }

    /**
 * This method implements test step logic.
 */
public void clickSendMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(sendMessageButton)).click();
    }

    /**
 * This method implements test step logic.
 */
public void handleAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = webDriver.switchTo().alert().getText();
        System.out.println("Contact form alert: " + alertText);
        webDriver.switchTo().alert().accept();
    }
}
