package Railway_system;

import java.sql.*;
import java.util.Scanner;

public class RailwayService {

	Scanner sc = new Scanner(System.in);

	Connection con;

	public RailwayService() {

		try {

			con = DBConnection.getConnection();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// VIEW TRAINS
	public void viewTrains() {

		try {

			String sql = "SELECT * FROM trains";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				System.out.println(
						rs.getInt("train_id") + " | " + rs.getString("train_name") + " | " + rs.getString("source")
								+ " -> " + rs.getString("destination") + " | Seats: " + rs.getInt("available_seats") + " | Price: " + rs.getFloat("price") + " | Price: " + rs.getFloat("special_price"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// BOOK TICKET
	public int tickets;
	public void bookTicket() {

		try {

			System.out.println("Enter Passenger Name:");
			String name = sc.nextLine();

			System.out.println("Enter Age:");
			int age = sc.nextInt();
			sc.nextLine();

			System.out.println("Enter Gender:");
			String gender = sc.nextLine();

			System.out.println("Enter Train ID:");
			int trainId = sc.nextInt();
			sc.nextLine();

			System.out.println("Enter Journey Date (YYYY-MM-DD):");
			String date = sc.nextLine();
			
			System.out.println("Are you in special person category: ");
			String special = sc.nextLine();
			
			System.out.println("How many tickets: ");
			int count = sc.nextInt();
			tickets=count;

			// CHECK AVAILABLE SEATS
			String checkSql = "SELECT available_seats,price,special_price FROM trains WHERE train_id=?";

			PreparedStatement checkPs = con.prepareStatement(checkSql);

			checkPs.setInt(1, trainId);

			ResultSet rs = checkPs.executeQuery();

			if (rs.next()) {

				int seats = rs.getInt("available_seats");
				float price = rs.getFloat("price");
				float special_price = rs.getFloat("special_price");

				if (seats >= count) {

					// INSERT PASSENGER
					String passengerSql = "INSERT INTO passengers(passenger_name,age,gender) VALUES(?,?,?)";

					PreparedStatement passengerPs = con.prepareStatement(passengerSql, Statement.RETURN_GENERATED_KEYS);

					passengerPs.setString(1, name);
					passengerPs.setInt(2, age);
					passengerPs.setString(3, gender);

					passengerPs.executeUpdate();

					ResultSet generatedKeys = passengerPs.getGeneratedKeys();

					int passengerId = 0;

					if (generatedKeys.next()) {
						passengerId = generatedKeys.getInt(1);
					}

					// INSERT RESERVATION
					String reserveSql = "INSERT INTO reservations(passenger_id,train_id,journey_date) VALUES(?,?,?)";

					PreparedStatement reservePs = con.prepareStatement(reserveSql);

					reservePs.setInt(1, passengerId);
					reservePs.setInt(2, trainId);
					reservePs.setDate(3, Date.valueOf(date));

					reservePs.executeUpdate();

					// UPDATE SEATS
					String updateSql = "UPDATE trains SET available_seats=available_seats-? WHERE train_id=?";

					PreparedStatement updatePs = con.prepareStatement(updateSql);
					updatePs.setInt(1, count); 
					updatePs.setInt(2, trainId);

					updatePs.executeUpdate();
					
					if (special.toLowerCase().equals("yes")) {
						System.out.println("Total bill: "+count*special_price);
					}else {
						
						System.out.println("Total bill: "+count*price);
					}
					System.out.println("Ticket Booked Successfully!");

				} else {
					System.out.println("No Seats Available!");
				}

			} else {
				System.out.println("Train Not Found!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// VIEW RESERVATIONS
	public void viewReservations() {

		try {

			String sql = "SELECT r.reservation_id, p.passenger_name, t.train_name, r.journey_date "
					+ "FROM reservations r " + "JOIN passengers p ON r.passenger_id = p.passenger_id "
					+ "JOIN trains t ON r.train_id = t.train_id";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				System.out.println(rs.getInt("reservation_id") + " | " + rs.getString("passenger_name") + " | "
						+ rs.getString("train_name") + " | " + rs.getDate("journey_date"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// CANCEL TICKET
	public void cancelTicket() {

		try {

			System.out.println("Enter Reservation ID:");
			int reservationId = sc.nextInt();

			// GET TRAIN ID
			String getTrainSql = "SELECT train_id FROM reservations WHERE reservation_id=?";

			PreparedStatement getTrainPs = con.prepareStatement(getTrainSql);

			getTrainPs.setInt(1, reservationId);

			ResultSet rs = getTrainPs.executeQuery();

			if (rs.next()) {

				int trainId = rs.getInt("train_id");

				// DELETE RESERVATION
				String deleteSql = "DELETE FROM reservations WHERE reservation_id=?";

				PreparedStatement deletePs = con.prepareStatement(deleteSql);

				deletePs.setInt(1, reservationId);

				deletePs.executeUpdate();

				// UPDATE SEATS
				String updateSql = "UPDATE trains SET available_seats=available_seats+? WHERE train_id=?";

				PreparedStatement updatePs = con.prepareStatement(updateSql);
				updatePs.setInt(1, tickets); 
				updatePs.setInt(2, trainId);

				updatePs.executeUpdate();

				System.out.println("Ticket Cancelled Successfully!");

			} else {
				System.out.println("Reservation Not Found!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}