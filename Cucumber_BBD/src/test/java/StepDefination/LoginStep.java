package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {
	WebDriver driver;

	@Given("login page should be open in default browser")
	public void login_page_should_be_open_in_default_browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://zero.webappsecurity.com/login.html");
	}

	@When("^click on user name field and add valid (.*)$")
	public void click_on_username_field_and_add_valid_user_username1(String username1) {
		WebElement user = driver.findElement(By.id("user_login"));
		user.sendKeys(username1);
	}

	@And("^then click on password button and enter valid (.*)$")
	public void then_click_on_password_button_and_enter_valid_password1(String password1) {
		WebElement pass = driver.findElement(By.id("user_password"));
		pass.sendKeys(password1);
	}

	@And("^now click on submit button (.*)$")
	public void now_click_on_submit_button(String Status) {
		driver.findElement(By.name("submit")).click();
		System.out.println("Test case status: "+Status);
	}

	@Then("login successfully and redirect to home page")
	public void login_successfully_and_redirect_to_home_page() throws InterruptedException {
		driver.navigate().back();
		Thread.sleep(2000);
		System.out.println("Login successfully done");
	}

}
