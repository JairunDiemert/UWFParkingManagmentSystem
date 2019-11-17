package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import models.User_Info;

public class Update_DB
{

	private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String protocol = "jdbc:derby:";
    private static int manualy_increment = 4; 

	public void addNewUserInfo(User_Info user, String plate, String period, String duration, String lot, double cost )
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
					+ "' , '" + user.getUserInfo() + "' , '" + plate + "' , '" + lot + "' , '" + duration + "' , '" + period + "' , " + cost + " , " + manualy_increment
					+ ")");
			
			manualy_increment++;

			//System.out.println("URL changed to " + newURL);
			
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