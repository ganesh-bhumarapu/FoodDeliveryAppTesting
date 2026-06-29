package org.foodDelivery.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.foodDelivery.utils.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.foodDelivery.reports.ExtentTestManager;
import org.foodDelivery.utils.ScreenshotUtil;

public class Hooks {
    private static final Logger logger = LogManager.getLogger(Hooks.class);

    @Before
    public void initializeDriver(Scenario scenario){
        logger.info("---------------------------------------------------------");
        logger.info("Starting Scenario: " + scenario.getName());
        DriverFactory.initDriver();
        DriverFactory.getDriver().manage().window().maximize();
    }

    @After
    public void quitDriver(Scenario scenario){
        if (scenario.isFailed()) {
            logger.error("Scenario Failed! Capturing screenshot...");
            try {
                // For Cucumber HTML Report
                final byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failure Screenshot");
                
                // For ExtentReport
                String base64Screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BASE64);
                if (ExtentTestManager.getTest() != null) {
                    ExtentTestManager.getTest().addScreenCaptureFromBase64String(base64Screenshot, "Failure Screenshot");
                }
            } catch (Exception e) {
                logger.error("Failed to capture screenshot", e);
            }
        }
        
        logger.info("Ending Scenario: " + scenario.getName() + " with status: " + scenario.getStatus());
        DriverFactory.quitDriver();
        logger.info("---------------------------------------------------------");
    }
}
