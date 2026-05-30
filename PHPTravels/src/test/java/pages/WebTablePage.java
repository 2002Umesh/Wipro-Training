package pages;

import java.util.*;

import org.openqa.selenium.*;

import base.DriverFactory;

public class WebTablePage {

	WebDriver driver = DriverFactory.getDriver();

	By rows = By.xpath("//table//tr");

	public void tableValidation() {

		List<WebElement> rowList =

				driver.findElements(rows);

		List<Integer> amounts = new ArrayList<>();

		HashMap<Integer, String> map = new HashMap<>();

		HashSet<String> duplicates = new HashSet<>();

		for (int i = 1; i < rowList.size(); i++) {

			List<WebElement> cols =

					rowList.get(i).findElements(By.tagName("td"));

			String bookingName =

					cols.get(0).getText();

			int amount =

					Integer.parseInt(

							cols.get(3).getText().replace("₹", "").replace(",", ""));

			amounts.add(amount);

			map.put(amount, bookingName);

			if (!duplicates.add(bookingName)) {

				System.out.println(

						"Duplicate Row : " + bookingName);
			}
		}

		System.out.println(

				"Highest Amount : " + Collections.max(amounts));

		System.out.println(

				"Lowest Amount : " + Collections.min(amounts));

		System.out.println(

				"Booking Map : " + map);
	}
}