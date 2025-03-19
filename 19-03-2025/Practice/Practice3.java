package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Practice3{

	public static void main(String[] args) {
		
		
		//UPDATE QUERY
//	   String query = "UPDATE Users SET Username = 'RAJ3' WHERE UserId = ?;";
	   String query = "UPDATE Users SET Username = ?, gmail = ?, Userpass = ? WHERE UserId = ?;";

       
	try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","root");
		System.out.println("Connection established successfully..!!");
		

	    PreparedStatement ps = con.prepareStatement(query);
	    
	         //For UPDATE
	    ps.setString(1, "Rajesh");	  
	    ps.setString(2, "Rajesh@gmail.com");	
	    ps.setString(3, "Raj@123");	
	    ps.setInt(4,1001); 
	    int rows = ps.executeUpdate();

	    System.out.println(rows+ "row(s) affected");	
	    
	  } 
	catch (SQLException e) 
	   {
		e.printStackTrace();
	   }     
	}

}