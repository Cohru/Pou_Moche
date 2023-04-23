package Data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Basic_Class.Historique;
import Basic_Class.Poubelle;
import Basic_Class.Utilisateur;

public class Utilisateur_Data {
	
    public void RecupClient(ArrayList<Utilisateur> Renti)
    {
           
        Connection dbConnection = null;

        
        try {
        	
           Data_Source dataSource = new Data_Source();
           dbConnection = dataSource.createConnection();
           Statement stmt=dbConnection.createStatement(); 
           ResultSet rs=stmt.executeQuery("select * from utilisateur"); 
           while(rs.next()) {

               Utilisateur r= new Utilisateur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
               Renti.add(r);
               
           }
           dbConnection.close(); 
       }
       catch( Exception e )
       {
       System.out.println("Error Occured " + e.toString());
       }

   }
   
    public void NewUtilisateur(Utilisateur cli) throws IOException, SQLException {
        Connection dbConnection = null;
        PreparedStatement statement = null;

        
        try {
            Data_Source dataSource = new Data_Source();
            dbConnection = dataSource.createConnection();

            String sql = "INSERT INTO `utilisateur`(`nom`, `prenom`, `fidelite`, `mdp`) VALUES (?, ?, ?, ?)";
            statement = dbConnection.prepareStatement(sql);
            statement.setString(1, cli.getNom());
            //statement.setInt(2, cli.getId());
            statement.setString(2, cli.getPrenom());
            statement.setInt(3,cli.getPtFidelite());
            statement.setString(4, cli.getMdp());

            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }    
   
 
    
    public void updatePopularityInDatabase(Utilisateur hu) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Data_Source dataSource = new Data_Source();
            conn = dataSource.createConnection();
            
            String sql = "UPDATE utilisateur SET fidelite = " + hu.getPtFidelite() + " WHERE id = " + hu.getId();
            
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            System.out.println("Successfully updated popularity for car with ID " + hu.getId()
            );
    } catch (SQLException e) {
        System.out.println("Error updating popularity in database: " + e.getMessage());
    }
    }
    
    public void NewHistorique(Historique h) throws IOException, SQLException {
        Connection dbConnection = null;
        PreparedStatement statement = null;

        
        try {
            Data_Source dataSource = new Data_Source();
            dbConnection = dataSource.createConnection();

            String sql = "INSERT INTO `historique`(`id_poubelle`, `id_client`, `date`, `n_plastique`, `n_metaux`, `n_verre`, `n_autre`, `n_papier`, `n_carton`, `fidelite`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            statement = dbConnection.prepareStatement(sql);
            statement.setInt(1, h.getIdPoub());
            statement.setInt(2, h.getIdClient());
            statement.setString(3, h.getDate());
            statement.setInt(4,h.getN_pp());
            statement.setInt(5, h.getN_pm());
            statement.setInt(6, h.getN_pv());
            statement.setInt(7, h.getN_autre());
            statement.setInt(8, h.getN_ppp());
            statement.setInt(9, h.getN_pc());
            statement.setInt(10, h.getFidelite());

            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
    public void selectHistorique(ArrayList<Historique> hist) throws IOException, SQLException {
        Connection dbConnection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            Data_Source dataSource = new Data_Source();
            dbConnection = dataSource.createConnection();

            String sql = "SELECT * FROM historique";
            statement = dbConnection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idPoubelle = resultSet.getInt("id_poubelle");
                int idClient = resultSet.getInt("id_client");
                String date = resultSet.getString("date");
                int nPlastique = resultSet.getInt("n_plastique");
                int nMetaux = resultSet.getInt("n_metaux");
                int nVerre = resultSet.getInt("n_verre");
                int nAutre = resultSet.getInt("n_autre");
                int nPapier = resultSet.getInt("n_papier");
                int nCarton = resultSet.getInt("n_carton");
                int fidelite = resultSet.getInt("fidelite");

                Historique hi = new Historique(idPoubelle, idClient, date, nPlastique, nMetaux, nVerre, nAutre, nPapier, nCarton, fidelite);
                hist.add(hi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
    public void updatePopularityInDatabase2(Utilisateur hu, int ptsToRemove) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Data_Source dataSource = new Data_Source();
            conn = dataSource.createConnection();
            
            int newFidelite = hu.getPtFidelite() - ptsToRemove;
            String sql = "UPDATE utilisateur SET fidelite = ? WHERE id = ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, newFidelite);
            stmt.setInt(2, hu.getId());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            System.out.println("Successfully updated popularity for user with ID " + hu.getId()
            );
        } catch (SQLException e) {
            System.out.println("Error updating popularity in database: " + e.getMessage());
        }
    }

    

}