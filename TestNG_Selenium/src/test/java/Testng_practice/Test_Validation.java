package Testng_practice;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

public class Test_Validation {
	WebDriver driver;
	WebDriverWait wait;
//	POM_impl page = new POM_impl(driver);
	

	@DataProvider(name = "searchdata")
	public Object[][] dp() {
		return new Object[][] {

				// Valid
				{ "lipstick" },

				// Brand searches
				{ "Lakme" },

				// Exact product type

				{ "face wash" },

				// Mixed

				{ "SuNsCrEeN" },

				// Numbers

				{ "spf 50" },

				// Special characters
				{ "@#$%" },

				// Spaces / empty

				{ " " },

				// Invalid / no-result searches

				{ "nothingfoundtest" },

				// Long search text
				{ "best sunscreen for oily acne prone skin under 500" } };
	}

	@DataProvider(name = "registration")
	public Object[][] dp1() {
		return new Object[][] {
				// Valid
				{ "Arjun", "Purohit", "arjunp@gmail.com", "ArjnP@123", "ArjnP@123" },

				// Invalid email
				{ "Emma", "Wilson", "emma.gmail.com", "Emma@456", "Emma@456" },

				// Password mismatch
				{ "Rahul", "Sharma", "rahul99@gmail.com", "Rahul@789", "Rahul@000" },

				// Empty first name
				{ "", "Brown", "sophia07@gmail.com", "Sophia@321", "Sophia@321" },

				// Weak password
				{ "Amit", "Patel", "amit55@gmail.com", "123", "123" }

		};
	}

	@Test(dataProvider = "searchdata")
	public void f(String product) throws InterruptedException {
		driver = new ChromeDriver();
//	  driver.manage().window().maximize();
		driver.get("https://www.tirabeauty.com");
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.id("search")));
		search.click();
		search.sendKeys(product);
		search.sendKeys(Keys.ENTER);

		driver.close();
	}

	@Test(dataProvider = "registration")
	public void f1(String fname, String lname, String mail, String pass, String cpass) throws InterruptedException {
		driver = new ChromeDriver();
//	  driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com");
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement register = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Register']")));

		register.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("gender-male"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("FirstName"))).sendKeys(fname);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("LastName"))).sendKeys(lname);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("Email"))).sendKeys(mail);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("Password"))).sendKeys(pass);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ConfirmPassword"))).sendKeys(cpass);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("register-button"))).click();

		System.out.println("Title : " + driver.getTitle());

		driver.close();
	}
}
