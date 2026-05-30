package Testng_practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class CrossBrowser_testing {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions ac;
	SoftAssert soft;

  @Test(groups="Regression")
  public void chrome() {
	  driver = new ChromeDriver();
	  driver.get("https://www.selenium.dev/");
  }
  @Test(groups = "Smoke")
  public void fireFox() {
	  
	  driver = new FirefoxDriver();
	  driver.get("https://www.selenium.dev/");
  }
  @Test(groups = "Regression")
  public void Edge() {
	  driver = new EdgeDriver();
	  driver.get("https://www.selenium.dev/");
  }

  @AfterTest
  public void afterTest() {
  }

}
