package com.edureka.selenium.demoblaze.testcases;

import com.edureka.selenium.demoblaze.base.BaseTest;
import com.edureka.selenium.demoblaze.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * This class is part of the Demoblaze automation framework.
 */
public class HomePageTest extends BaseTest {

    HomePage homePage;

    @Parameters("browser")
    @BeforeMethod
    /**
 * This method implements test step logic.
 */
public void setUp(String browser) {
        initializeBrowser(browser);  // Updated to accept dynamic browser
        homePage = new HomePage(getDriver());  // Use thread-safe getter
    }

    @Test(priority = 1)
    /**
 * This method implements test step logic.
 */
public void verifyHomePageTitle() {
        String actualTitle = homePage.getHomePageTitle();
        String expectedTitle = "STORE";
        Assert.assertEquals(actualTitle, expectedTitle, "❌ Home Page title does not match!");
    }

    @Test(priority = 2)
    /**
 * This method implements test step logic.
 */
public void verifyLogoIsDisplayed() {
        boolean isLogoVisible = homePage.isLogoDisplayed();
        Assert.assertTrue(isLogoVisible, "❌ Logo is not displayed on the Home Page!");
    }
}
