package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_DB
{
	private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String protocol = "jdbc:derby:";

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
			System.out.println("Connecting to and creating the database...");
        	conn = DriverManager.getConnection(protocol + dbName + ";create=true");
			System.out.println("Database created.");

			
			Statement s = conn.createStatement();
			/*s.execute("CREATE TABLE names" +
					  "(author varchar(50), author_id int, url varchar(80))");*/
			
			/*s.execute("CREATE TABLE ParkingManagement" +
					  "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
					  "(name varchar(50))");*/
			
			
			
			s.execute("CREATE TABLE ParkingManagement" +
					  "(name varchar(50), address varchar(50), email varchar(50),phone_number varchar(50),"
					  + "status varchar(50), license_plate varchar(50), parking_lot varchar(50), period varchar(50), duration varchar(50), "
					  + "cost double, USER_ID INTEGER )");
			
			System.out.println("Created 'ParkingManagement' table.");

			/*s.execute("INSERT INTO ParkingManagement(name) " +
					"VALUES ('YL')");*/
			
			s.execute("INSERT INTO ParkingManagement " +
					"VALUES ('YL', 'fdsj St', 'yl@student.uwf.edu', '324-4324', 'Student', 'fjdisof', 'A', '1', 'Semester ', 50,1)");
			s.execute("INSERT INTO ParkingManagement " +
					"VALUES ('YL', 'fdsj St', 'yl@student.uwf.edu', '324-4324', 'Student', 'fjdisof', 'A', '1', 'Semester ', 50,2)");
			System.out.println("Done' table.");
			
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

