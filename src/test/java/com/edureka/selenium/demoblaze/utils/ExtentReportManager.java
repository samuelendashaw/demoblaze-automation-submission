package com.edureka.selenium.demoblaze.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * This class is part of the Demoblaze automation framework.
 */
public class ExtentReportManager {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    // Initialize or return ExtentReports instance
    public static ExtentReports getReporter() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
            spark.config().setReportName("Demoblaze Automation Report");
            spark.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }

    // Create and assign test to current thread
    public static ExtentTest createTest(String testName) {
        ExtentTest test = getReporter().createTest(testName);
        extentTest.set(test);
        return test;
    }

    // Get test instance for current thread
    public static ExtentTest getTest() {
        return extentTest.get();
    }

    // Flush all reports
    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}
