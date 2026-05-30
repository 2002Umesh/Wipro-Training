package Testng_practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class POM_implementation {
	
	WebDriver driver;
	WebDriverWait wait;
	By search = By.id("search");
	By search_products = By.cssSelector("div>div[class=\"gridItem--yQFgq undefined  \"]");

	POM_implementation(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	public WebElement multiSearch() {
		return wait.until(
	            ExpectedConditions.elementToBeClickable(search)
		        );
	}

	public void product_detail() {
		List<WebElement> products =  wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(search_products));
		products.get(1).click();

		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

		driver.switchTo().window(tabs.get(1));
	}

  @Test
  public void f() {
  }



}
