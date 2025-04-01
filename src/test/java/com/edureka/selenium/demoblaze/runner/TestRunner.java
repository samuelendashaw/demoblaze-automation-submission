package com.edureka.selenium.demoblaze.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.edureka.selenium.demoblaze.stepdefs",
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true
)
/**
 * This class is part of the Demoblaze automation framework.
 */
public class TestRunner extends AbstractTestNGCucumberTests {
}
