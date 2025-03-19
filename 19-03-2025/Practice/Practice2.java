package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Practice2 {

	public static void main(String[] args) {
		
		//DELETE Query
	   String query = "DELETE FROM Users WHERE UserId = ?;";
		       
	try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","root");
		System.out.println("Connection established successfully..!!");
		

	    PreparedStatement ps = con.prepareStatement(query);
	    
	    ps.setInt(1,1002);   
	        
	    int rows = ps.executeUpdate();

	    System.out.println(rows+ "row(s) affected");	
	    
	  } 
	catch (SQLException e) 
	   {
		e.printStackTrace();
	   }     
	}

}