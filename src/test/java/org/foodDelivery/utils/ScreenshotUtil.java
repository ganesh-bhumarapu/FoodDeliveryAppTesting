package org.foodDelivery.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {
        if (driver == null) {
            return null;
        }

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());

        String destination = System.getProperty("user.dir")
                + "/Reports/Screenshots/"
                + testName + "_" + timestamp + ".png";

        File source = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        try {
            FileHandler.copy(source, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destination;
    }
}