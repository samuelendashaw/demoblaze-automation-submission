package com.edureka.selenium.demoblaze.testcases;

import com.edureka.selenium.demoblaze.base.BaseTest;
import com.edureka.selenium.demoblaze.pages.LoginPage;
import com.edureka.selenium.demoblaze.utils.LoggerUtil;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * This class is part of the Demoblaze automation framework.
 */
public class LoginTest extends BaseTest {

    LoginPage loginPage;
    Logger logger = LoggerUtil.getLogger(LoginTest.class);

    @Parameters("browser")
    @BeforeMethod
    /**
 * This method implements test step logic.
 */
public void setUp(String browser) {
        initializeBrowser(browser);
        loginPage = new LoginPage(getDriver());
    }

    @Test
    /**
 * This method implements test step logic.
 */
public void testValidLogin() {
        logger.info("🔐 Starting valid login test...");

        String expectedUser = "Welcome samdemo";

        loginPage.login("samdemo", "demo123");
        loginPage.waitForLoginSuccess(expectedUser);

        String actualUser = loginPage.getLoggedInUsernameText();
        logger.info("👤 Logged in username: " + actualUser);

        Assert.assertEquals(actualUser, expectedUser, "❌ Login failed or username mismatch!");
    }

    @AfterMethod
    /**
 * This method implements test step logic.
 */
public void tearDown() {
        quitBrowser();
        logger.info("🧹 Browser closed after test.");
    }
}
