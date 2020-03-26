package it.polito.tdp.esempioDBM.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBConnect { //Package
	public static Connection getConnection() throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=";
		return DriverManager.getConnection(jdbcURL);
	}
}
