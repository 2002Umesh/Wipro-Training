package myStepDefination;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Listeners;

import Listeners.MyListener;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

@Listeners(MyListener.class)
public class StepDefinations {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	POM_pages pom;

	@Before
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		js = (JavascriptExecutor) driver;
		pom = new POM_pages(driver);
	}

	@After
	public void tearDown() {

		driver.quit();
	}

	@Given("OpenCart home page is open")
	public void open_home() {

		driver.get("https://tutorialsninja.com/demo/");
	}

	// REGISTRATION

	@When("user clicks Register option")
	public void register_page() throws InterruptedException {
		pom.registaration();
//        wait.until(ExpectedConditions.elementToBeClickable(
//                By.cssSelector("a[title='My Account']"))).click();
//
//        wait.until(ExpectedConditions.elementToBeClickable(
//                By.linkText("Register"))).click();
	}

	@And("enters firstname {string}")
	public void firstname(String fn) {

		driver.findElement(By.id("input-firstname")).sendKeys(fn);
	}

	@And("enters lastname {string}")
	public void lastname(String ln) {

		driver.findElement(By.id("input-lastname")).sendKeys(ln);
	}

	@And("enters registration email {string}")
	public void email(String email) {

		driver.findElement(By.id("input-email")).sendKeys(email);
	}

	@And("enters phone {string}")
	public void phone(String phone) {

		driver.findElement(By.id("input-telephone")).sendKeys(phone);
	}

	@And("enters registration password {string}")
	public void password(String pass) {

		driver.findElement(By.id("input-password")).sendKeys(pass);

		driver.findElement(By.id("input-confirm")).sendKeys(pass);
	}

	@And("selects privacy checkbox")
	public void privacy() {

		driver.findElement(By.name("agree")).click();
	}

	@And("clicks continue button")
	public void cont() {

		driver.findElement(By.cssSelector("input[value='Continue']")).click();
	}

	@Then("registration should complete")
	public void reg_done() {

		System.out.println("Registration completed");
	}

	// LOGIN

	@When("user clicks Login option")
	public void login_page() {

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='My Account']"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Login"))).click();
	}

	@And("enters login credentials {string} {string}")
	public void login_data(String username, String password) {
		pom.login(username, password);
//        driver.findElement(By.id("input-email"))
//                .sendKeys("xaybzc@gmail.com");
//
//        driver.findElement(By.id("input-password"))
//                .sendKeys("A1234567X");
	}

	@And("clicks Login button")
	public void login_btn() {

		driver.findElement(By.cssSelector("input[value='Login']")).click();
	}

	@Then("login should complete")
	public void login_done() {

		System.out.println("Login successful");
	}

	// CHANGE PHONE

	@Given("user is logged in {string} {string}")
	public void logged_in(String username, String password) {

		open_home();
		login_page();
		login_data(username, password);
		login_btn();
	}

	@When("user opens Edit Account")
	public void edit_account() {

		driver.findElement(By.xpath("//*[@id='content']/ul[1]/li[1]/a")).click();
	}

	@And("updates phone number")
	public void phone_update() {

		WebElement phone = driver.findElement(By.id("input-telephone"));

		phone.clear();
		phone.sendKeys("1116511111");

		driver.findElement(By.cssSelector("input[value='Continue']")).click();
	}

	@Then("account should update")
	public void account_ok() {

		System.out.println("Phone updated");
	}

	// ADDRESS

	@When("user opens Address Book")
	public void address_book() {

		driver.findElement(By.xpath("//*[@id='content']/ul[1]/li[3]/a")).click();

		driver.findElement(By.xpath("//*[@id='content']/div/div[2]/a")).click();
	}

	@And("updates firstname {string}")
	public void up_fn(String fn) {

		WebElement e = driver.findElement(By.id("input-firstname"));

		e.clear();
		e.sendKeys(fn);
	}

	@And("updates lastname {string}")
	public void up_ln(String ln) {

		WebElement e = driver.findElement(By.id("input-lastname"));

		e.clear();
		e.sendKeys(ln);
	}

	@And("updates address {string}")
	public void up_add(String add) {

		driver.findElement(By.id("input-address-1")).sendKeys(add);
	}

	@And("updates city {string}")
	public void up_city(String city) {

		driver.findElement(By.id("input-city")).sendKeys(city);
	}

	@And("updates postcode {string}")
	public void up_post(String post) {

		driver.findElement(By.id("input-postcode")).sendKeys(post);
	}

	@Then("address should update")
	public void add_ok() {

		System.out.println("Address updated");
	}

	// SEARCH

	@When("user searches {string}")
	public void search(String product) {
		pom.Search(product);
//        WebElement s =
//                driver.findElement(By.name("search"));
//
//        s.sendKeys(product);
//        s.sendKeys(Keys.ENTER);
	}

	@Then("search should work")
	public void search_ok() {

		driver.navigate().back();
	}

	// PRODUCT and CART

	@And("opens product detail")
	public void detail() {

		List<WebElement> products = driver.findElements(By.cssSelector("div.product-thumb"));

		products.get(1).click();
	}

	@And("adds product to cart")
	public void cart() {

		driver.findElement(By.id("button-cart")).click();
	}

	@Then("cart should update")
	public void cart_ok() {

		System.out.println("Cart updated");
	}

	// DELETE and CHECKOUT
	@When("opens shopping cart")
	public void open_cart() {
		driver.navigate().back();
		List<WebElement> products = driver.findElements(By.cssSelector("div.product-thumb"));

		products.get(2).click();
		cart();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Shopping Cart']"))).click();
	}

	@And("removes one cart item")
	public void remove_item() {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@data-original-title='Remove'])[1]")))
				.click();

		System.out.println("Cart item removed");
	}

	@And("proceeds checkout")
	public void checkout() {

		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Checkout"))).click();
	}

	@Then("cart operations should complete")
	public void cart_complete() {

		System.out.println("Delete completed");
		System.out.println("Checkout completed");
	}
}