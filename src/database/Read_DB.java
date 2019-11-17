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
		int USER_ID = rs.getInt("USER_ID");
		
		
		
		System.out.println("Name = " + name + "\nAddress = "
				+ address + "\nEmail = " + email );
		
		System.out.println("Phone Number = " + phone_number + "\nSatus = "
				+ status + "\nlLicense Plate = " + license_plate );
		
		System.out.println("Parking Lot = " + parking_lot + "\nPeriod = "
				+ period + "\nDuration = " + duration);
		
		System.out.println("Cost = " + cost + "\nUSER_ID = "
				+ USER_ID );
	}

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
					+ " period , duration , cost , USER_ID FROM ParkingManagement");
			System.out.println("Hello");
			
			
			while( rs.next() )
			{
				displayNameRecord(rs);
			}
			rs.close();

			System.out.println();
			System.out.println("All records with an ID > 1:");
			rs = s.executeQuery("SELECT name , address , email , phone_number , status , license_plate , parking_lot , period , duration , cost , USER_ID " +
					"FROM ParkingManagement WHERE USER_ID > 1");
			
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
}