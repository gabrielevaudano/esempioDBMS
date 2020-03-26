package it.polito.tdp.esempioDBM.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.esempioDBM.model.Station;

public class BabsDAO {
	public List<Station> listStation() {
		List<Station> result = new ArrayList<Station>();
		String sql = "SELECT station_id, name, dockcount, landmark FROM station";
		

		try {
			Connection conn = DBConnect.getConnection(); // (*1)
			
			PreparedStatement stn = conn.prepareStatement(sql); // metafora del tubo (conn) e navetta (st)

			ResultSet res = stn.executeQuery(); // Non va inserito (sql) qui
			
			while(res.next()) {
				Station s = new Station(res.getInt("station_id"), res.getString("name"), res.getInt("dockcount"), res.getString("landmark"));
				result.add(s);
			}
			
			res.close();
			stn.close();

			conn.close();
		} catch (SQLException e) {
			System.err.println("Si è verificato un errore: " + e);
		}
		return result;

	}
	
	public List<Station> listStationByLandmark(String landmark) {
		List<Station> result = new ArrayList<Station>();
		String sql = "SELECT station_id, name, dockcount, landmark FROM station WHERE landmark = ?";
		
		try {
			Connection conn = DBConnect.getConnection(); // (*1)

			PreparedStatement stn = conn.prepareStatement(sql); // metafora del tubo (conn) e navetta (st)
			stn.setString(1, landmark);
			
			ResultSet res = stn.executeQuery(); // Non va inserito (sql) qui
			
			while(res.next()) {
				Station s = new Station(res.getInt("station_id"), res.getString("name"), res.getInt("dockcount"), res.getString("landmark"));
				result.add(s);
			}
			
			res.close();
			stn.close();

			conn.close();
		} catch (SQLException e) {
			System.err.println("Si è verificato un errore: " + e);
		}
		return result;

	}
}
