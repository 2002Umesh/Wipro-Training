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

		ScreenshotUtil.captureScreenshot(

				DriverFactory.getDriver(),

				result.getName());
	}

	public void onTestFailure(ITestResult result) {

		ScreenshotUtil.captureScreenshot(

				DriverFactory.getDriver(),

				result.getName());
	}

	public void onTestSkipped(ITestResult result) {

		ScreenshotUtil.captureScreenshot(

				DriverFactory.getDriver(),

				result.getName());
	}
}