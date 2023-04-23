package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import Basic_Class.Utilisateur;
import Data.Utilisateur_Data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
public class Utilisateur_Controleur {
	@FXML
	private TextField pseudo_field;
	@FXML
	private TextField password_field;
	
	private Parent root;
	private Scene scene;
	private Stage stage;
	
	public void ConnBouton(ActionEvent e) {
		String pseudo = pseudo_field.getText();
		String password = password_field.getText();
		ArrayList<Utilisateur> ut = new ArrayList<Utilisateur>();
		Utilisateur_Data hud=new Utilisateur_Data();
		hud.RecupClient(ut); 
		for (int i =0;i<ut.size();i++) {
			if (pseudo.equals(ut.get(i).getNom()) && password.equals(ut.get(i).getMdp())){
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("MemberPage.fxml"));
					root = loader.load();
					Membre_Controleur memb = loader.getController();
					memb.setUtilisateur(ut.get(i));
					stage= (Stage)((Node)e.getSource()).getScene().getWindow();
					scene= new Scene(root);
					stage.setScene(scene);	
					stage.show();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				
			}
		}
		
	}
	
	public void New_Client(ActionEvent e) {
		try {
		root = FXMLLoader.load(getClass().getResource("Nouveau_Client.fxml"));
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
	private TextField nom_field;

	@FXML
	private TextField prenom_field;
	@FXML
	private TextField password_field1;
	
	@FXML
	private Label error_label;
	
	public void Enregistrer(ActionEvent e) {
		String nom = nom_field.getText();
		String prenom = prenom_field.getText();
		String mdp = password_field1.getText();
		if (nom.equals("")||prenom.equals("")||mdp.equals("")) {
			error_label.setText("rempli les cases idiots");
		}
		else {
			Utilisateur hu = new Utilisateur(nom, prenom,  mdp);
			System.out.println(nom+prenom+mdp);
			Utilisateur_Data hud=new Utilisateur_Data();
			try {
				hud.NewUtilisateur(hu);
				root = FXMLLoader.load(getClass().getResource("Connexion_Utilisateur.fxml"));
				stage= (Stage)((Node)e.getSource()).getScene().getWindow();
				scene= new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}

	}
}
