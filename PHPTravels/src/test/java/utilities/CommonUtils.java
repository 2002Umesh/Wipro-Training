package utilities;

import java.util.Random;

public class CommonUtils {

	public static String generateRandomEmail() {

		Random r = new Random();

		return

		"user" + r.nextInt(9999)

				+ "@gmail.com";
	}
}