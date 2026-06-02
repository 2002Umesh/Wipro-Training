package stepdefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.DriverFactory;
import io.cucumber.java.en.*;

import pages.HotelSearchPage;

public class HotelSearchSteps {

	HotelSearchPage hotel = new HotelSearchPage();

	@When("user searches hotel {string}")

	public void searchHotel(String destination) {

		hotel.enterDestination(destination);

//		hotel.enterCheckIn();
//
//		hotel.enterCheckOut();

		hotel.travellers();

		hotel.clickSearch();
	}

	@Then("validate hotel results")

	public void validateResults() {
		SoftAssert soft = new SoftAssert();
//		System.out.println(DriverFactory.getDriver().getCurrentUrl());
//		System.out.println(DriverFactory.getDriver().getTitle());
//		System.out.println(DriverFactory.getDriver().findElement(By.xpath("//h2")).toString());

		// Critical
		Assert.assertTrue(hotel.hotelResultsDisplayed(), "Hotel search failed");

		// Additional validations
		soft.assertTrue(DriverFactory.getDriver().getTitle().contains("PHPTRAVELS"), "Wrong page title");

		soft.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("stays"), "Wrong URL");
		soft.assertTrue(DriverFactory.getDriver().findElement(By.xpath("//h2")).isDisplayed(),
				"Hotels heading missing");

		soft.assertAll();

		System.out.println("Hotel Found");

	}
}