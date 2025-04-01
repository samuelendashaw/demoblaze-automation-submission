package com.edureka.selenium.demoblaze.stepdefs;
import static com.edureka.selenium.demoblaze.base.BaseTest.getDriver;

import com.edureka.selenium.demoblaze.pages.RegisterPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

/**
 * This class is part of the Demoblaze automation framework.
 */
public class RegisterSteps {

    RegisterPage registerPage;

    @When("User clicks on the signup link")
    /**
 * This method implements test step logic.
 */
public void user_clicks_on_signup_link() {
    	registerPage = new RegisterPage(getDriver());
        registerPage.clickSignUpLink();
    }

    @And("User enters {string} and {string} in the signup form")
    /**
 * This method implements test step logic.
 */
public void user_enters_credentials_in_signup(String baseUsername, String password) {
        String uniqueUsername = baseUsername + System.currentTimeMillis();
        registerPage.enterSignupUsername(uniqueUsername);
        registerPage.enterSignupPassword(password);
    }

    @And("User clicks the signup button")
    /**
 * This method implements test step logic.
 */
public void user_clicks_signup_button() {
        registerPage.clickSignUpButton();
    }

    @Then("A signup confirmation alert should appear")
    /**
 * This method implements test step logic.
 */
public void signup_alert_should_appear() {
        String alertText = registerPage.handleAlert();
        Assert.assertTrue(alertText.contains("Sign up"), "Expected signup alert not found");
    }
}
