package pages;

import org.openqa.selenium.*;

import base.DriverFactory;
import utilities.WaitUtil;

public class LoginPage {

	WebDriver driver = DriverFactory.getDriver();
	By log = By.xpath("/html/body/header/div[1]/div/div[2]/a");

	By email =

			By.name("email");

	By password =

			By.name("password");

	By loginButton =

			By.xpath("//button[@type='submit']");

	public void lg() {

		WaitUtil.waitForVisible(driver, log).click();
	}

	public void enterEmail(String user) {

		WaitUtil.waitForVisible(driver, email).sendKeys(user);
	}

	public void enterPassword(String pass) {

//		driver.findElement(password).sendKeys(pass);
		WaitUtil.waitForVisible(driver, password).sendKeys(pass);
	}

	public void clickLogin() {

//		driver.findElement(loginButton).click();
		WaitUtil.waitForClickable(driver, loginButton).click();
	}

	public void login(

			String user, String pass) {

		enterEmail(user);

		enterPassword(pass);

		clickLogin();
	}
}