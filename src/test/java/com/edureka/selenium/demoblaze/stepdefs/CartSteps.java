package com.edureka.selenium.demoblaze.stepdefs;

import com.edureka.selenium.demoblaze.base.BaseTest;
import com.edureka.selenium.demoblaze.pages.HomePage;
import com.edureka.selenium.demoblaze.pages.ProductPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

/**
 * This class is part of the Demoblaze automation framework.
 */
public class CartSteps extends BaseTest {

    ProductPage productPage;

    @When("User selects a product")
    /**
 * This method implements test step logic.
 */
public void user_selects_product() {
        productPage = new ProductPage(getDriver());
        productPage.selectProduct();
    }

    @And("User adds the product to the cart")
    public void user_adds_product_to_cart() throws InterruptedException {
        Thread.sleep(1000); // allow page to load fully
        productPage.addToCart();
    }

    @Then("Product should be added successfully")
    public void product_should_be_added_successfully() throws InterruptedException {
        Thread.sleep(2000); // wait for alert
        boolean isAdded = productPage.handleAddToCartAlert();
        Assert.assertTrue(isAdded, "Product was not added successfully.");
    }
}
