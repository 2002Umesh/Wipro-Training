package TestStepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class LoginSteps {
	WebDriver driver;
	WebDriverWait wait;

	@Given("login page should be open in default browser everytime")
	public void login_page_should_be_open_in_default_browser_everytime() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
	}

	@When("^click on email and enter valid (.*)$")
	public void click_on_email_field_and_enter_valid_email(String email) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-email"))).sendKeys(email);
	}

	@And("^click on password and enter valid (.*)$")
	public void click_on_password_field_and_enter_valid_password(String password) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-password"))).sendKeys(password);
	}

	@And("now click on login button")
	public void now_click_on_login_button() {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Login']"))).click();
//		driver.findElement(By.cssSelector("input[value='Login']")).click();
	}

	@Then("login should be successful and redirect to home page")
	public void login_should_be_successful_and_redirect_to_home_page() {
		System.out.println("login successful");
	}

}
