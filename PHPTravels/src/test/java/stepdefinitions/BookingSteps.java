package stepdefinitions;

import io.cucumber.java.en.*;

import pages.BookingPage;

public class BookingSteps {

	BookingPage booking = new BookingPage();

	@When("user choose a hotel")

	public void chooseHotel()
	{

		booking.selectHotel();



	}

	@And("user completes booking {string} {string} {string} {string}")

	public void bookingFlow(String fname, String lname, String email, String phonenum) {

		booking.confirmBooking(fname,lname,email,phonenum);

	}

	@Then("booking should be confirmed")

	public void logout() {

		booking.logout();
	}
}