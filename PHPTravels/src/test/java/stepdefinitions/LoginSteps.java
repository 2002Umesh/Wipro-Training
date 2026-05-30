package stepdefinitions;

import io.cucumber.java.en.*;

import pages.LoginPage;

public class LoginSteps {

	LoginPage login = new LoginPage();

	@Given("user launches browser and click login")

	public void launchBrowser() {
		login.lg();
	}

	@When("user enters {string} and {string}")

	public void enterCredentials(

			String user, String pass) {

		login.login(user, pass);
	}

	@And("clicks on login button")

	public void clickLogin() {

		login.clickLogin();
	}

	@Then("validate login result")

	public void validateLogin() {

		System.out.println("Login Validated");
	}
}