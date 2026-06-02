package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class WaitUtil {
	public static void waitForInvisible(
	        WebDriver driver,
	        By locator) {

	    WebDriverWait wait =
	            new WebDriverWait(driver,
	                    Duration.ofSeconds(20));

	    wait.until(
	            ExpectedConditions
	                    .invisibilityOfElementLocated(locator));
	}

    public static WebElement waitForClickable(
            WebDriver driver,
            By locator) {

        return new WebDriverWait(
                driver,
                Duration.ofSeconds(30))
                .until(
                        ExpectedConditions
                                .elementToBeClickable(locator));
    }

    public static WebElement waitForVisible(
            WebDriver driver,
            By locator) {

        return new WebDriverWait(
                driver,
                Duration.ofSeconds(60))
                .until(
                        ExpectedConditions
                                .visibilityOfElementLocated(locator));
    }
    public static List<WebElement> waitForAllVisible(

    		WebDriver driver,
    		By locator) {

    	WebDriverWait wait =
    			new WebDriverWait(driver,
    					Duration.ofSeconds(10));

    	return wait.until(
    			ExpectedConditions
    			.visibilityOfAllElementsLocatedBy(locator));
    }

    public static WebElement waitForPresence(
            WebDriver driver,
            By locator) {

        return new WebDriverWait(
                driver,
                Duration.ofSeconds(30))
                .until(
                        ExpectedConditions
                                .presenceOfElementLocated(locator));
    }

    public static Alert waitForAlert(
            WebDriver driver) {

        return new WebDriverWait(
                driver,
                Duration.ofSeconds(15))
                .until(
                        ExpectedConditions
                                .alertIsPresent());
    }

    public static void waitForFrame(
            WebDriver driver,
            int frame) {

        new WebDriverWait(
                driver,
                Duration.ofSeconds(30))
                .until(
                        ExpectedConditions
                                .frameToBeAvailableAndSwitchToIt(frame));
    }
}