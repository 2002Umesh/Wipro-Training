package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {

	public static String captureScreenshot(

			WebDriver driver, String testName) {

		String path = "";

		try {

			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

			path = "reports/screenshots/" + testName + "_" + timeStamp + ".png";

			TakesScreenshot ts = (TakesScreenshot) driver;

			File src = ts.getScreenshotAs(OutputType.FILE);

			FileHandler.copy(src, new File(path));

		}

		catch (Exception e) {

			e.printStackTrace();
		}

		return path;
	}
}