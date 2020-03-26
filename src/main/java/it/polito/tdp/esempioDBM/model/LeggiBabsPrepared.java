package it.polito.tdp.esempioDBM.model;
import java.sql.*;

public class LeggiBabsPrepared {
	public void run() {
		String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=";

		try {
			Connection conn = DriverManager.getConnection(jdbcURL); // (*1)

			String sql="SELECT name FROM station WHERE landmark = ? ";
			
			PreparedStatement stn = conn.prepareStatement(sql); // metafora del tubo (conn) e navetta (st)
			stn.setString(1, "Palo Alto");

			ResultSet res = stn.executeQuery(); // Non va inserito (sql) qui
			
			
			while(res.next()) {
				String nomeStazione = res.getString("name");
				System.out.println(nomeStazione);
			}
			
			res.close();
			stn.close();

			conn.close();
		} catch (SQLException e) {
			System.err.println("Si è verificato un errore: " + e);
		}
	}
		
	public static void main(String args[]) {
		LeggiBabsPrepared babs = new LeggiBabsPrepared();
		babs.run();
	}
}
