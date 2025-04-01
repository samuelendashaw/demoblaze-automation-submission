package com.edureka.selenium.demoblaze.stepdefs;

import org.testng.Assert;

import com.edureka.selenium.demoblaze.pages.AboutUsPage;
import com.edureka.selenium.demoblaze.base.BaseTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
/**
 * This class is part of the Demoblaze automation framework.
 */
public class AboutUsSteps {
    private AboutUsPage aboutUsPage = new AboutUsPage(BaseTest.getDriver());

    @When("User clicks on the About Us link")
    /**
 * This method implements test step logic.
 */
public void user_clicks_about_us() {
        aboutUsPage.clickAboutUs();
    }
    
    @Then("About Us modal should appear")
    /**
 * This method implements test step logic.
 */
public void about_us_modal_should_appear() {
        Assert.assertTrue(aboutUsPage.isModalDisplayed(), "About Us modal did not appear");
    }

    @Then("User closes the About Us modal")
    /**
 * This method implements test step logic.
 */
public void user_closes_the_about_us_modal() {
        aboutUsPage.closeModal();
    }

}
