package myStepDefination;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class POM_pages {
	WebDriver driver;
	WebDriverWait wait;
	Actions ac;

	// locators
	By account = By.cssSelector("a[title='My Account']");
	By search = By.cssSelector("input[name='search']");
	By search_products = By.cssSelector("div[class='product-thumb']");
	By product_links =
	        By.cssSelector("div.product-thumb h4 a");

	POM_pages(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.ac = new Actions(driver);
	}

	// registration
	public void registaration() throws InterruptedException {
		WebElement regbtn = wait.until(ExpectedConditions.elementToBeClickable(account));

		regbtn.click();
      wait.until(ExpectedConditions.elementToBeClickable(
      By.linkText("Register"))).click();

	}

	public void login(String username,String password) {
//		WebElement acc = wait.until(ExpectedConditions.elementToBeClickable(account));
//
//		acc.click();
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[2]"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-email"))).sendKeys(username);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-password"))).sendKeys(password);
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Login']"))).click();

	}

	public void Search(String product) {
	       WebElement s =
	                driver.findElement(search);

	        s.sendKeys(product);
	        s.sendKeys(Keys.ENTER);
	}

	public void productDetail(int val) {
//		List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(search_products));
//		products.get(1).click();
	    List<WebElement> products =
	            wait.until(ExpectedConditions
	            .visibilityOfAllElementsLocatedBy(product_links));

	        products.get(val).click();

	}

	@Test
	public void f() {
	}
}


