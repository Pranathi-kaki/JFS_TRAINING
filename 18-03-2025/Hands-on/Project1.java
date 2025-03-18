package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Project1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Mail ID :  ");
		String mail = sc.next();
		String query = "SELECT * FROM User_Data WHERE gmail ='" + mail + "'";
		String url = "jdbc:mysql://localhost:3306/testdb";
		try {
			Connection con = DriverManager.getConnection(url,"root","root");
			System.out.println("Connection established successfully..!!!");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()) {
				String pass = rs.getString("pass");
				System.out.println("Enter the password: ");
				String password = sc.next();
				
				if(password.equals(pass)) {
					System.out.println("Welcome back "+rs.getInt("ID"));
				}
				else {
					System.out.println("Incorrect password...!!!");
				}
				
			}
			else {
				System.out.println("User not found..!!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(mail);

	}

}
