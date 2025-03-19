package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Practice5 {

	public static void main(String[] args) {
		
		//DELETE Query
	   String query = "SELECT * FROM Users;";
       
	try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","root");
		System.out.println("Connection established successfully..!!");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		ResultSetMetaData meta = rs.getMetaData();
		System.out.println("Column count = "+meta.getColumnCount());
		System.out.println("Column Name at 3 = "+meta.getColumnName(3));
		System.out.println("Column Type Name at 1 = "+ meta.getColumnTypeName(1));
		System.out.println("Table Name at 1= "+meta.getTableName(1));
		
	  } 
	catch (SQLException e) 
	   {
		e.printStackTrace();
	   }     
	}

}
