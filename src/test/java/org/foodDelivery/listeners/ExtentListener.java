package org.foodDelivery.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.foodDelivery.reports.ExtentManager;
import org.foodDelivery.reports.ExtentTestManager;
import org.foodDelivery.utils.DriverFactory;
import org.foodDelivery.utils.ScreenshotUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentListener implements ITestListener {

    private static final ExtentReports extent = ExtentManager.getInstance();

    @Override
    public void onStart(ITestContext context) {
        System.out.println("========== Test Suite Started ==========");
    }

    @Override
    public void onTestStart(ITestResult result) {

        String testName = result.getMethod().getMethodName();

        ExtentTest test = extent.createTest(testName);

        ExtentTestManager.setTest(test);

        ExtentTestManager.getTest().info("Executing Test : " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentTestManager.getTest().pass(
                result.getMethod().getMethodName() + " executed successfully."
        );

        ExtentTestManager.unload();
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTestManager.getTest().fail(result.getThrowable());

        String screenshotPath = ScreenshotUtil.captureScreenshot(
                DriverFactory.getDriver(),
                result.getMethod().getMethodName());

        try {
            if (screenshotPath != null) {
                ExtentTestManager.getTest()
                        .addScreenCaptureFromPath(
                                screenshotPath,
                                "Failure Screenshot"
                        );
            }

        } catch (Exception e) {

            ExtentTestManager.getTest()
                    .warning("Unable to attach screenshot : " + e.getMessage());
        }

        ExtentTestManager.unload();
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentTestManager.getTest().skip(
                result.getMethod().getMethodName() + " was skipped."
        );

        ExtentTestManager.unload();
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

        System.out.println("========== Test Suite Finished ==========");
    }
}