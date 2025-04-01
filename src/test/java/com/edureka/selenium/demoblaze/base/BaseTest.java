package com.edureka.selenium.demoblaze.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

/**
 * This class is part of the Demoblaze automation framework.
 */
public class BaseTest {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static void initializeBrowser(String browserName) {
        WebDriver selectedDriver;

        switch (browserName.toLowerCase()) {
            case "firefox":
                selectedDriver = new FirefoxDriver();
                break;
            case "edge":
                selectedDriver = new EdgeDriver();
                break;
            case "chrome":
            default:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--start-maximized");
                selectedDriver = new ChromeDriver(options);
                break;
        }

        selectedDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        selectedDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        selectedDriver.get("https://www.demoblaze.com");

        webDriver.set(selectedDriver);
    }

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void quitBrowser() {
        WebDriver currentDriver = webDriver.get();
        if (currentDriver != null) {
            currentDriver.quit();
            webDriver.remove(); // Clear thread-local for parallel safety
        }
    }
}
