package Data;

import java.sql.*;
import java.util.ArrayList;

import Basic_Class.Contrat;
import Basic_Class.Poubelle;

public class ContratData {
	 
	
	public void NewContrat(Contrat p) {
		    Connection dbConnection = null;
		    PreparedStatement stmt = null;
		    
		    try {
		        Data_Source datasource = new Data_Source();
		        dbConnection = datasource.createConnection();

		        String sql = "INSERT INTO `contrat`(`nom`, `adrese`, `date_debut`, `date_fin`) VALUES (?, ?, ?, ?)";
		        stmt = dbConnection.prepareStatement(sql);
		        stmt.setString(1, p.getCommerceNom());
		        stmt.setString(2, p.getCommerceadresse());
		        stmt.setDate(3, p.getDate_debut());
		        stmt.setDate(4, p.getDate_fin());

		        stmt.executeUpdate();
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    } finally {
		        // Fermeture des ressources JDBC
		        try { stmt.close(); 
		        }
		        catch (Exception e) { 
		        	
		        }
		        try { dbConnection.close(); 
		        } catch (Exception e) { 
		        	
		        }
		    }
		}
	
	public void getAllContrats(ArrayList<Contrat> contrats) {
	    
	    Connection dbConnection = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    
	    try {
	        Data_Source datasource = new Data_Source();
	        dbConnection = datasource.createConnection();

	        String sql = "SELECT * FROM `contrat`";
	        stmt = dbConnection.prepareStatement(sql);
	        rs = stmt.executeQuery();

	        while (rs.next()) {
	            String nom = rs.getString("nom");
	            String adresse = rs.getString("adrese");
	            Date date_debut = rs.getDate("date_debut");
	            Date date_fin = rs.getDate("date_fin");

	            Contrat contrat = new Contrat(nom, adresse, date_debut, date_fin);
	            contrats.add(contrat);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } finally {
	        // Fermeture des ressources JDBC
	        try { rs.close(); 
	        } catch (Exception e) { 
	            
	        }
	        try { stmt.close(); 
	        } catch (Exception e) { 
	            
	        }
	        try { dbConnection.close(); 
	        } catch (Exception e) { 
	            
	        }
	    }

	}

}
