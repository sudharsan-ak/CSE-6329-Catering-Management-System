package Project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
	private static String DB_DRIVER;
	private static String DB_CONNECTION;
	private static String DB_USER;
	private static String DB_PASSWORD; 
	private static SQLConnection single_instance = null;
	private SQLConnection() {
		DB_DRIVER = "com.mysql.cj.jdbc.Driver";
		DB_CONNECTION  = "jdbc:mysql://localhost:3306/catering?autoReconnect=true&verifyServerCertificate=false&useSSL=true";
		DB_USER  = "root";
		DB_PASSWORD = "clarine9";
	}
	public static synchronized SQLConnection getInstance() {
        if (single_instance == null)
        	single_instance = new SQLConnection();
        return single_instance;
	}

	public static Connection getDBConnection() {	
		Connection dbConnection = null;	 

		try {	 
			Class.forName(DB_DRIVER);	 
		} catch (ClassNotFoundException e) {}

		try {	 
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
			dbConnection.setAutoCommit(false);
		} catch (SQLException e) {}	 
		return dbConnection;	 
	}
}
