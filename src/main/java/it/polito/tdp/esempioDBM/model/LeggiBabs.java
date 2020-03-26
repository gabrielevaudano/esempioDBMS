package it.polito.tdp.esempioDBM.model;
import java.util.*;

import it.polito.tdp.esempioDBM.SQL.BabsDAO;

public class LeggiBabs {
	public void run() {
		BabsDAO dao = new BabsDAO();
		List<Station> tutte = dao.listStation();
		
		for (Station a : tutte)
			System.out.println(a.getName());
		
		List<Station> tutteL = dao.listStationByLandmark("Palo Alto");
		
		for (Station a : tutteL)
			System.out.println(a.getName());
	}
	
	public static void main(String args[]) {
		LeggiBabs babs = new LeggiBabs();
		babs.run();
	}
	
	
}
