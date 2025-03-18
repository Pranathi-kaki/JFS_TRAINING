package Package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Practice1 {
	public static void main(String args[]) {
//		String query = "SELECT * FROM User_Data WHERE ID = 1";
//		String query = "SELECT * FROM User_Data";
		String query = "SELECT gmail,pass FROM User_Data";



		String url = "jdbc:mysql://localhost:3306/testdb";
		String user = "root";
		String pass = "root";
		
//		driver manager is used to connect mysql and java so we call driver manager class
//		driver manager is a class and connection is an interface
		
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("Connection established successfully...!!!");
			
			Statement st = con.createStatement();
			st.executeQuery(query); 
			//request to execute the query
			//executeQuery return result as result set
			
			ResultSet rs =st.executeQuery(query);
			while(rs.next()) {     //moves to the next row    rs -->gives data in the form of objects
				
//				int id = rs.getInt("ID");
				String email = rs.getString("gmail");
				String password = rs.getString ("pass");
//				System.out.println(id + " " + email + " " + password);
				System.out.println( email + "    " + password);
			};           
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
