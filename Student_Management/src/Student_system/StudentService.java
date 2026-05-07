package Student_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;



public class StudentService {
	
	Scanner sc = new Scanner(System.in);

	Connection con;

	public StudentService() {

		try {

			con = DBConnection.getConnection();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public void viewStudents() {
		try {

			String sql = "SELECT * FROM student";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				System.out.println(
						rs.getInt("roll_no") + " | " + rs.getString("name") + " | " + rs.getString("email")
								+ " | age: " + rs.getInt("age"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addStudents() {
		try {
			System.out.println("Enter roll no: ");
			int rollno = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter name: ");
			String name = sc.nextLine();
			
			System.out.println("Enter email: ");
			String email = sc.nextLine();
			
			System.out.println("Enter age: ");
			int age = sc.nextInt();
			
			String addSQL = "INSERT INTO student VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(addSQL);
			
			ps.setInt(1, rollno);
			ps.setString(2, name);
	        ps.setString(3, email);
	        ps.setInt(4, age);
			
			int row = ps.executeUpdate();
			
			if (row>0) {
				System.out.println("New student data added");
			}else {
				System.out.println("Invalid data!!!");
			}
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
