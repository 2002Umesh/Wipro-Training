package stepdefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.DriverFactory;
import io.cucumber.java.en.*;

import pages.RegistrationPage;

public class RegistrationSteps {
	RegistrationPage reg = new RegistrationPage();

	@Given("PHPTravels home page is open")
	public void homepage() {
		reg.home();
	}

	@Given("user clicks Register option")
	public void clicks_register() {
		reg.Click();
	}

	@When("enters necessary credentials {string} {string} {string} {string} {string}")
	public void credentials(String fn, String ln, String email, String password, String c_password) {
		reg.enterFirstName(fn);
		reg.enterLastName(ln);
		reg.enterEmail(email);
		reg.enterPassword(password);
		reg.enterConfirmPassword(c_password);
	}

	@When("enters security check value")
	public void security_check() throws InterruptedException {
		reg.captcha();
	}

	@When("selects privacy checkbox")
	public void privacy_checkbox() {
		reg.privacyBox();
	}

	@When("clicks create account button")
	public void clicks_create_account_button() {
		reg.clickRegister();
	}

	@Then("registration should complete")
	public void registration_should_complete() {
	    SoftAssert soft = new SoftAssert();

	    String url =
	            DriverFactory.getDriver()
	                    .getCurrentUrl();
//		System.out.println(url);
//		System.out.println(DriverFactory.getDriver().getTitle());
//		System.out.println(DriverFactory.getDriver().findElement(By.xpath("//h2")).toString());

	    // Critical
	    Assert.assertTrue(
	            url.contains("signup"),
	            "Registration Failed");

	    // Extra validations
	    soft.assertTrue(
	            DriverFactory.getDriver()
	                    .getTitle()
	                    .contains("Signup"),
	            "Title mismatch");

	    soft.assertTrue(
	            DriverFactory.getDriver()
	                    .findElement(By.xpath("//body"))
	                    .isDisplayed(),
	            "Page not displayed");

	    soft.assertAll();

	    System.out.println("Registration successful");
	}
}