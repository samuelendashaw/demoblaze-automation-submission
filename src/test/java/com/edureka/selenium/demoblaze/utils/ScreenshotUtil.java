package com.edureka.selenium.demoblaze.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is part of the Demoblaze automation framework.
 */
public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver webDriver, String screenshotName) {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String path = "test-output/screenshots/" + screenshotName + "_" + timestamp + ".png";
        File src = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        File dest = new File(path);

        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            System.out.println("❌ Screenshot capture failed: " + e.getMessage());
        }

        return dest.getAbsolutePath();
    }
}
