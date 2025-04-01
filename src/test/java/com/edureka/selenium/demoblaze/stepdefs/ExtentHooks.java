package com.edureka.selenium.demoblaze.stepdefs;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.edureka.selenium.demoblaze.base.BaseTest;
import com.edureka.selenium.demoblaze.utils.ExtentReportManager;
import com.edureka.selenium.demoblaze.utils.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.Collection;

/**
 * This class is part of the Demoblaze automation framework.
 */
public class ExtentHooks extends BaseTest {

    @Before
    /**
 * This method implements test step logic.
 */
public void setUp(Scenario scenario) {
        // Create test entry in Extent Report
        ExtentTest test = ExtentReportManager.createTest(scenario.getName());

        // Assign author
        test.assignAuthor("Samuel Boru");

        // Assign scenario tags as categories
        Collection<String> tags = scenario.getSourceTagNames();
        for (String tag : tags) {
            test.assignCategory(tag.replace("@", ""));
        }

        // Default browser set to Chrome; can be customized by tags or config
        initializeBrowser("chrome");
    }

    @After
    /**
 * This method implements test step logic.
 */
public void tearDown(Scenario scenario) {
        ExtentTest test = ExtentReportManager.getTest();

        if (scenario.isFailed()) {
            if (getDriver() != null) {
                String screenshotPath = ScreenshotUtil.captureScreenshot(
                        getDriver(),
                        scenario.getName().replaceAll("[^a-zA-Z0-9]", "_")
                );
                test.fail("❌ Scenario Failed. Screenshot below:")
                    .addScreenCaptureFromPath(screenshotPath);
            } else {
                test.fail("❌ Scenario failed but browser was already closed.");
            }
        } else {
            test.log(Status.PASS, "✅ Scenario passed");
        }

        ExtentReportManager.flushReports();
        quitBrowser(); // Thread-safe quit
    }
}
