package Testng_practice;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
public class LoginValidation_Test {
	WebDriver driver;

  @DataProvider(name="data")
  public Object[][] dp() {
    return new Object[][] {
    	
    	{"username","password"}
//    	{"admin","admin123"},
//    	{"admin","invalid"},
//    	{"invalid","invalid"}
    };
  }
  @Test(dataProvider = "data")
  public void f(String username1, String password1) throws InterruptedException {
	  driver = new ChromeDriver();
//	  driver.manage().window().maximize();
	  driver.get("http://zero.webappsecurity.com/login.html");
	  WebElement user = driver.findElement(By.id("user_login"));
	  user.sendKeys(username1);
	  WebElement pass = driver.findElement(By.id("user_password"));
	  pass.sendKeys(password1);
	  driver.findElement(By.name("submit")).click();
	  Thread.sleep(3000);
  }
}
