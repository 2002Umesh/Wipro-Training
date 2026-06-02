package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;
import utilities.WaitUtil;

public class BookingPage {

	WebDriver driver = DriverFactory.getDriver();

//    By selectHotel =
//            By.xpath("(//a[@class='btn'])[1]");
//    By selectHotel =
//    		By.xpath("(//span[contains(text(),'More Details')])[1]");
	By selectHotel = By.xpath(
			"//body//div[@x-data='hotelSearch()']//div//div//div//div//div[1]//div[1]//div[1]//div[2]//div[2]//a[1]");

	// Updated locator
	By bookingBtn = By.xpath("(//span[normalize-space()='Select'])[2]");

	By continueBooking = By.xpath("//button[contains(.,'Continue Booking')]");

	By guest = By.xpath("(//span[contains(.,'check')])[5]");

	By sign = By.xpath("(//select[@class='select'])[1]");

	By firstname = By.xpath("(//input[@class='input'])[3]");

	By lastname = By.xpath("(//input[@class='input'])[4]");

	By email = By.xpath("(//input[@class='input'])[5]");

	By phone = By.xpath("(//input[@class='input'])[6]");

	By payOption = By.xpath("//label[@for='payment_6']");
//    By payOption =
//    		By.xpath("(//input[@name='payment' and @type='radio'])[1]");

	By terms = By.xpath("(//div[@class='checkbox-custom'])[2]");
//    By terms =
//    		By.xpath("(//span[contains(.,'check')])[6]");
//    By terms =
//    		By.cssSelector("label[for='terms_accepted']");

	By fname = By.xpath("(//input[@class='input'])[7]");

	By lname = By.xpath("(//input[@class='input'])[8]");

	By confirmFinalBooking = By.xpath("//button[contains(.,'Confirm Booking')]");

	By successMsg = By.id("successMessage");

	public void selectHotel() {
//driver.navigate().to("https://phptravels.net/stay/burj-al-arab/200/hotels/_/30-05-2026/31-05-2026/IN/1/1-0");
//        JavascriptExecutor js =
//                (JavascriptExecutor) driver;

		WebElement hotel = WaitUtil.waitForClickable(driver, selectHotel);
		hotel.click();
//        js.executeScript(
//                "arguments[0].scrollIntoView({block:'center'});",
//                hotel);
//
//        js.executeScript(
//                "arguments[0].click();",
//                hotel);
	}

	public void confirmBooking(String fname, String lname, String e, String phonenum) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		// Select booking
		WebElement selectBtn = WaitUtil.waitForClickable(driver, bookingBtn);

		js.executeScript("arguments[0].scrollIntoView({block:'center'});", selectBtn);

		js.executeScript("arguments[0].click();", selectBtn);

		// Continue booking
		WebElement continueBtn = WaitUtil.waitForClickable(driver, continueBooking);

		js.executeScript("arguments[0].click();", continueBtn);

//        // Guest checkbox
//        WebElement guestCheck =
//                WaitUtil.waitForVisible(
//                        driver,
//                        guest);
////        	guestCheck.click();
//        js.executeScript(
//                "arguments[0].click();",
//                guestCheck);

		// Title dropdown
		WebElement title = WaitUtil.waitForClickable(driver, sign);

		title.click();
		title.sendKeys(Keys.ARROW_DOWN);
		title.sendKeys(Keys.ENTER);

		// Guest details
		WaitUtil.waitForVisible(driver, firstname).sendKeys(fname);

		WaitUtil.waitForVisible(driver, lastname).sendKeys(lname);

		WaitUtil.waitForVisible(driver, email).sendKeys(e);

		WaitUtil.waitForVisible(driver, phone).sendKeys(phonenum);

		// Billing details
//        WaitUtil.waitForVisible(driver, fname)
//                .sendKeys("Thomas");
//
//        WaitUtil.waitForVisible(driver, lname)
//                .sendKeys("Doe");

		js.executeScript("window.scrollBy(0,900)");
		// Payment
		WaitUtil.waitForClickable(driver, payOption).click();

		// Terms
		WaitUtil.waitForClickable(driver, terms).click();

		// Confirm booking
		WebElement confirmBtn = WaitUtil.waitForClickable(driver, confirmFinalBooking);

		js.executeScript("arguments[0].scrollIntoView({block:'center'});", confirmBtn);

		js.executeScript("arguments[0].click();", confirmBtn);
	}

	public String getConfirmationMessage() {

		try {

			WebElement msg = WaitUtil.waitForVisible(driver, successMsg);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			 wait.until(d -> !msg.getText().trim().isEmpty());

			return msg.getText();

		} catch (Exception e) {

			return "";
		}
	}
}