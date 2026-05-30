package Testng_practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Assert_Test {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions ac;

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		js = (JavascriptExecutor) driver;
		ac = new Actions(driver);
		driver.get("https://www.selenium.dev/");
	}

	@Test(priority = 1)
	public void titlevalidation() {
		String expectedurl = "https://www.selenium.dev/";
		String actualurl = driver.getCurrentUrl();
		Assert.assertEquals(actualurl, expectedurl, "URL validation failed");

	}

	@Test(priority = 2)
	public void urlvalidation() {

		SoftAssert soft = new SoftAssert();
		String expectedtitle = "Selenium";
		String actualtitle = driver.getTitle();
		soft.assertEquals(actualtitle, expectedtitle, "Title validation failed");
		Assert.assertTrue(true,"Pause execution");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
