package com.edureka.selenium.demoblaze.stepdefs;

import com.edureka.selenium.demoblaze.base.BaseTest;
import com.edureka.selenium.demoblaze.pages.OrderPage;
import com.edureka.selenium.demoblaze.pages.ProductPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

/**
 * This class is part of the Demoblaze automation framework.
 */
public class OrderSteps {

    ProductPage productPage;
    OrderPage orderPage;

    @When("User places the order with valid details")
    public void user_places_order_with_valid_details() throws InterruptedException {
        orderPage = new OrderPage(BaseTest.getDriver());  // ✅ Use thread-safe webDriver getter
        orderPage.placeOrder("John Doe", "USA", "New York", "1234567890123456", "10", "2025");
    }

    @Then("Order should be placed successfully")
    /**
 * This method implements test step logic.
 */
public void order_should_be_placed_successfully() {
        Assert.assertTrue(orderPage.isOrderSuccessMessageDisplayed(), "Order placement failed.");
    }
}
