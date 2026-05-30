package TestStepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class RegSteps {
	WebDriver driver;
	WebDriverWait wait;
	@Given("registration page should be open in default browser")
	public void registration_page_should_be_open_in_default_browser() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
	    
	}

	@When("^click on first name field and add valid (.*)$")
	public void click_on_first_name_field_and_add_valid_first_name(String firstname) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-firstname"))).sendKeys(firstname);

	}

	@And("^click on last name field and add valid (.*)$")
	public void click_on_last_name_field_and_add_valid_last_name(String lastname) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-lastname"))).sendKeys(lastname);

	}

	@And("^click on email field and enter valid (.*)$")
	public void click_on_email_field_and_enter_valid_email(String email) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-email"))).sendKeys(email);

	}

	@And("^click on telephone field and enter valid (.*)$")
	public void click_on_telephone_field_and_enter_valid_phone_number(String phonenumber) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-telephone"))).sendKeys(phonenumber);

	}

	@And("^click on password field and enter valid (.*)$")
	public void click_on_password_field_and_enter_valid_password(String password1) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-password"))).sendKeys(password1);

	}

	@When("^click on confirm password field and enter same (.*)$")
	public void click_on_confirm_password_field_and_enter_same_password(String password2) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-confirm"))).sendKeys(password2);
	
	}

	@And("click on privacy policy checkbox")
	public void click_on_privacy_policy_checkbox() {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='agree']"))).click();
	
	}

	@And("now click on continue button")
	public void now_click_on_continue_button() {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Continue']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='content']/div/div/a"))).click();
	}

	@Then("registration should be successful and redirect to home page")
	public void registration_should_be_successful_and_redirect_to_home_page() {
	    System.out.println("Registration successful");
	}


}
