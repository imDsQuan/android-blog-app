package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLConnUtils {

	public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException {
		String hostname = "localhost";
		String dbName ="store_online";
		String userName="root";
		String password = "123456";
		return getMySQLConnection(hostname, dbName, userName, password);
	}
	
	public static Connection getMySQLConnection(String hostname, String dbName,
			String userName, String password) throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connectionURL = "jdbc:mysql://" + hostname + ":3306/" + dbName;
			Connection connection = DriverManager.getConnection(connectionURL, userName, password);
			return connection;
	}
	

}
