package Testng_practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TiraBeautyQA {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    
    @BeforeTest
    public void beforeTest() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        js = (JavascriptExecutor) driver;

        driver.get("https://www.tirabeauty.com/");
        
    }

    // ==========================
    // REGISTRATION
    // ==========================

    @Test(priority = 1, enabled = false)
    public void registration() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(),'Login/Sign Up')]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("mobile-number-input")))
                .sendKeys("8260627714");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
        		By.cssSelector("rect[fill=\"white\"]")))
        .click();

        driver.findElement(
                By.xpath("//button[contains(text(),'Send OTP')]"))
                .click();
        WebElement otp = driver.findElement(
        		By.xpath("//input[@class=\"otpInput--lz1OI \"][4]"));

        
        wait.until(driver ->
        !otp.getAttribute("value").trim().isEmpty());
        
        driver.findElement(By.xpath("//button[contains(text(),'Verify OTP')]")).click();
        
//        wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//button[contains(text(),'Verify OTP')]"))).click();
        
        
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//input[@class=\"commonInput--Tt_HG \"])[1]"))).sendKeys("a");
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//input[@class=\"commonInput--Tt_HG \"])[2]"))).sendKeys("b");
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//input[@class=\"commonInput--Tt_HG \"])[3]"))).sendKeys("ab@gmail.com");
        wait.until(ExpectedConditions.elementToBeClickable(
        		By.xpath("//span[contains(text(),'Male')]"))).click();
        
//		driver.findElement(By.id("input-38")).click();
		wait.until(ExpectedConditions.elementToBeClickable(
        		By.id("input-38"))).click();
//		WebElement yr = driver.findElement(By.xpath("//select[@class=\"react-datepicker__year-select\"]"));
		WebElement yr = wait.until(ExpectedConditions.elementToBeClickable(
        		By.xpath("//select[@class=\\\"react-datepicker__year-select\\\"]")));
		
//		WebElement mt = driver.findElement(By.xpath("//select[@class=\"react-datepicker__month-select\"]"));
		WebElement mt = wait.until(ExpectedConditions.elementToBeClickable(
        		By.xpath("//select[@class=\\\"react-datepicker__month-select\\\"]")));
		Select sel = new Select(yr);
//		sel.selectByValue("2000");
		sel.selectByIndex(10);
		Select sel1 = new Select(mt);
		sel1.selectByValue("3");
//		driver.findElement(By.xpath("//div[@class=\"react-datepicker__day react-datepicker__day--020\"]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(
        		By.xpath("//div[@class=\\\"react-datepicker__day react-datepicker__day--020\\\"]"))).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(
        		By.xpath(""))).click();
        
        

        
    }

    // ==========================
    // LOGIN
    // ==========================

    @Test(priority = 2, enabled = false)
    public void login() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(),'Login/Sign Up')]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("mobile-number-input")))
                .sendKeys("8260627714");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
        		By.cssSelector("rect[fill=\"white\"]")))
        .click();

        driver.findElement(
                By.xpath("//button[contains(text(),'Send OTP')]"))
                .click();
        WebElement otp = driver.findElement(
        		By.xpath("//input[@class=\"otpInput--lz1OI \"][4]"));

        
        wait.until(driver ->
        !otp.getAttribute("value").trim().isEmpty());
        
        driver.findElement(By.xpath("//button[contains(text(),'Verify OTP')]")).click();
    }

    // ==========================
    // MULTIPLE SEARCH
    // ==========================

    @Test(priority = 3, enabled = true)
    public void multiple_search() throws InterruptedException {
    	
//    	String parent = driver.getWindowHandle();
    	
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
//            search.sendKeys(Keys.CONTROL + "a");
//            search.sendKeys(Keys.DELETE);
            search.sendKeys(product);
            search.sendKeys(Keys.ENTER);

            Thread.sleep(3000);

//            Assert.assertTrue(
//                    driver.getTitle().toLowerCase().contains(
//                            product.split(" ")[0]));
            
            driver.navigate().back();
        }
//        driver.switchTo().window(parent);
    }

    // ==========================
    // PRODUCT DETAILS
    // ==========================

    @Test(priority = 4, enabled = true)
    public void product_details() throws InterruptedException {
    	

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
//		Thread.sleep(3000);
        
        
//        System.out.println("products: "+products.toString());

//        Assert.assertTrue(driver.getCurrentUrl().contains("product"));
    }

    // ==========================
    // ADD TO CART
    // ==========================

    @Test(priority = 5, enabled = true)
    public void add_to_cart() {
    	

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@class=\"primary--SOMm7 undefined customBtn--MfL84 false  no-tap-highlight\"]")))
                .click();

        WebElement cartIcon = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("img[alt=\"cart-icon\"]")));

        cartIcon.click();
        


//        Assert.assertTrue(driver.getCurrentUrl().contains("cart")
//                || driver.getCurrentUrl().contains("bag"));
    }

    // ==========================
    // DELETE CART ITEM
    // ==========================

    @Test(priority = 6, enabled = true)
    public void delete_cart_item() {
    	String parent = driver.getWindowHandle();
        try {

            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("(//button[@class=\"quantityOperator--OrX86\"])[1]"))).click();
            WebElement remove = wait.until(
            		ExpectedConditions.elementToBeClickable(
            				By.xpath("//button[@class=\"remove--gLSGR\"]")));
            remove.click();

         

            System.out.println("Cart item removed");

        } catch (Exception e) {

            System.out.println("No cart item found");
        }
        finally {
            driver.close();
            driver.switchTo().window(parent);
        }
    }

    // ==========================
    // CHANGE ADDRESS
    // LOGIN REQUIRED
    // ==========================

    @Test(priority = 7, enabled = false)
    public void change_Address() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(),'Address')]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Pincode']")))
                .sendKeys("760001");

        driver.findElement(
                By.xpath("//button[contains(text(),'Save')]"))
                .click();
    }

    // ==========================
    // CHANGE NAME
    // LOGIN REQUIRED
    // ==========================

    @Test(priority = 8, enabled = false)
    public void Change_name() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(),'Profile')]"))).click();

        WebElement name = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@name='name']")));

        name.clear();
        name.sendKeys("Umesh Das");

        driver.findElement(
                By.xpath("//button[contains(text(),'Save')]"))
                .click();
    }

    @AfterTest
    public void afterTest() {

        System.out.println("Tira Beauty automation completed");
//        driver.close();
    }
}
