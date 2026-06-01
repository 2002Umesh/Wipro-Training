package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import base.DriverFactory;
import utilities.CommonUtils;
import utilities.WaitUtil;

public class RegistrationPage {
	WebDriver driver = DriverFactory.getDriver();
	Actions ac = new Actions(driver);
	
	By loader = By.id("page-loader");
	By ack = By.id("acknowledgeDemoWarning");
	By regbtn = By.xpath("(//span[contains(text(),'Signup')])[1]");
	By cus = By.xpath("(//span[contains(text(),'Customer Signup')])[1]");

	By firstName = By.name("first_name");

	By lastName = By.name("last_name");

	By email = By.name("email");

	By password = By.name("password");

	By c_password = By.name("confirm_password");

	By security = By.name("captcha_answer");
	
	By privacy = By.xpath("//div[@class='checkbox-custom']");

//	By country = By.xpath("//select[contains(@name,'country')]");

	By registerButton = By.xpath("//button[@type='submit']");

	public void home() {
		driver.get("https://phptravels.net");
		
		 WaitUtil.waitForInvisible(driver, loader);
//		driver.findElement(By.id("acknowledgeDemoWarning")).click();
		WaitUtil.waitForClickable(driver, ack).click();
	}

	public void Click() {
		
		WebElement reg = WaitUtil.waitForVisible(driver, regbtn);
		ac.moveToElement(reg).perform();
		WaitUtil.waitForVisible(driver, cus).click();

	}

	public void enterFirstName(String fn) {

		WaitUtil.waitForVisible(driver, firstName).sendKeys(fn);
	}

	public void enterLastName(String ln) {

		driver.findElement(lastName).sendKeys(ln);
	}

	public void enterEmail(String e) {

		driver.findElement(email).sendKeys(e);
	}

	public void enterPassword(String pass) {

		driver.findElement(password).sendKeys(pass);
	}

	public void enterConfirmPassword(String c_pass) {

		driver.findElement(c_password).sendKeys(c_pass);
	}

//	public void selectCountry(String cname) {
//
//		Select s =
//
//				new Select(
//
//						driver.findElement(country));
//
//		s.selectByVisibleText(cname);
//	}

	public void captcha() throws InterruptedException {

		driver.findElement(security).click();
		Thread.sleep(10000);

	}
	public void privacyBox(){
		
		driver.findElement(privacy).click();
		
		
	}

	public void clickRegister() {

		driver.findElement(registerButton).click();
	}
}