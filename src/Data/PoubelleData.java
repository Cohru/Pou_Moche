package Data;

import java.sql.*;
import java.util.ArrayList;

import Basic_Class.Poubelle;


public class PoubelleData {
	
	public void SelectPoubelle(ArrayList<Poubelle> poumoche) {
		Connection dbConnection=null;
		
		try {
			Data_Source datasource = new Data_Source();
			dbConnection = datasource.createConnection();
			
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from poubelle");
			
			while(rs.next()) {
				System.out.println("");
				String Centre_nom = rs.getString(1);
				int id = rs.getInt(2);
				String adresse = rs.getString(3);
				double capacite = rs.getDouble(4);
				int quantite_pp =rs.getInt(5);
				int quantite_pm = rs.getInt(6);
				int quantite_pv=rs.getInt(7);
				int quantite_autre=rs.getInt(8);
				int quantite_ppp=rs.getInt(9);
				int quantite_pc=rs.getInt(10);
				int type = rs.getInt(11);
				Poubelle pou = new Poubelle(Centre_nom, id, adresse, capacite,  quantite_pp,  quantite_pm,
						 quantite_pv,  quantite_autre,  quantite_ppp,  quantite_pc,  type);
				poumoche.add(pou);
			}
			
		}
		catch(Exception e) {
			System.out.println("Error Occured " + e.toString());
		}
	}
	 public void updateQuantities(Poubelle p) {
	        Connection dbConnection = null;
	        PreparedStatement stmt = null;

	        try {
	            // Connexion à la base de données
	            Data_Source dataSource = new Data_Source();
	            dbConnection = dataSource.createConnection();
	            // Préparation de la requête SQL
	            String sql = "UPDATE poubelle SET quantite_pp=?, quantite_pm=?, quantite_pv=?, quantite_autre=?, quantite_ppp=?, quantite_pc=? WHERE id=?";
	            stmt = dbConnection.prepareStatement(sql);

	            // Paramétrage des valeurs des paramètres de la requête SQL
	            stmt.setInt(1, p.getQuantite_pp());
	            stmt.setInt(2, p.getQuantite_pm());
	            stmt.setInt(3, p.getQuantite_pv());
	            stmt.setInt(4, p.getQuantite_autre());
	            stmt.setInt(5, p.getQuantite_ppp());
	            stmt.setInt(6, p.getQuantite_pc());
	            stmt.setInt(7, p.getId());

	            // Exécution de la requête SQL
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            // Fermeture des ressources JDBC
	            try { stmt.close(); } catch (Exception e) { }
	            try { dbConnection.close(); } catch (Exception e) { }
	        }
	    } 
	 public void NewPoubelle(Poubelle p) {
	    Connection dbConnection = null;
	    PreparedStatement stmt = null;
	    
	    try {
	        Data_Source datasource = new Data_Source();
	        dbConnection = datasource.createConnection();

	        String sql = "INSERT INTO `poubelle`(`Centre_nom`, `adresse`, `capacite`, `quantite_pp`, `quantite_pm`, `quantite_pv`, `quantite_autre`, `quantite_ppp`, `quantite_pc`, `type`)  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        stmt = dbConnection.prepareStatement(sql);
	        System.out.println("inser");
	        System.out.println(p.getCentreName());
	        stmt.setString(1, p.getCentreName());
	        //stmt.setInt(2, p.getId());
	        stmt.setString(2, p.getAdresse());
	        stmt.setDouble(3, p.getCapacite());
	        stmt.setInt(4, p.getQuantite_pp());
	        stmt.setInt(5, p.getQuantite_pm());
	        stmt.setInt(6, p.getQuantite_pv());
	        stmt.setInt(7, p.getQuantite_autre());
	        stmt.setInt(8, p.getQuantite_ppp());
	        stmt.setInt(9, p.getQuantite_pc());
	        stmt.setInt(10, p.getType());

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
	 
	 public void viderQuantite(Poubelle p) {
	        Connection dbConnection = null;
	        PreparedStatement stmt = null;

	        try {
	            // Connexion à la base de données
	            Data_Source dataSource = new Data_Source();
	            dbConnection = dataSource.createConnection();
	            // Préparation de la requête SQL
	            String sql = "UPDATE poubelle SET quantite_pp=?, quantite_pm=?, quantite_pv=?, quantite_autre=?, quantite_ppp=?, quantite_pc=? WHERE id=?";
	            stmt = dbConnection.prepareStatement(sql);

	            // Paramétrage des valeurs des paramètres de la requête SQL
	            stmt.setInt(1, 0);
	            stmt.setInt(2, 0);
	            stmt.setInt(3, 0);
	            stmt.setInt(4, 0);
	            stmt.setInt(5, 0);
	            stmt.setInt(6, 0);
	            stmt.setInt(7, p.getId());

	            // Exécution de la requête SQL
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            // Fermeture des ressources JDBC
	            try { stmt.close(); } catch (Exception e) { }
	            try { dbConnection.close(); } catch (Exception e) { }
	        }
	    } 
	 
	 public void deletePoubelle(Poubelle p) {
	        Connection dbConnection = null;
	        PreparedStatement stmt = null;
		    try {
		        // Connexion à la base de données
		    	 Data_Source dataSource = new Data_Source();
		         dbConnection = dataSource.createConnection();
		         
		        // Préparation de la requête SQL
		        String sql = "DELETE FROM poubelle WHERE id = ?";
		        PreparedStatement statement = dbConnection.prepareStatement(sql);
		        statement.setInt(1, p.getId());

		        // Exécution de la requête SQL
		        statement.executeUpdate();

		        // Fermeture de la connexion
		        dbConnection.close();

		        System.out.println("La poubelle a été supprimée avec succès !");
		    } catch (SQLException e) {
		        System.out.println("Erreur lors de la suppression de la poubelle : " + e.getMessage());
		    }
		}
}
