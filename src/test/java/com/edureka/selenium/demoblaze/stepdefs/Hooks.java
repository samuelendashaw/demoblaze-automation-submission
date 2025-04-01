package com.edureka.selenium.demoblaze.stepdefs;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.edureka.selenium.demoblaze.base.BaseTest;
import com.edureka.selenium.demoblaze.utils.ExtentReportManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

/**
 * This class is part of the Demoblaze automation framework.
 */
public class Hooks {

    @After
    /**
 * This method implements test step logic.
 */
public void tearDown(Scenario scenario) {
        if (BaseTest.getDriver() != null) {
            try {
                if (scenario.isFailed()) {
                    File screenshot = ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.FILE);
                    String screenshotPath = "test-output/screenshots/" +
                            scenario.getName().replaceAll("[^a-zA-Z0-9]", "_") + ".png";
                    FileUtils.copyFile(screenshot, new File(screenshotPath));

                    ExtentReportManager.getReporter()
                            .createTest(scenario.getName())
                            .log(Status.FAIL, "❌ Test Failed")
                            .fail("Screenshot below:",
                                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                }
            } catch (IOException e) {
                System.err.println("⚠️ Failed to capture screenshot: " + e.getMessage());
            } finally {
                System.out.println("🧹 Closing browser after scenario.");
                BaseTest.quitBrowser(); // uses thread-safe quit
            }
        }
    }
}
