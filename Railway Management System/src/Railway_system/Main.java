package Railway_system;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("👤 Username: ");
		String username = sc.nextLine();
		System.out.print("🔒 Password: ");
		String password = sc.nextLine();

		if (!LoginService.login(username, password)) {
			System.out.println("❌ Login failed. Exiting...");
			sc.close();
			return;
		}

		RailwayService service = new RailwayService();

		while (true) {
			System.out.println("\n****** Railway Reservation System ******");
			System.out.println("1. View Trains");
			System.out.println("2. Book Ticket");
			System.out.println("3. View Reservations");
			System.out.println("4. Cancel Ticket");
			System.out.println("5. Exit");

			System.out.println("Enter Choice:");

			int choice = sc.nextInt();

			switch (choice) {
			case 1 -> service.viewTrains();
			case 2 -> service.bookTicket();
			case 3 -> service.viewReservations();
			case 4 -> service.cancelTicket();
			case 5 -> {
				System.out.println("🔚 Goodbye!");
				sc.close();
				return;
			}
			default -> System.out.println("❓ Invalid option");
			}
		}

	}

}
