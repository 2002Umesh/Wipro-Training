package utilities;

import org.openqa.selenium.*;

public class ExceptionUtil {

	public static WebElement retryStaleElement(

			WebDriver driver, By locator) {

		int attempts = 0;

		while (attempts < 3) {

			try {

				return driver.findElement(locator);

			}

			catch (StaleElementReferenceException e) {

				attempts++;
			}
		}

		return null;
	}

	public static void safeClick(

			WebDriver driver, By locator) {

		try {

			WaitUtil.waitForClickable(driver, locator).click();

		}

		catch (ElementClickInterceptedException e) {

			JavascriptExecutor js =

					(JavascriptExecutor) driver;

			js.executeScript(

					"arguments[0].click();",

					driver.findElement(locator));
		}
	}

	public static WebElement safeFind(

			WebDriver driver, By locator) {

		try {

			return WaitUtil.waitForVisible(driver, locator);

		}

		catch (

				NoSuchElementException | TimeoutException e) {

			return null;
		}
	}
}