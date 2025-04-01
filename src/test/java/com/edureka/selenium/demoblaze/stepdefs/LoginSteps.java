package com.edureka.selenium.demoblaze.stepdefs;

import com.edureka.selenium.demoblaze.base.BaseTest;
import com.edureka.selenium.demoblaze.pages.LoginPage;
import com.edureka.selenium.demoblaze.utils.ExcelReader;
import com.edureka.selenium.demoblaze.utils.LoggerUtil;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

/**
 * This class is part of the Demoblaze automation framework.
 */
public class LoginSteps extends BaseTest {

    LoginPage loginPage;
    Logger logger = LoggerUtil.getLogger(LoginSteps.class);
    List<Map<String, String>> testData;

    @Given("Login test data is loaded from Excel")
    /**
 * This method implements test step logic.
 */
public void loadLoginDataFromExcel() {
        logger.info("📘 Loading login test data from Excel...");
        String path = "src/test/resources/testdata/LoginData.xlsx";
        testData = ExcelReader.readExcel(path, "Sheet1");
    }

    @When("User attempts to log in with each credential set from Excel")
    /**
 * This method implements test step logic.
 */
public void user_attempts_to_log_in_with_each_credential_set_from_excel() {
        for (Map<String, String> data : testData) {
            WebDriver localDriver = new ChromeDriver(); // Use a local webDriver
            localDriver.manage().window().maximize();
            localDriver.get("https://www.demoblaze.com");

            loginPage = new LoginPage(localDriver);

            String username = data.get("Username");
            String password = data.get("Password");
            String expectedResult = data.get("ExpectedResult");

            if (username == null || username.trim().isEmpty() ||
                password == null || password.trim().isEmpty()) {
                logger.warn("⚠️ Skipping row with blank Username or Password.");
                localDriver.quit();
                continue;
            }

            logger.info("🔐 Testing login with Username: " + username + " | Password: " + password);

            loginPage.clickLoginTab();
            loginPage.enterUsername(username);
            loginPage.enterPassword(password);
            loginPage.clickLoginButton();

            try {
                Thread.sleep(2000); // Replace with WebDriverWait in production
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if ("Success".equalsIgnoreCase(expectedResult)) {
                boolean isLoggedIn = loginPage.isLoginSuccessful("Welcome " + username);
                logger.info("✅ Login expected to succeed: " + isLoggedIn);
                Assert.assertTrue(isLoggedIn, "Login failed for valid user: " + username);
            } else {
                String actualAlert = loginPage.getLoginErrorAlertMessage();
                logger.info("❌ Expected failure. Alert shown: " + actualAlert);
                Assert.assertEquals(actualAlert.trim(), expectedResult.trim(), "Expected and actual alert messages did not match.");
            }

            localDriver.quit();
        }

    }

    @When("User clicks on the login link")
    /**
 * This method implements test step logic.
 */
public void user_clicks_on_the_login_link() {
        loginPage = new LoginPage(getDriver());
        logger.info("🖱️ User clicks on the login link.");
        loginPage.clickLoginTab();
    }

    @And("User enters {string} and {string}")
    /**
 * This method implements test step logic.
 */
public void user_enters_credentials(String username, String password) {
        logger.info("✍️ Entering Username: " + username + " | Password: " + password);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("User clicks the login button")
    /**
 * This method implements test step logic.
 */
public void user_clicks_the_login_button() {
        logger.info("🔘 Clicking the login button.");
        loginPage.clickLoginButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("User should be logged in and see welcome message")
    /**
 * This method implements test step logic.
 */
public void user_should_be_logged_in() {
        String actual = loginPage.getLoggedInUsernameText();
        logger.info("👤 Logged in as: " + actual);
        Assert.assertTrue(actual.contains("Welcome"), "Login failed or welcome message not found.");
    }

    @Then("User should see an error alert with message {string}")
    /**
 * This method implements test step logic.
 */
public void user_should_see_error_alert_with_message(String expectedAlertMessage) {
        String actualAlert = loginPage.getLoginErrorAlertMessage();
        logger.info("⚠️ Alert Message: " + actualAlert);
        Assert.assertEquals(actualAlert.trim(), expectedAlertMessage.trim(), "Login alert message mismatch.");
    }
}
