package stepdefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.DriverFactory;
import io.cucumber.java.en.*;

import pages.BookingPage;

public class BookingSteps {

	BookingPage booking = new BookingPage();

	@When("user choose a hotel")

	public void chooseHotel() {

		booking.selectHotel();

	}

	@And("user completes booking {string} {string} {string} {string}")

	public void bookingFlow(String fname, String lname, String email, String phonenum) {

		booking.confirmBooking(fname, lname, email, phonenum);

	}

	@Then("booking should be confirmed")

	public void logout() {

		SoftAssert soft = new SoftAssert();


		String msg = booking.getConfirmationMessage();

		// Critical
		Assert.assertTrue(msg.contains("Booking Confirmed Successfully!"), "Booking Failed");
		
//		System.out.println("URL: " + DriverFactory.getDriver().getCurrentUrl());
//		System.out.println("Title: " + DriverFactory.getDriver().getTitle());
//		System.out.println(DriverFactory.getDriver().findElement(By.xpath("//h3")).toString());
		// Additional validations
		soft.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("invoice"), "Booking URL mismatch");

		soft.assertTrue(DriverFactory.getDriver().getTitle().contains("PHPTRAVELS"),
				"Booking page missing");

		soft.assertAll();

		System.out.println("Booking Confirmed");
	}
}