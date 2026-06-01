package pages;

//import java.util.List;

import org.openqa.selenium.*;

import base.DriverFactory;
import utilities.WaitUtil;

public class HotelSearchPage {

	WebDriver driver = DriverFactory.getDriver();

	By city =

			By.xpath("(//input[@placeholder='Search By City'])[2]");

//	By checkIn = By.name("checkin_date");
//
//	By checkOut = By.id("checkout_date");

//	By rooms = By.xpath("/html/body/div[2]/div[3]/div/div/div[1]/div/div/form/div[2]/div[1]/div/div[1]");
    
	By stay = By.xpath("(//span[contains(.,'Stays')])[2]");
//	By nationality = By.xpath("(//div[@class='input cursor-pointer flex items-center justify-between'])[8]");
	By nationality = By.xpath("(//div[@class='field-box pr-9 cursor-pointer'])[6]");
	By searchButton = By.xpath("(//button[contains(@type,'submit')])[4]");
	By selectCity = By.xpath("(//span[@class='text-sm font-semibold text-gray-900 truncate'][normalize-space()='Dubai'])[1]");


	public void enterDestination(String destination) {
		WaitUtil.waitForVisible(driver, stay).click();

		WaitUtil.waitForVisible(driver, city).sendKeys(destination);
		WaitUtil.waitForVisible(driver, selectCity).click();
		
	}

//	public void enterCheckIn() {
//
//		driver.findElement(checkIn);
//	}
//
//	public void enterCheckOut(String date) {
//
//		driver.findElement(checkOut).sendKeys(date);
//	}
	public void travellers() {

		
	    WebElement nat = WaitUtil.waitForVisible(driver, nationality);

	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    // scroll to element
	    js.executeScript("arguments[0].scrollIntoView({block:'center'});", nat);

	    // JS click
	    js.executeScript("arguments[0].click();", nat);
//	    nat.click();

	    // enter country
	    WebElement searchCountry =
	            WaitUtil.waitForVisible(driver,
	                    By.xpath("//input[@placeholder='Search country...']"));

	    searchCountry.sendKeys("ind");

	    // select India
	    WebElement india =
	            WaitUtil.waitForVisible(driver,
	                    By.xpath("(//span[@x-text='country.nicename'])[2]"));

	    js.executeScript("arguments[0].click();", india);
//	    india.click();
	}

	public void clickSearch() {

		driver.findElement(searchButton).click();
	}

//	public int hotelCount() {
//
//		List<WebElement> list =
//
//				driver.findElements(hotels);
//
//		return list.size();
//	}
}