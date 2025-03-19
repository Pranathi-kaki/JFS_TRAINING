package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Statement;

public class practice1 {

	public static void main(String[] args) {
		
//	   String username = "Pranathi",gmail = "kpranathi639@gmail.com",userpass = "1231";
//	   String query = "INSERT INTO Users (Username,gmail,Userpass) VALUES ('"+ username +"','" + gmail  +"','"+userpass+"')";
		
	   String query = "INSERT INTO Users (Username,gmail,Userpass) VALUES(? ,? ,?)";
       
	try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","root");
		System.out.println("Connection established successfully..!!");
		
//	    Statement st  = con.createStatement();

	    PreparedStatement ps = con.prepareStatement(query);
	    
	    ps.setString(1,"Pranathi");
	    ps.setString(2,"kpranathi639@gmail.com");
	    ps.setString(3,"Prani@!12");
	    
	    //we also have setInt(),setFloat(),setString() etc...
	    
	    int rows = ps.executeUpdate();

//	    int rows = st.executeUpdate(query);
	    System.out.println(rows+ "row(s) affected");
	    
	    
	} catch (SQLException e) {
		e.printStackTrace();
	}
      
	}

}
