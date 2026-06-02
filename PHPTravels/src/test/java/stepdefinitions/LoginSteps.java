package stepdefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.DriverFactory;
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
		SoftAssert soft = new SoftAssert();
//		System.out.println(DriverFactory.getDriver().getCurrentUrl());
//		System.out.println(DriverFactory.getDriver().getTitle());
//		System.out.println(DriverFactory.getDriver().findElement(By.xpath("//h2")).toString());
		// Critical validation
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("login"), "Login Failed");

		// Additional validations
		soft.assertTrue(DriverFactory.getDriver().getTitle().contains("Login"), "Login title mismatch");

		soft.assertTrue(DriverFactory.getDriver().findElement(By.xpath("//h2")).isDisplayed(),
				"Login heading missing");

		soft.assertAll();

		System.out.println("Login Validated");

	}
}