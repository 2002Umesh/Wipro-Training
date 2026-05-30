package utilities;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class WaitUtil {

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