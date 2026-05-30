package stepdefinitions;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.DriverFactory;

public class AssertionSteps {

	public void validateAssertions() {

		// Hard Assert

		Assert.assertTrue(

				DriverFactory.getDriver().getCurrentUrl().contains("phptravels"));

		Assert.assertEquals(

				DriverFactory.getDriver().getTitle(),

				"PHPTRAVELS");

		// Soft Assert

		SoftAssert soft = new SoftAssert();

		soft.assertTrue(true);

		soft.assertEquals(

				"Booking Confirmed",

				"Booking Confirmed");

		soft.assertAll();
	}
}