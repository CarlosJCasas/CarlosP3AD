package modelo.facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	private final static String DBDIR ="jdbc:postgresql://localhost:5432/alumnado";
	private final static String USER = "admin";
	private final static String PASS ="admin1234";
	private static Connection connection;
	
	
	public static Connection getConnection() throws SQLException {
		if(connection==null || connection.isClosed()){
			connection= DriverManager.getConnection(DBDIR, USER, PASS);
		}
		return connection;
	}
}
