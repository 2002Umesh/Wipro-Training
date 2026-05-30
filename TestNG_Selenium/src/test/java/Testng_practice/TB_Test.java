package Testng_practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TB_Test {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	String parent;
	TakesScreenshot tc;
	POM_implementation pompage;

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		js = (JavascriptExecutor) driver;

		driver.get("https://www.tirabeauty.com/");
		parent = driver.getWindowHandle();
		pompage = new POM_implementation(driver);

	}

	// ==========================
	// REGISTRATION
	// ==========================

	@Test(priority = 1, enabled = false)
	public void registration() {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Login/Sign Up')]")))
				.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobile-number-input"))).sendKeys("8260627714");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("rect[fill=\"white\"]"))).click();

		driver.findElement(By.xpath("//button[contains(text(),'Send OTP')]")).click();
		WebElement otp = driver.findElement(By.xpath("//input[@class=\"otpInput--lz1OI \"][4]"));

		wait.until(driver -> !otp.getAttribute("value").trim().isEmpty());

		driver.findElement(By.xpath("//button[contains(text(),'Verify OTP')]")).click();

//        wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//button[contains(text(),'Verify OTP')]"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class=\"commonInput--Tt_HG \"])[1]")))
				.sendKeys("a");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class=\"commonInput--Tt_HG \"])[2]")))
				.sendKeys("b");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class=\"commonInput--Tt_HG \"])[3]")))
				.sendKeys("ab@gmail.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Male')]"))).click();

//		driver.findElement(By.id("input-38")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-38"))).click();
//		WebElement yr = driver.findElement(By.xpath("//select[@class=\"react-datepicker__year-select\"]"));
		WebElement yr = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//select[@class=\\\"react-datepicker__year-select\\\"]")));

//		WebElement mt = driver.findElement(By.xpath("//select[@class=\"react-datepicker__month-select\"]"));
		WebElement mt = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//select[@class=\\\"react-datepicker__month-select\\\"]")));
		Select sel = new Select(yr);
//		sel.selectByValue("2000");
		sel.selectByIndex(10);
		Select sel1 = new Select(mt);
		sel1.selectByValue("3");
//		driver.findElement(By.xpath("//div[@class=\"react-datepicker__day react-datepicker__day--020\"]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@class=\\\"react-datepicker__day react-datepicker__day--020\\\"]"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Submit')]"))).click();

	}

	// ==========================
	// LOGIN
	// ==========================

	@Test(priority = 2, enabled = false)
	public void login() {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Login/Sign Up')]")))
				.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobile-number-input"))).sendKeys("8260627714");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("rect[fill=\"white\"]"))).click();

		driver.findElement(By.xpath("//button[contains(text(),'Send OTP')]")).click();
		WebElement otp = driver.findElement(By.xpath("//input[@class=\"otpInput--lz1OI \"][4]"));

		wait.until(driver -> !otp.getAttribute("value").trim().isEmpty());

		driver.findElement(By.xpath("//button[contains(text(),'Verify OTP')]")).click();
	}

	// ==========================
	// MULTIPLE SEARCH
	// ==========================

	@DataProvider(name = "searchdata")
	public Object[][] dp() {
		return new Object[][] { { "beauty product" }, { "lipstick" }, { "lip balm" }

		};
	}

	@Test(groups = "Regression", priority = 3, dataProvider = "searchdata")
	public void multiple_search(String product) throws InterruptedException, IOException {

		WebElement search = pompage.multiSearch();
		search.click();
		search.sendKeys(product);
		search.sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		driver.navigate().back();

	}

	// ==========================
	// PRODUCT DETAILS
	// ==========================

	@Test(groups = "Smoke", priority = 4)
	public void product_details() throws InterruptedException {

		WebElement search = pompage.multiSearch();

		search.sendKeys("handbags");
		search.sendKeys(Keys.ENTER);

		pompage.product_detail();
	


	}

	// ==========================
	// ADD TO CART
	// ==========================

	@Test(groups = "Smoke", priority = 5)
	public void add_to_cart() {

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@class=\"primary--SOMm7 undefined customBtn--MfL84 false  no-tap-highlight\"]")))
				.click();

		WebElement cartIcon = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='cart-icon']")));

		cartIcon.click();

	}

	// ==========================
	// DELETE CART ITEM
	// ==========================

	@Test(groups = "Smoke", priority = 6)
	public void delete_cart_item() throws IOException {

		try {
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("(//button[@class=\"quantityOperator--OrX86\"])[1]"))).click();
			WebElement remove = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class=\"remove--gLSGR\"]")));
			Thread.sleep(2000);
			remove.click();

			System.out.println("Cart item removed");

		} catch (Exception e) {

			System.out.println("No cart item found");
		} finally {
			// screenshot
			tc = (TakesScreenshot) driver;
			File src2 = tc.getScreenshotAs(OutputType.FILE);
			File dest2 = new File("Img2.png");
			FileHandler.copy(src2, dest2);
			driver.close();
			driver.switchTo().window(parent);
//            driver.findElement(By.xpath("//img[@class=\"tiraLogo--YHd4w\"]")).click();
		}
	}

	// ==========================
	// CHANGE ADDRESS
	// LOGIN REQUIRED
	// ==========================

	@Test(priority = 7, enabled = false)
	public void change_Address() {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[@class='titleDisplay--Hr_RW'])[3]"))).click();
		js.executeScript("window.scrollBy(0,200)");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='buttonPrimary--Erkuh']")))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='address']"))).sendKeys("12");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='area']"))).sendKeys("abc");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("pincode"))).sendKeys("123456");
		js.executeScript("window.scrollBy(0,200)");

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='commonBtn--ojp_C btnFilled--jPhIs']"))).click();

	}

	// ==========================
	// CHANGE NAME
	// LOGIN REQUIRED
	// ==========================

	@Test(priority = 8, enabled = false)
	public void Change_name() {

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='profileIcons--CGbu2 hoverProfile--L9ZbJ'])[1]")))
				.click();
		WebElement name = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='First Name']")));
		name.clear();
		name.sendKeys("z");
		js.executeScript("window.scrollBy(0,300)");

		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	}

	@AfterTest
	public void afterTest() {

		System.out.println("Tira Beauty automation completed");
		driver.close();
	}
}
