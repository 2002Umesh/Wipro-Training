package base;

import org.openqa.selenium.WebDriver;

import utilities.ConfigReader;

public class BaseClass {

	public WebDriver driver;

	public ConfigReader config;

	public void initialize() {

		config = new ConfigReader();

		DriverFactory.initDriver(

				config.getProperty("browser"));

		driver = DriverFactory.getDriver();

		driver.get(

				config.getProperty("url"));
	}
}