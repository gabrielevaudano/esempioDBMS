package it.polito.tdp.esempioDBM.model;

import java.sql.*;

public class LeggiBabs {
	public void run() {
		// Step 1: declare the link to connection
		String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=";
		
		
		// (*1) FACTORY PATTERN: creazione di un oggetto della classe, senza
		// sapere il tipo della classe (non posso dunque usare "New")
		// Uso invece un metodo fornito da un'altra classe, che internamente
		// farà "new" e conoscerà il tipo di classe effettivo.
		
		// Chiediamo ad un oggetto di crearne un altro
		try {
			// Step 2: create the connection
			Connection conn = DriverManager.getConnection(jdbcURL); // (*1)
			
			//Step 3: prepare for statement and SQL CODE (not used at all, actually)
			Statement st = conn.createStatement(); // metafora del tubo (conn) e navetta (st)
			String sql="SELECT NAME FROM station";
			// For this -> preferrable Prepared Statements
			
			// Step 4: ask for at DBMS
			ResultSet res = st.executeQuery(sql);
			// Continuo ad utilizzare un pattern factory (da-a)
			// ExecuteUpdate: INSERT, UPDATE or DELETE
			// ExecuteQuery: SELECT
			// execute: other queries on DBMS
			
			// Contiene il modo per poter ottenere il risultato
			
			// Step 5: process the result
			while(res.next()) {
				String nomeStazione = res.getString("name");
				System.out.println(nomeStazione);
				// Funziona anche se la query non restituisce nemmeno un risultato
			}
			// Il cursore ha vari metodi
			// Conviene chiudere quando finisce, perchè così libera risorese
			res.close();
			st.close();
			
			// Posso fare viaggiare un nuovo statement
			// Step 6
			conn.close();
		} catch (SQLException e) {
			System.err.println("Si è verificato un errore: " + e);
		}
		
		// ALWAYS USE PREPARED STATEMENTS
	}
	
	public void main(String args[]) {
		LeggiBabs babs = new LeggiBabs();
		babs.run();
	}
	
	
}
