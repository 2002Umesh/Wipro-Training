//package stepdefinitions;
//
//import io.cucumber.java.en.*;
//
//import pages.*;
//
//public class BookingWorkflowSteps {
//
//	LoginPage login = new LoginPage();
//
//	HotelSearchPage hotel = new HotelSearchPage();
//
//	BookingPage booking = new BookingPage();
//
//	ConfirmationPage confirm = new ConfirmationPage();
//
//	@Given("user completes booking")
//
//	public void fullBooking() {
//
//		login.login(
//
//				"user@phptravels.com", "demouser");
//
//		hotel.enterDestination("Delhi");
//
////        hotel.enterCheckIn(
////                "30-05-2026");
////
////        hotel.enterCheckOut(
////                "05-06-2026");
////
////        hotel.travellers(
////                "2");
//
//		hotel.clickSearch();
//
//		booking.selectHotel();
//
////		booking.travellerDetails("John Doe");
//
//		booking.confirmBooking();
//	}
//
//	@Then("booking should be confirmed")
//
//	public void validateBooking() {
//
//		System.out.println(
//
//				confirm.isBookingConfirmed());
//	}
//}