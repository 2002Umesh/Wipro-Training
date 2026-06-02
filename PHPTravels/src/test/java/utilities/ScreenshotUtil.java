package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {

	public static String captureScreenshot(WebDriver driver, String testName) {

		String path = "";

		try {

			if (driver == null) {

				System.out.println("Driver is NULL");

				return "";
			}

			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

			path = "reports/screenshots/" + testName + "_" + timeStamp + ".png";

			File folder = new File("reports/screenshots");

			if (!folder.exists()) {

				folder.mkdirs();
			}

			TakesScreenshot ts = (TakesScreenshot) driver;

			File src = ts.getScreenshotAs(OutputType.FILE);

			File dest = new File(path);

			FileHandler.copy(src, dest);

			System.out.println("Screenshot saved : " + dest.getAbsolutePath());

		}

		catch (NoSuchSessionException e) {

			System.out.println("Browser session already closed. Screenshot not captured.");
		}

		catch (Exception e) {

			e.printStackTrace();
		}

		return path;
	}
}