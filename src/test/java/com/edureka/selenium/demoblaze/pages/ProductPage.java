package com.edureka.selenium.demoblaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
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
public class ProductPage {

    WebDriver webDriver;
    WebDriverWait wait;

    public ProductPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(linkText = "Samsung galaxy s6")
    WebElement productLink;

    @FindBy(linkText = "Add to cart")
    WebElement addToCartButton;

    /**
 * This method implements test step logic.
 */
public void selectProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(productLink)).click();
    }

    /**
 * This method implements test step logic.
 */
public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public boolean handleAddToCartAlert() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = webDriver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Add to cart alert: " + alertText);
            alert.accept();
            return alertText.contains("Product added");
        } catch (NoAlertPresentException | TimeoutException e) {
            System.out.println("No alert appeared after adding to cart.");
            return false;
        }
    }
}
