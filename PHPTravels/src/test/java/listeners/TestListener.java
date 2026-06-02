package listeners;

import org.testng.*;

import base.DriverFactory;
import utilities.ScreenshotUtil;

public class TestListener implements ITestListener {

    public void onTestStart(ITestResult result) {

        System.out.println(
                "Started : " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {

        System.out.println("PASS Listener Triggered");

        ScreenshotUtil.captureScreenshot(
                DriverFactory.getDriver(),
                result.getName());

        DriverFactory.quitDriver();
    }

    public void onTestFailure(ITestResult result) {

        System.out.println("FAIL Listener Triggered");

        ScreenshotUtil.captureScreenshot(
                DriverFactory.getDriver(),
                result.getName());

        DriverFactory.quitDriver();
    }

    public void onTestSkipped(ITestResult result) {

        System.out.println("SKIP Listener Triggered");

        ScreenshotUtil.captureScreenshot(
                DriverFactory.getDriver(),
                result.getName());

        DriverFactory.quitDriver();
    }
}