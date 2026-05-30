package Testng_practice;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;

public class Test_dataprovider {
	WebDriver driver;
  @DataProvider(name="browsers", parallel = true)
  public Object[][] dp() {
    return new Object[][] {
    	{"chrome"},
    	{"edge"},
    	{"firefox"}
    };
  }

  @Test(dataProvider = "browsers")
  public void crossbrowser_test(String browser) throws InterruptedException {
	  if(browser.equalsIgnoreCase("chrome")) {
		  driver = new ChromeDriver();
		  Thread.sleep(3000);
	  }
	  else if(browser.equalsIgnoreCase("edge")) {
		  driver = new EdgeDriver();
		  Thread.sleep(3000);
	  }
	  else if(browser.equalsIgnoreCase("firefox")) {
		  driver = new FirefoxDriver();
		  Thread.sleep(3000);
	  }
	  else
	  {
		  System.out.println("Invalid browser");
	  }
	  driver.manage().window().maximize();
	  driver.get("https://www.selenium.dev/");
	  System.out.println("Title : "+driver.getTitle());
	  driver.close();
  }

}
