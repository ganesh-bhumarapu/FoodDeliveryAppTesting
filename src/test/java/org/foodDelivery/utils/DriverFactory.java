package org.foodDelivery.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DriverFactory {
    private static final Logger logger = LogManager.getLogger(DriverFactory.class);
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static void initDriver(){
        logger.info("Initializing ChromeDriver...");
        WebDriver webDriver = new ChromeDriver();
        driver.set(webDriver);
        logger.info("ChromeDriver initialized successfully.");
    }

    public static WebDriver getDriver() {

        return driver.get();
    }

    public static void quitDriver() {
        logger.info("Quitting WebDriver...");
        driver.get().quit();

        driver.remove();
        logger.info("WebDriver quit successfully.");
    }
}
