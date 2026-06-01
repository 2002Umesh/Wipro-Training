package stepdefinitions;

import io.cucumber.java.en.*;

import pages.LoginPage;
import utilities.ExcelUtil;

public class LoginSteps {

	LoginPage login = new LoginPage();
	ExcelUtil excel = new ExcelUtil("src/test/resources/testdata/LogData.xlsx");

	@Given("user launches browser and click login")

	public void launchBrowser() {
		login.lg();
	}

	@When("user enters username and password")

	public void enterCredentials() {
		String username = excel.getCellData("sheet1", 1, 0);

		String password = excel.getCellData("sheet1", 1, 1);

		login.login(username, password);

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