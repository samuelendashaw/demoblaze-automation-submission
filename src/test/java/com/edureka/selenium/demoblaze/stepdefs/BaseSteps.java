package com.edureka.selenium.demoblaze.stepdefs;

import com.edureka.selenium.demoblaze.base.BaseTest;
import io.cucumber.java.en.Given;

/**
 * This class is part of the Demoblaze automation framework.
 */
public class BaseSteps extends BaseTest {

    @Given("User is on the homepage")
    /**
 * This method implements test step logic.
 */
public void user_is_on_homepage() {
        // Browser is already initialized in Hooks, no need to initialize again
        getDriver().get("https://www.demoblaze.com");
    }
}
