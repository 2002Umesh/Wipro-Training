package pages;

import org.openqa.selenium.*;

import base.DriverFactory;

public class ConfirmationPage {

    WebDriver driver =
            DriverFactory.getDriver();

    By confirmationMessage =
            By.xpath(
                    "//div[contains(.,'Booking Confirmed')]");

    public boolean
    isBookingConfirmed() {

        return driver
                .findElement(
                        confirmationMessage)
                .isDisplayed();
    }
}