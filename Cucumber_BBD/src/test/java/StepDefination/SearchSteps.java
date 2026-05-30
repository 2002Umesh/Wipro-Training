package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class SearchSteps {
	WebDriver driver;
	@When("^click on search,add item and click enter (.*)$")
	public void click_on_search_add_item_and_click_enter(String product) throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/index.html");
		WebElement search = driver.findElement(By.id("searchTerm"));
		search.click();
		search.sendKeys(product);
		search.sendKeys(Keys.ENTER);
	}

	@Then("show search item")
	public void show_search_item() {
		System.out.println("search item displayed");
	   
	}

}
