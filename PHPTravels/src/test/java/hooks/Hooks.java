package hooks;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.ConfigReader;

public class Hooks {

	ConfigReader config = new ConfigReader();

	@Before

	public void setUp() {

		DriverFactory.initDriver(

				config.getProperty("browser"));

		DriverFactory.getDriver().get(

				config.getProperty("url"));
	}

	@After

	public void tearDown() {

		DriverFactory.quitDriver();
	}
}