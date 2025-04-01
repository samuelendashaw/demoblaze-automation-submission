package com.edureka.selenium.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class is part of the Demoblaze automation framework.
 */
public class AboutUsPage {
    WebDriver webDriver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[text()='About us']")
    WebElement aboutUsLink;

    @FindBy(id = "videoModal")
    WebElement aboutModal;

    @FindBy(xpath = "//div[@id='videoModal']//button[text()='Close']")
    WebElement closeButton;

    public AboutUsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        PageFactory.initElements(webDriver, this);
    }

    /**
 * This method implements test step logic.
 */
public void clickAboutUs() {
        wait.until(ExpectedConditions.elementToBeClickable(aboutUsLink)).click();
    }

    public boolean isModalDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(aboutModal));
        return aboutModal.isDisplayed();
    }

    /**
 * This method implements test step logic.
 */
public void closeModal() {
        wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
    }
}
