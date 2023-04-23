package application;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import Basic_Class.Utilisateur;
import Data.PoubelleData;
import Data.Utilisateur_Data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Basic_Class.Poubelle;
public class Membre_Controleur{
	
	private Utilisateur hu;
	@FXML
	private Label nom_label;
	@FXML
	private Label prenom_label;
	@FXML
	private Label id_label;
	
	private Parent root;
	private Stage stage;
	private Scene scene;
	
	public void setUtilisateur(Utilisateur ut) {
		this.hu=ut;		
		nom_label.setText(hu.getNom());
		prenom_label.setText(hu.getPrenom());
		id_label.setText(""+hu.getId());
	}
	
	
	public void setUtilisateur2(Utilisateur ut) {
		this.hu=ut;		
	}
	
	
	public void MaPoubelle(ActionEvent e) {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Select_Poubelle.fxml"));
			root = loader.load();
			Membre_Controleur mpd = loader.getController();
			
			mpd.setUtilisateur2(hu);
			stage= (Stage)((Node)e.getSource()).getScene().getWindow();
			scene= new Scene(root);
			stage.setScene(scene);	
			stage.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	@FXML
	private TextField selectPoubelle;
	
	@FXML
	private Label ErrorID_label;
	
	public void Jeter(ActionEvent e) {
		int p_id = Integer.parseInt(selectPoubelle.getText());
		PoubelleData pd = new PoubelleData();
		ArrayList<Poubelle> ordure = new ArrayList<Poubelle>();
		pd.SelectPoubelle(ordure);
		for (int i =0;i<ordure.size();i++) {
		if (ordure.get(i).getId() == p_id) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("MaPoubellePage.fxml"));
				root = loader.load();
				MaPoubelle_Controleur mpd = loader.getController();
				
				mpd.setPoubelle(ordure.get(i),hu);
				stage= (Stage)((Node)e.getSource()).getScene().getWindow();
				scene= new Scene(root);
				stage.setScene(scene);	
				stage.show(); 
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		}
		
		else {
			ErrorID_label.setText("Cette poubelle n'existe pas");
		}
	}
	}
	
	public void Histo(ActionEvent e) throws IOException, SQLException {

	    FXMLLoader loader = new FXMLLoader(getClass().getResource("HistoClient.fxml"));
	    Parent root = loader.load();
	    HistoClient_Controleur controller = loader.getController();
	    controller.getIdc(hu);
	    Scene scene = new Scene(root);
	    Stage stage = new Stage();
	    stage.setScene(scene);
	    stage.show();
	}
	
	public void ListeMagasin(ActionEvent e) throws IOException, SQLException {

	    FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeMagasin.fxml"));
	    Parent root = loader.load();
	    Liste_Magasin_Controler controller = loader.getController();
	    controller.getCN(hu);
	    Scene scene = new Scene(root);
	    Stage stage = new Stage();
	    stage.setScene(scene);
	    stage.show();
	}
	
	public void ConversionPts(ActionEvent e) throws IOException, SQLException {
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("conversionpts.fxml"));
	    root = loader.load();
	    Conversion_Pts mdp = loader.getController();
		mdp.setUtilisateurds(hu.getId());
	    Scene scene = new Scene(root);
	    Stage stage = new Stage();
	    stage.setScene(scene);
	    stage.show();
	}
	
	public void Liste7(ActionEvent e) throws IOException, SQLException {
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("ListePoubelleMembre.fxml"));
	    Parent root = loader.load();
	    PoubelleListe_Controleur mdp = loader.getController();
		mdp.getCN();
	    Scene scene = new Scene(root);
	    Stage stage = new Stage();
	    stage.setScene(scene);
	    stage.show();
	}
	
}
