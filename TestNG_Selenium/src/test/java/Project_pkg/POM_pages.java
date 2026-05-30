package Project_pkg;

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

	POM_pages(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.ac = new Actions(driver);
	}

	// reg
	public void registaration() throws InterruptedException {
		WebElement regbtn = wait.until(ExpectedConditions.elementToBeClickable(account));

		regbtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[1]"))).click();

	}

	public void login() {
		WebElement regbtn = wait.until(ExpectedConditions.elementToBeClickable(account));

		regbtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[2]"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-email"))).sendKeys("xaybzc@gmail.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-password"))).sendKeys("A1234567X");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Login']"))).click();

	}

	public WebElement multiSearch() {
		return wait.until(ExpectedConditions.elementToBeClickable(search));
	}

	public void productDetail() {
		List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(search_products));
		products.get(1).click();

	}

	@Test
	public void f() {
	}
}