package stepdefinitions;

import io.cucumber.java.en.*;

import pages.BookingPage;

public class BookingSteps {

	BookingPage booking = new BookingPage();

	@When("user choose a hotel")

	public void chooseHotel()
	{

		booking.selectHotel();

//		booking.travellerDetails("John Doe");

	}

	@And("user completes booking")

	public void bookingFlow() {

		booking.confirmBooking();

	}

	@Then("booking should be confirmed")

	public void logout() {

		booking.logout();
	}
}