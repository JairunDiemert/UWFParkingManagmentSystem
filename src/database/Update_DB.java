package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import models.User_Info;

@SuppressWarnings("unused")
public class Update_DB
{

	private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String protocol = "jdbc:derby:";
    private static int id = 0;
    private static int loginID = 0;

	@SuppressWarnings("deprecation")
	public int addNewUserInfo(User_Info user, String plate, String period, String duration, String lot, double cost )
	{
		try
		{
			Class.forName(driver).newInstance();
			System.out.println("Loaded the embedded driver.");
		}
		catch (Exception err)
		{
			System.err.println("Unable to load the embedded driver.");
			err.printStackTrace(System.err);
			System.exit(0);
        }
        String dbName = "ParkingManagementDB";
        Connection conn = null;
        try
        {
			System.out.println("Connecting to the database...");
        	conn = DriverManager.getConnection(protocol + dbName);
			System.out.println("Connected.");
			
			Statement s = conn.createStatement();
		
			
			s.execute("INSERT INTO ParkingManagement " +
					"VALUES ('" + user.getUserName() + "',' " + user.getUserAddress()  + "' , '" + user.getUserEmail() + "' , '" + user.getUserPhoneNum()
					+ "' , '" + user.getUserInfo() + "' , '" + plate + "' , '" + lot + "' , '" + duration + "' , '" + period + "' , " + cost + " , default)");
			
			ResultSet rs = null;
			rs = s.executeQuery("SELECT userID FROM ParkingManagement WHERE email = '" + user.getUserEmail() +"'");

			
			
			if(rs!= null) {
				
				while( rs.next() )
				{
					id = getID(rs);
					
				}
			}
			
			
			rs.close();
			conn.close();
		}
		catch (SQLException err)
		{
			System.err.println("SQL error.");
			err.printStackTrace(System.err);
			System.exit(0);
		}
        
        return id; 
	}
	
	public static int getID(ResultSet rs) throws SQLException
	{
		
		
		int status =  rs.getInt("userID");
	    System.out.println(status);
		return status;
	}
	
	@SuppressWarnings("deprecation")
	public void updateUserInfo(int id, User_Info user)
	{
		try
		{
			Class.forName(driver).newInstance();
			System.out.println("Loaded the embedded driver.");
		}
		catch (Exception err)
		{
			System.err.println("Unable to load the embedded driver.");
			err.printStackTrace(System.err);
			System.exit(0);
        }
        String dbName = "ParkingManagementDB";
        Connection conn = null;
        try
        {
			System.out.println("Connecting to the database...");
        	conn = DriverManager.getConnection(protocol + dbName);
			System.out.println("Connected.");
			
			Statement s = conn.createStatement();
			
			
			s.execute("UPDATE ParkingManagement SET name = '" 
					+ user.getUserName() + "', address = '" 
					+ user.getUserAddress() + "', email = '" 
					+ user.getUserEmail() + "', phone_number = '" 
					+ user.getUserPhoneNum() + "'  WHERE USER_ID = " + id );
			System.out.println("Table Updated");
			
			conn.close();
		}
		catch (SQLException err)
		{
			System.err.println("SQL error.");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	public void insertUserInfo(User_Info user)
	{
		
		
		try
		{
			Class.forName(driver).newInstance();
			System.out.println("Loaded the embedded driver.");
		}
		catch (Exception err)
		{
			System.err.println("Unable to load the embedded driver.");
			err.printStackTrace(System.err);
			System.exit(0);
        }
        String dbName = "ParkingManagementDB";
        Connection conn = null;
        try
        {
			System.out.println("Connecting to the database...");
        	conn = DriverManager.getConnection(protocol + dbName);
			System.out.println("Connected.");
			
			Statement s = conn.createStatement();
			
			System.out.println(user.getUserName() );
			System.out.println(user.getUserEmail());
			System.out.println(user.getUserPhoneNum());
			System.out.println(user.getUserAddress());
			System.out.println(user.getUserPassword());
			System.out.println(user.getUserInfo() );
			
			
			s.execute("INSERT INTO UserInfo " +
					"VALUES (default,'" + user.getUserName() + "',' " + user.getUserEmail()  + "' , '" + user.getUserPhoneNum() + "' , '" + 
					user.getUserAddress() + "' , '" + user.getUserPassword()  + "' , '" + user.getUserInfo() +"' )");
			
			
			
		
		
			
			System.out.println("user inserted");
			
			conn.close();
		}
		catch (SQLException err)
		{
			System.err.println("SQL error.");
			err.printStackTrace(System.err);
			System.exit(0);
		}
        
       
	}
	

}