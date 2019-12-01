package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Read_DB
{
	private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String protocol = "jdbc:derby:";
    private static String[] resultSet = new String[11]; 
    private static String[] loginResultSet = new String[5];
	/*
	 Outputs the author, ID, and URL of the current
	 author in the ResultSet
	*/
	public static void displayNameRecord(ResultSet rs) throws SQLException
	{
		String name = rs.getString("name");
		String address = rs.getString("address");
		String email = rs.getString("email");
		
		String phone_number = rs.getString("phone_number");
		String status = rs.getString("status");
		String license_plate = rs.getString("license_plate");
		
		String parking_lot = rs.getString("parking_lot");
		String period = rs.getString("period");
		String duration = rs.getString("duration");
		
		Double cost = rs.getDouble("cost");
		int USER_ID = rs.getInt("userID");
		
		
		
		System.out.println("Name = " + name + "\nAddress = "
				+ address + "\nEmail = " + email );
		
		System.out.println("Phone Number = " + phone_number + "\nSatus = "
				+ status + "\nlLicense Plate = " + license_plate );
		
		System.out.println("Parking Lot = " + parking_lot + "\nPeriod = "
				+ period + "\nDuration = " + duration);
		
		System.out.println("Cost = " + cost + "\nUSER_ID = "
				+ USER_ID );
	}

	private static void passingRecord(ResultSet rs) throws SQLException
	{
		resultSet[0] =  rs.getString("name");
		resultSet[1] = rs.getString("address");
		resultSet[2] = rs.getString("email");
		
		resultSet[3] = rs.getString("phone_number");
		resultSet[4] = rs.getString("status");
		resultSet[5] = rs.getString("license_plate");
		
		resultSet[6] = rs.getString("parking_lot");
		resultSet[7] = rs.getString("period");
		resultSet[8] = rs.getString("duration");
		
		resultSet[9] = String.valueOf(rs.getDouble("cost"));
		resultSet[10] = String.valueOf(rs.getInt("userID"));
		
		
		 
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
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

			ResultSet rs = null;
			System.out.println("All records:");
			rs = s.executeQuery("SELECT name, address , email , phone_number , status , license_plate , parking_lot,"
					+ " period , duration , cost , userID FROM ParkingManagement");
			System.out.println("Hello");
			
			
			while( rs.next() )
			{
				displayNameRecord(rs);
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
	}
	
	@SuppressWarnings("deprecation")
	public static String[] findUser(int id) {
		
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

			ResultSet rs = null;
			
			System.out.println();
			System.out.println("All records with an ID = " + id);
			rs = s.executeQuery("SELECT name , address , email , phone_number , status , license_plate , parking_lot , period , duration , cost , userID  " +
					"FROM ParkingManagement WHERE userID = " + id );
			
			while( rs.next() )
			{
				passingRecord(rs);
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
	
        return resultSet;
	}
	
	@SuppressWarnings("deprecation")
	public static char findStatus(String email, String password) {
		
		char status = 'N';
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

			ResultSet rs = null;
			
			System.out.println();
			//System.out.println("All records with an ID = " + id);
			/*s.execute("CREATE TABLE LoginInfo" +
					  "(userID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), userName varchar(100), userPassword varchar(100),"
					  + "userEmail varchar(100), userStatus char(1), UNIQUE(userID) )");*/
			
			rs = s.executeQuery("SELECT * FROM LoginInfo WHERE userEmail = '" + email +"'");
			//rs = s.executeQuery("SELECT userID , userName , userPassword , userEmail ,userStatus FROM ParkingManagement WHERE userEmail = '" + email +"'");
			
			if(rs!= null) {
			
				while( rs.next() )
				{
				
					status = checkingStatus(rs);
				}
			}
			else {
				
				status = 'N';
				
			}
			System.out.println("Done");
			
			rs.close();
			conn.close();
        }
        catch (SQLException err)
		{
			System.err.println("SQL error.");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	
        return status;
	}
	
	public static char checkingStatus(ResultSet rs) throws SQLException
	{
		/*int USER_ID = rs.getInt("userID");
		String name = rs.getString("userName");
		String password = rs.getString("userPassword");
		String email = rs.getString("userEmail");*/
		
		char status =  rs.getString("userStatus").charAt(0);
	    System.out.println(status);
		return status;
	}
}