package Listener_codes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.MyListener;
import Testng_practice.POM_impl;
@Listeners(MyListener.class)
public class Test_cases {
	WebDriver driver;

	@DataProvider(name = "data")
	public Object[][] dp() {
		return new Object[][] {

				{ "username", "password" },

		};
	}

	@Test(dataProvider = "data")
	public void test1(String user1, String pass1) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://zero.webappsecurity.com/login.html");

		// for normal
		WebElement user = driver.findElement(By.id("user_login"));
		user.sendKeys(user1);
		WebElement pass = driver.findElement(By.id("user_password"));
		pass.sendKeys(pass1);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);

		System.out.println("First test case execution");
		driver.close();
	}

	@Test
	public void test2() {
//		Assert.fail();
		System.out.println("Second test execution");
	}
}
