package Project_pkg;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.java.swing.plaf.windows.resources.windows;

public class OpenCart_Demo {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	String parent;
	TakesScreenshot tc;
	POM_pages pompages;

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {

		driver = new ChromeDriver();

//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		js = (JavascriptExecutor) driver;

		driver.get("https://tutorialsninja.com/demo/");
		parent = driver.getWindowHandle();
		pompages = new POM_pages(driver);

	}

	// ==========================
	// REGISTRATION
	// ==========================

	
	@DataProvider(name = "registrationData")
	public Object[][] regData() {
		return new Object[][] {

				{ "abc", "xyz", "abc1zsig@gmail.com", "125442554", "A1234567X" }

		};
	}

	@Test(priority = 1, enabled = false, dataProvider = "registrationData")
	public void registration(String fname, String lname, String email, String phone, String password)
			throws InterruptedException {

		pompages.registaration();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-firstname"))).sendKeys(fname);

		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-lastname"))).sendKeys(lname);

		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-email"))).sendKeys(email);

		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-telephone"))).sendKeys(phone);

		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-password"))).sendKeys(password);

		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-confirm"))).sendKeys(password);

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='agree']"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Continue']"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='content']/div/div/a"))).click();
	}

	// ==========================
	// LOGIN
	// ==========================

	@Test(priority = 2,groups = "Smoke", enabled = true)
	public void login() throws InterruptedException {

		pompages.login();

	}

	// ==========================
	// CHANGE NAME
	// LOGIN REQUIRED
	// ==========================

	@Test(priority = 3,groups = "Sanity", enabled = true)
	public void Change_name() {
//		pompages.login();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='content']/ul[1]/li[1]/a"))).click();
		WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(By.id("input-telephone")));
		phone.clear();
		phone.sendKeys("1111111111");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Continue']"))).click();

	}

	// ==========================
	// CHANGE ADDRESS
	// LOGIN REQUIRED
	// ==========================

	@DataProvider(name = "addressData")
	public Object[][] dpAddress() {
		return new Object[][] { { "abc", "xyz", "my new addr", "sbp", "127458" } };
	}

	@Test(priority = 4,groups = "Smoke", enabled = true, dataProvider = "addressData")
	public void change_Address(String fname, String lname, String address, String city, String postcode)
			throws InterruptedException {

//		pompages.login();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='content']/ul[1]/li[3]/a"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='content']/div/div[2]/a"))).click();

		WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable(By.id("input-firstname")));
		firstName.clear();
		firstName.sendKeys(fname);

		WebElement lastName = wait.until(ExpectedConditions.elementToBeClickable(By.id("input-lastname")));
		lastName.clear();
		lastName.sendKeys(lname);

		WebElement addr = wait.until(ExpectedConditions.elementToBeClickable(By.id("input-address-1")));
		addr.clear();
		addr.sendKeys(address);

		WebElement cityField = wait.until(ExpectedConditions.elementToBeClickable(By.id("input-city")));
		cityField.clear();
		cityField.sendKeys(city);

		WebElement post = wait.until(ExpectedConditions.elementToBeClickable(By.id("input-postcode")));
		post.clear();
		post.sendKeys(postcode);

		js.executeScript("window.scrollBy(0,100)");

		WebElement country = wait.until(ExpectedConditions.elementToBeClickable(By.id("input-country")));
		country.click();
		country.sendKeys(Keys.ARROW_DOWN);
		country.sendKeys(Keys.ARROW_DOWN);
		country.sendKeys(Keys.ENTER);

		WebElement region = wait.until(ExpectedConditions.elementToBeClickable(By.id("input-zone")));
		region.click();
		region.sendKeys(Keys.ARROW_DOWN);
		region.sendKeys(Keys.ARROW_DOWN);
		region.sendKeys(Keys.ENTER);

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Continue']"))).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='content']/div[1]/table/tbody/tr/td[2]/a[2]"))).click();
	}

	// ==========================
	// MULTIPLE SEARCH
	// ==========================

	@DataProvider(name = "searchdata")
	public Object[][] dp() {
		return new Object[][] { { "iphone" }, { "macbook" }, { "canon" }

		};
	}

	@Test(groups = "Regression", priority = 5, dataProvider = "searchdata", enabled = true)
	public void multiple_search(String product) throws InterruptedException, IOException {
//		pompages.login();
		WebElement search = pompages.multiSearch();
		search.click();
		search.sendKeys(product);
		search.sendKeys(Keys.ENTER);

		Thread.sleep(2000);

		driver.navigate().back();
		search.clear();

	}

	// ==========================
	// PRODUCT DETAILS
	// ==========================

	@Test(groups = "Smoke", priority = 6)
	public void product_details() throws InterruptedException {

		WebElement search = pompages.multiSearch();

		search.sendKeys("macbook");
		search.sendKeys(Keys.ENTER);

		pompages.productDetail();

	}

	// ==========================
	// ADD TO CART
	// ==========================

	@Test(groups = "Smoke", priority = 7)
	public void add_to_cart() {

		wait.until(ExpectedConditions.elementToBeClickable(By.id("button-cart"))).click();

		driver.navigate().back();
		List<WebElement> products = wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class='product-thumb']")));
		products.get(2).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("button-cart"))).click();

		WebElement cartIcon = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Shopping Cart']")));

		cartIcon.click();

	}

	// ==========================
	// DELETE CART ITEM
	// ==========================

	@Test(groups = "Smoke", priority = 8, enabled = true)
	public void delete_cart_item() throws IOException, InterruptedException {

		try {

			WebElement remove = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("(//button[@data-original-title='Remove'])[1]")));
			Thread.sleep(1000);
			remove.click();

			System.out.println("Cart item removed");

		} catch (Exception e) {

			System.out.println("No cart item found");
		} finally {
			// screenshot
//			Thread.sleep(2000);
//			tc = (TakesScreenshot) driver;
//			File src2 = tc.getScreenshotAs(OutputType.FILE);
//			File dest2 = new File("TestOutput.png");
//			FileHandler.copy(src2, dest2);
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,500)");

		}
	}

	// ==========================
	// CHECKOUT
	// ==========================

	@Test(groups = "Regression", priority = 9, enabled = true)
	public void checkout() throws IOException, InterruptedException {

		try {

			WebElement remove = wait
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='pull-right']")));
			Thread.sleep(1000);
			remove.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='content']/div[3]/div[1]/a"))).click();

		} catch (Exception e) {

			System.out.println("No cart item found");
		} finally {
//			Assert.fail();
			System.out.println("Checkout fail");

		}
	}

	@AfterTest
	public void afterTest() {

		System.out.println("opencart automation completed");
		driver.quit();
	}
}
