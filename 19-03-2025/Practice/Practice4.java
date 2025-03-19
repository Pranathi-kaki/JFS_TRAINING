package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Practice4 {

	public static void main(String[] args) {
		
		//SELECT all Query
	   String query = "SELECT * FROM Users;";
       
	try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","root");
		System.out.println("Connection established successfully..!!");
		

	    PreparedStatement ps = con.prepareStatement(query);
	    ResultSet rs = ps.executeQuery();
	    while(rs.next()) {
	    	 System.out.println(rs.getInt("UserId")+ " "+
	                        rs.getString("Username")+" "+
	    			        rs.getString("gmail")+" "+
	    			        rs.getString("Userpass"));	
	    }
	    	    
	  } 
	catch (SQLException e) 
	   {
		e.printStackTrace();
	   }     
	}

}