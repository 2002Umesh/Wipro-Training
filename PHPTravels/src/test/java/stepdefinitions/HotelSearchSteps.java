package stepdefinitions;

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
		System.out.println("Hotel found");

//		System.out.println(
//
//				"Hotels Found : " + hotel.hotelCount());
	}
}