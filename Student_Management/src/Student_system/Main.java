package Student_system;

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

		StudentService service = new StudentService();

		while (true) {
			System.out.println("\n****** Student System ******");
			System.out.println("1. View Students");
			System.out.println("2. Add Student");
			System.out.println("3. Exit");

			System.out.println("Enter Choice:");

			int choice = sc.nextInt();

			switch (choice) {
			case 1 -> service.viewStudents();
			case 2 -> service.addStudents();
			case 3 -> {
				System.out.println("🔚 Goodbye!");
				sc.close();
				return;
			}
			default -> System.out.println("❓ Invalid option");
			}
		}

	}

}
