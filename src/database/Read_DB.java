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
    private static String[] loginResultSet = new String[] {"","","","","","",""};
    //private static String[] status = new String[7];
	/*
	 Outputs the author, ID, and URL of the current
	 author in the ResultSet
	*/


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
	public static String[] findUser(String email) {
		
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
			System.out.println("All records with an ID = " + email);
			
			rs = s.executeQuery("SELECT name , address , email , phone_number , status , license_plate , parking_lot , period , duration , cost , userID  " +
					"FROM ParkingManagement WHERE email = '" + email+"'" );
			
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
	public static String[] findStatus(String email, String password) {
		
		
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
			
			
			rs = s.executeQuery("SELECT * FROM UserInfo WHERE userEmail = '" + email +"'");
				
			
			while( rs.next() )
			{
					System.out.println("here");
					checkingStatus(rs, password, email);
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
	
        return loginResultSet;
	}
	
	@SuppressWarnings("deprecation")
	public static String[] guestFindStatus(String email) {
		
		
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
			
			System.out.println(email);
			rs = s.executeQuery("SELECT * FROM UserInfo WHERE userEmail = '" + email +"'");
				
			System.out.println(rs);
			while( rs.next() )
			{
					System.out.println("here");
					guestCheckingStatus(rs, email);
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
	
        return loginResultSet;
	}
	
			  
	public static void checkingStatus(ResultSet rs, String inputPassword, String inputEmail) throws SQLException
	{
		int loginID = rs.getInt("loginID");
		String userName = rs.getString("userName");
	    String userEmail = rs.getString("userEmail");
	    String userPhoneNumber = rs.getString("userPhoneNumber");
	    String userAddress = rs.getString("userAddress");
	    String userPassword = rs.getString("userPassword");
	    String userStatus =  rs.getString("userStatus");
	    
	    
	    if((inputEmail.compareTo(userEmail) == 0) && (inputPassword.compareTo(userPassword)==0 ) ) {
	    	
	    	loginResultSet[0] = Integer.toString(loginID);
	    	loginResultSet[1] = userName;
	    	loginResultSet[2] = userEmail;
	    	loginResultSet[3] = userPhoneNumber;
	    	loginResultSet[4] = userAddress;
	    	loginResultSet[5] = userPassword;
	    	loginResultSet[6] = userStatus;
			
	    	System.out.println(loginResultSet[6]);
	    	
	    }
		
	}
	
	public static void guestCheckingStatus(ResultSet rs, String inputEmail) throws SQLException
	{
		//int loginID = rs.getInt("loginID");
		//String userName = rs.getString("userName");
	    String userEmail = rs.getString("userEmail");
	    //String userPhoneNumber = rs.getString("userPhoneNumber");
	    //String userAddress = rs.getString("userAddress");
	    //String userPassword = rs.getString("userPassword");
	    String userStatus =  rs.getString("userStatus");
	    

	    System.out.println(inputEmail); //Delete
	    System.out.println(userEmail); //Delete
	    
	    if(inputEmail.compareTo(userEmail) == 0 ) {
	    	
	    	//loginResultSet[0] = Integer.toString(loginID);
	    	//loginResultSet[1] = userName;
	    	loginResultSet[2] = userEmail;
	    	//loginResultSet[3] = userPhoneNumber;
	    	//loginResultSet[4] = userAddress;
	    	//loginResultSet[5] = userPassword;
	    	loginResultSet[6] = userStatus;
			
	    	System.out.println(loginResultSet[6]);
	    	
	    }
		
	}
	
	
}