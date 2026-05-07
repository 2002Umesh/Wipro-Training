package Sarthak_clinic;
 
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.*;
//import packages
//load & register driver
// establish connection
//create statements
//execute query
//process result
// close connection
public class jdbc_conn {
 
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		String url="jdbc:mysql://localhost:3306/mydatas";
		String user="root";
		String password="root";
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection(url,user,password);
		System.out.println("Connection created");
		//create statement
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("Select * from student");
		System.out.println("roll_no\t name\t      per\t   age");
		while(rs.next())
		{
			int roll_no=rs.getInt("roll_no");
			String name=rs.getString("name");
			float per=rs.getFloat("per");
			int age=rs.getInt("age");
			System.out.println(roll_no+"      "+ name+"        "+ per+"          "+ age);
			//System.out.println("ID:"+id+"\tName:"+ name+"Salary:"+ salary);
		}
		rs.close();
		stmt.close();
		con.close();
		
		
 
	}
 
}
 
 