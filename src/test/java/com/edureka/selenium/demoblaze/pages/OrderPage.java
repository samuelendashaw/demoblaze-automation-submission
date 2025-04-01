package com.edureka.selenium.demoblaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
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
public class OrderPage {

    WebDriver webDriver;
    WebDriverWait wait;

    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//a[text()='Cart']")
    WebElement cartLink;

    @FindBy(xpath = "//button[text()='Place Order']")
    WebElement placeOrderButton;

    @FindBy(id = "name")
    WebElement nameField;

    @FindBy(id = "country")
    WebElement countryField;

    @FindBy(id = "city")
    WebElement cityField;

    @FindBy(id = "card")
    WebElement cardField;

    @FindBy(id = "month")
    WebElement monthField;

    @FindBy(id = "year")
    WebElement yearField;

    @FindBy(xpath = "//button[text()='Purchase']")
    WebElement purchaseButton;

    @FindBy(xpath = "//div[@class='sweet-alert  showSweetAlert visible']/h2")
    WebElement confirmationHeader;

    @FindBy(id = "orderModal")
    WebElement orderModal;

    /**
 * This method implements test step logic.
 */
public void navigateToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
    }

    /**
 * This method implements test step logic.
 */
public void clickPlaceOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
    }

    /**
 * This method implements test step logic.
 */
public void fillOrderDetails(String name, String country, String city, String card, String month, String year) {
        wait.until(ExpectedConditions.visibilityOf(nameField)).sendKeys(name);
        countryField.sendKeys(country);
        cityField.sendKeys(city);
        cardField.sendKeys(card);
        monthField.sendKeys(month);
        yearField.sendKeys(year);
    }

    /**
 * This method implements test step logic.
 */
public void clickPurchase() {
        wait.until(ExpectedConditions.elementToBeClickable(purchaseButton)).click();
    }

    public boolean isOrderSuccessMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(confirmationHeader))
                       .getText()
                       .equalsIgnoreCase("Thank you for your purchase!");
        } catch (Exception e) {
            System.err.println("Confirmation message not found: " + e.getMessage());
            return false;
        }
    }

    /**
 * This method implements test step logic.
 */
public void handleAlertIfPresent() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = webDriver.switchTo().alert();
            System.out.println("Alert message: " + alert.getText());
            alert.accept();
        } catch (NoAlertPresentException | org.openqa.selenium.TimeoutException e) {
            System.out.println("No alert present. Continuing...");
        }
    }

    /**
 * This method implements test step logic.
 */
public void placeOrder(String name, String country, String city, String card, String month, String year) {
        handleAlertIfPresent();
        navigateToCart();
        clickPlaceOrder();
        wait.until(ExpectedConditions.visibilityOf(orderModal));
        fillOrderDetails(name, country, city, card, month, year);
        clickPurchase();
    }
}
