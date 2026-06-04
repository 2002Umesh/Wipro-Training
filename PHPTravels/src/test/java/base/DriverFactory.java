package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void initDriver(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
//			ChromeOptions options = new ChromeOptions();
//
//			options.addArguments("--headless=new");
//			options.addArguments("--window-size=1920,1080");
//			options.addArguments("--start-maximized");
//			options.addArguments("--disable-dev-shm-usage");
//			options.addArguments("--no-sandbox");
//
//			driver.set(new ChromeDriver(options));
			driver.set(new ChromeDriver());

		}

//        else if(browser.equalsIgnoreCase(
//                "firefox")) {
//
//            WebDriverManager
//                    .firefoxdriver()
//                    .setup();
//
//            driver.set(
//                    new FirefoxDriver());
//        }

		else if (browser.equalsIgnoreCase("edge")) {

//			WebDriverManager.edgedriver().setup();

			driver.set(new EdgeDriver());
		}

		getDriver().manage().window().maximize();
	}

	public static WebDriver getDriver() {

		return driver.get();
	}

	public static void quitDriver() {

		if (getDriver() != null) {

			getDriver().quit();

			driver.remove();
		}
	}
}