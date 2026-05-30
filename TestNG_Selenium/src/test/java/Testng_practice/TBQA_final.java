package Testng_practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class TBQA_final {
	
	
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

      driver.get("https://www.tirabeauty.com/");
  }
  @Test
  public void f() throws InterruptedException {
	  
	  String parent = driver.getWindowHandle();
	  ///////////////////////login
//      wait.until(ExpectedConditions.elementToBeClickable(
//              By.xpath("//span[contains(text(),'Login/Sign Up')]"))).click();
//
//      wait.until(ExpectedConditions.visibilityOfElementLocated(
//              By.id("mobile-number-input")))
//              .sendKeys("8260627714");
//      wait.until(ExpectedConditions.visibilityOfElementLocated(
//      		By.cssSelector("rect[fill=\"white\"]")))
//      .click();
//
//      driver.findElement(
//              By.xpath("//button[contains(text(),'Send OTP')]"))
//              .click();
//      WebElement otp = driver.findElement(
//      		By.xpath("//input[@class=\"otpInput--lz1OI \"][4]"));
//
//      
//      wait.until(driver ->
//      !otp.getAttribute("value").trim().isEmpty());
//      
//      driver.findElement(By.xpath("//button[contains(text(),'Verify OTP')]")).click();
      
      
      ////////////////multiple
      String[] items = {
              "beauty product",
              "lipstick",
              "lip balm"
      };

      for (String product : items) {

          WebElement search = wait.until(
                  ExpectedConditions.elementToBeClickable(
                          By.id("search")));

          search.click();
//          search.sendKeys(Keys.CONTROL + "a");
//          search.sendKeys(Keys.DELETE);
          search.sendKeys(product);
          search.sendKeys(Keys.ENTER);

          Thread.sleep(3000);


          
          driver.navigate().back();
      }
      
      
      //////////////////////////////product
      WebElement search = wait.until(
              ExpectedConditions.elementToBeClickable(
                      By.id("search")));

      search.sendKeys("handbags");
      search.sendKeys(Keys.ENTER);

      List<WebElement> products =
              wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                      By.cssSelector("div>div[class=\"gridItem--yQFgq undefined  \"]")));

      products.get(1).click();
      
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

		
		driver.switchTo().window(tabs.get(1));
		
		
		//////////////////////////////add
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@class=\"primary--SOMm7 undefined customBtn--MfL84 false  no-tap-highlight\"]")))
                .click();

        WebElement cartIcon = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("img[alt='cart-icon']")));

        cartIcon.click();
        
        
        
        /////////////////////////delete
     
        try {
            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("(//button[@class=\"quantityOperator--OrX86\"])[1]"))).click();
            WebElement remove = wait.until(
            		ExpectedConditions.elementToBeClickable(
            				By.xpath("//button[@class=\"remove--gLSGR\"]")));
            Thread.sleep(2000);
            remove.click();

         

            System.out.println("Cart item removed");

        } catch (Exception e) {

            System.out.println("No cart item found");
        }
        finally {
            driver.close();
            driver.switchTo().window(parent);
            driver.findElement(By.xpath("//img[@class=\"tiraLogo--YHd4w\"]")).click();
        }
        
        ////////////////////////////change name
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[@class='profileIcons--CGbu2 hoverProfile--L9ZbJ'])[1]"))).click();
        WebElement name = wait.until(ExpectedConditions.elementToBeClickable(
        		By.xpath("//input[@placeholder='First Name']")));
        name.clear();
        name.sendKeys("z");
        js.executeScript("window.scrollBy(0,300)");
//        wait.until(ExpectedConditions.elementToBeClickable(
//        		By.xpath("(//button[@class='submit--be4p6 lg--bX0Yr customBtn--MfL84 false  no-tap-highlight']"))).click();
        driver.findElement(
                By.xpath("//button[contains(text(),'Save')]")).click();
        

        ///////////////////////////change address
//    	ac = new Actions(driver);
////		WebElement mh = driver.findElement(By.xpath("(//img[@alt='user profile pic'])[1]"));
//		WebElement mh = driver.findElement(By.xpath("(//div[@class='profileIcons--CGbu2 hoverProfile--L9ZbJ'])[1]"));
//		
////		ac.moveToElement(mh)
////		  .pause(Duration.ofSeconds(1))
////		  .sendKeys(Keys.ARROW_DOWN)
////		  .sendKeys(Keys.ARROW_DOWN)
////		  .sendKeys(Keys.ARROW_DOWN)
////		  .sendKeys(Keys.ENTER)
////		  .perform();
//		
//		ac.moveToElement(mh).perform();
//
//		wait.until(ExpectedConditions.elementToBeClickable(
//		        By.xpath("(//a)[3]"))).click();
        
        
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//p[@class='titleDisplay--Hr_RW'])[3]"))).click();
		   js.executeScript("window.scrollBy(0,200)");
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@class='buttonPrimary--Erkuh']"))).click();
		
		
		
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//input[@name='address']"))).sendKeys("12");
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//input[@name='area']"))).sendKeys("abc");
		wait.until(ExpectedConditions.elementToBeClickable(
				By.id("pincode"))).sendKeys("123456");
		 js.executeScript("window.scrollBy(0,200)");
		
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@class='commonBtn--ojp_C btnFilled--jPhIs']"))).click();
		
		
		
		////////////////////////////////////////////
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='textWrapper--pV7Qz'])[1]")).click();
//	        wait.until(ExpectedConditions.elementToBeClickable(
//	                By.xpath("//p[normalize-space()='Personal Details']"))).click();
//	        js.executeScript("window.scrollBy(0,400)");
  }

  @AfterTest
  public void afterTest() {
      System.out.println("Tira Beauty automation completed");
//    driver.close();
  }

}
