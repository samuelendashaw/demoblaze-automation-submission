package com.edureka.selenium.demoblaze.stepdefs;

import com.edureka.selenium.demoblaze.base.BaseTest;
import com.edureka.selenium.demoblaze.pages.ContactPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * This class is part of the Demoblaze automation framework.
 */
public class ContactSteps extends BaseTest {

    ContactPage contactPage = new ContactPage(getDriver());

    @When("User clicks on the contact link")
    /**
 * This method implements test step logic.
 */
public void user_clicks_on_contact_link() {
        contactPage.clickContactLink();
    }

    @When("User fills in the contact form with {string}, {string}, and {string}")
    /**
 * This method implements test step logic.
 */
public void user_fills_contact_form(String email, String name, String message) {
        contactPage.fillContactForm(email, name, message);
    }

    @When("User submits the contact form")
    /**
 * This method implements test step logic.
 */
public void user_submits_contact_form() {
        contactPage.clickSendMessage();
    }

    @Then("A confirmation alert should appear")
    /**
 * This method implements test step logic.
 */
public void confirmation_alert_should_appear() {
        contactPage.handleAlert();
    }
}
