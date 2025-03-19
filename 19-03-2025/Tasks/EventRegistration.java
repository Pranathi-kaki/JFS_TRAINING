package Tasks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EventRegistration {

	public static void main(String[] args) {
		System.out.println("Welcome to the Event 'TECH GALAXY'\\n");
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Registration for new user.\r\n"
				+ "2.Edit your existing Account Details.\r\n"
				+ "3.Delete existing user\r\n"
				+ "ENTER THE OPTION 1/2/3 FOR MOVING AHEAD...!!");
       int option = sc.nextInt();
	
		System.out.println("Enter the Reg Number:  ");
		int RegNO = sc.nextInt();
		String query = "SELECT * FROM Records WHERE RegNO ='" + RegNO + "'";
		String url = "jdbc:mysql://localhost:3306/EventRegistration";
			try {
				Connection con = DriverManager.getConnection(url,"root","root");
				System.out.println("Connection established successfully..!!!");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				if(option==1) {
					if(rs.next()) {
						System.out.println("User Already Exist!!! ");
					}
					else {
						System.out.println("Enter the College Name : ");
						String CollegeName = sc.next();
						System.out.println("Enter the Event Name : ");
						String EventName = sc.next();
						System.out.println("Enter the Participant Name : ");
						String Participants = sc.next();
						System.out.println("Enter the MailId : ");
						String MailId = sc.next();
						System.out.println("Enter the Contact Number : ");
						String ContactNumber = sc.next();
						System.out.println("Enter the Team Name : ");
						String TeamName = sc.next();
						
						String query1 = "INSERT INTO Records(RegNO,CollegeName,EventName,Participants,MailId,ContactNumber,TeamName) VALUES ('"+ RegNO + "','"+ CollegeName + "','"+ EventName + "','"+Participants + "','"+ MailId + "','"+ ContactNumber + "','"+ TeamName + "');";
						int rowsAffect = st.executeUpdate(query1);
						
						if(rowsAffect > 0) {
							System.out.println("Account created successfully...");
						}
						else {
							System.out.println("Failed to create the account");
						}
					}
				}
				else if(option==2){
					if(rs.next()) {
						System.out.println("Welcome Back!!! ");
						System.out.println("Select an option if You want to do Updation\n\n"+
						                   "1.Want to change the college name\n"+
								           "2.Want to change the Event Name\n"+
								           "3.Want to change the Team Name"+
						                   "4.Want to change the Praticipant Name\n"+
						                   "5.Want to change the Email ID\n"+
								           "6.Want to change the Contact Number\n"
								           );
						int res = sc.nextInt();
	
						if(res==1) {
							String query1 = "UPDATE Records SET CollegeName = ? WHERE RegNO = ?;";	
							PreparedStatement ps = con.prepareStatement(query1);
							System.out.println("Enter the College Name: ");
							String clgName = sc.next();
					         //For UPDATE
					       ps.setString(1, clgName);	  
					       ps.setInt(2, RegNO);	
					       int rowsAffect = ps.executeUpdate();
					       if(rowsAffect > 0) {
							  System.out.println("College Name Updated...");
						   }
					    	else {
							System.out.println("Could not Update!!");
						   }
					    }
						
	     //update the Event Name				
						else if(res ==2) {
							String query1 = "UPDATE Records SET EventName = ? WHERE RegNO = ?;";	
							PreparedStatement ps = con.prepareStatement(query1);
							System.out.println("Enter the Event Name to Update: ");
							String eventname = sc.next();
					         //For UPDATE
					       ps.setString(1, eventname);	  
					       ps.setInt(2, RegNO);	
					       int rowsAffect = ps.executeUpdate();
					       if(rowsAffect > 0) {
							  System.out.println("Event Name Updated...");
						   }
					    	else {
							System.out.println("Could not Update!!");
						   }
						}
					
		//update the Team Name				
						else if(res ==3) {
							String query1 = "UPDATE Records SET TeamName = ? WHERE RegNO = ?;";	
							PreparedStatement ps = con.prepareStatement(query1);
							System.out.println("Enter the Team Name to Update: ");
							String teamname = sc.next();
					         //For UPDATE
					       ps.setString(1, teamname);	  
					       ps.setInt(2, RegNO);	
					       int rowsAffect = ps.executeUpdate();
					       if(rowsAffect > 0) {
							  System.out.println("Team Name Updated...");
						   }
					    	else {
							System.out.println("Could not Update!!");
						   }
						}	
		//update the Participant Name				
						else if(res ==4) {
							String query1 = "UPDATE Records SET Participants = ? WHERE RegNO = ?;";	
							PreparedStatement ps = con.prepareStatement(query1);
							System.out.println("Enter the participants Name to Update: ");
							String participants = sc.next();
					         //For UPDATE
					       ps.setString(1, participants);	  
					       ps.setInt(2, RegNO);	
					       int rowsAffect = ps.executeUpdate();
					       if(rowsAffect > 0) {
							  System.out.println("Participant Name Updated...");
						   }
					    	else {
							System.out.println("Could not Update!!");
						   }
						}
						
		//update the mail id				
						else if(res ==5) {
							String query1 = "UPDATE Records SET MailId = ? WHERE RegNO = ?;";	
							PreparedStatement ps = con.prepareStatement(query1);
							System.out.println("Enter the Mail Id  to Update: ");
							String MailId = sc.next();
					         //For UPDATE
					       ps.setString(1, MailId);	  
					       ps.setInt(2, RegNO);	
					       int rowsAffect = ps.executeUpdate();
					       if(rowsAffect > 0) {
							  System.out.println("MailId Updated...");
						   }
					    	else {
							System.out.println("Could not Update!!");
						   }
						}
			//update the contact number				
						else if(res ==6) {
							String query1 = "UPDATE Records SET ContactNumber = ? WHERE RegNO = ?;";	
							PreparedStatement ps = con.prepareStatement(query1);
							System.out.println("Enter the Contact Number  to Update: ");
							String ContactNumber = sc.next();
					         //For UPDATE
					       ps.setString(1, ContactNumber);	  
					       ps.setInt(2, RegNO);	
					       int rowsAffect = ps.executeUpdate();
					       if(rowsAffect > 0) {
							  System.out.println("Contact Number Updated...");
						   }
					    	else {
							System.out.println("Could not Update!!");
						   }
						}
					}
					else {
						System.out.println("You are not the registered User SORRY!!!");
					}
				}
				else {
					if(rs.next()) {
						System.out.println("Welcome Back to TECH GALAXY !!! ");
						String query2 = "DELETE FROM Records WHERE RegNO = ?;";
						PreparedStatement ps = con.prepareStatement(query2);
						System.out.println("Enter the Register Number to be deleted: ");
						int registernum = sc.nextInt();
					       ps.setInt(1, registernum);	
					       int rowsAffect = ps.executeUpdate();
					       if(rowsAffect > 0) {
							  System.out.println("Record deleted successfully...");
						   }
					    	else {
							System.out.println("Could not Delete!!");
						   }
				    }
					else {
						System.out.println("You are not the registered User SORRY!!!");
					}
			     }
			}
					catch (SQLException e){
						e.printStackTrace();
				   } 
	} 

}

	

