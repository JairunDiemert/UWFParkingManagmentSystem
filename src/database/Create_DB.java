package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

public class Create_DB
{
	private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String protocol = "jdbc:derby:";

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
			System.out.println("Connecting to and creating the database...");
        	conn = DriverManager.getConnection(protocol + dbName + ";create=true");
			System.out.println("Database created.");

			
			Statement s = conn.createStatement();
				
			
			
			//s.execute("DROP Table ParkingManagement");
			
			/*s.execute("CREATE TABLE ParkingManagement" +
					  "(name varchar(50), address varchar(50), email varchar(50),phone_number varchar(50),"
					  + "status varchar(50), license_plate varchar(50), parking_lot varchar(50), period varchar(50), duration varchar(50), "
					  + "cost double, userID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 70000000, INCREMENT BY 1),UNIQUE(userID))");
			
			s.execute("INSERT INTO ParkingManagement " +
					"VALUES ('YL', 'fdsj St', 'yl@student.uwf.edu', '324-4324', 'Student', 'fjdisof', 'A', '1', 'Semester', 50,DEFAULT)");
			s.execute("INSERT INTO ParkingManagement " +
					"VALUES ('GM', 'fdfsfsft', 'gm@student.uwf.edu', '234-4324', 'Military', 'fdsff', 'B', '2', 'Semester', 45, DEFAULT)");
			*/
			
			/*s.execute("CREATE TABLE LoginInfo" +
			  "(userID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), userName varchar(100), userPassword varchar(100),"
			  + "userEmail varchar(100), userStatus char(1), UNIQUE(userID) )");
	
			s.execute("INSERT INTO LoginInfo " +
			"VALUES (DEFAULT, 'YL', 'GuessWhat', 'yl@students.uwf.edu', 'S')");*/
			
			//s.execute("DROP TABLE GuestInfo");
			
			/*s.execute("CREATE TABLE GuestInfo" +
			  "(userID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 90000000, INCREMENT BY 1), userEmail varchar(100), userPlate varchar(100), userLot char(1),period varchar(50), duration varchar(50),"
			  + " userStartTime DATE, userEndTime DATE ,cost double, UNIQUE(userID,userEmail) )");*/
	
			
			/*s.execute("INSERT INTO GuestInfo " +
			"VALUES (DEFAULT, 'ds@students.uwf.edu', 'plateNum', 'A', '1', 'Semester', '03/25/2019', '03/25/2020' , 20 )");*/
			
			System.out.println("Done");
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

