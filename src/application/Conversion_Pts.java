package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import Basic_Class.Poubelle;
import Basic_Class.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import Data.PoubelleData;
import Data.Utilisateur_Data;



public class Conversion_Pts {
	private Utilisateur ut;
	@FXML
	private Label Nb_pts;
	
	private Parent root;
	private Stage stage;
	private Scene scene;
	
	public void setUtilisateurds(int hu) {

    	Utilisateur_Data huc = new Utilisateur_Data();
    	ArrayList<Utilisateur> corentin = new ArrayList<Utilisateur>();
    	huc.RecupClient(corentin);
    	for(int i =0 ; i<corentin.size();i++) {
    		if (corentin.get(i).getId()==hu) {
    			ut=corentin.get(i);
    		}
    	}
    	Nb_pts.setText(""+ut.getPtFidelite());

	}
	
	public void button1(ActionEvent e){
		if(ut.getPtFidelite()>=100) {
			Utilisateur_Data ud = new Utilisateur_Data();
			ud.updatePopularityInDatabase2(ut,100);
			try {
				root =FXMLLoader.load(getClass().getResource("Sucess_Conversion.fxml"));
				stage= (Stage)((Node)e.getSource()).getScene().getWindow();
				scene=new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e1) {
		        e1.printStackTrace();
		    }
		}
		else {
		
		}
	}
	
	public void button2(ActionEvent e) throws IOException{
		if(ut.getPtFidelite()>=200) {
			Utilisateur_Data ud = new Utilisateur_Data();
			ud.updatePopularityInDatabase2(ut,200);
			root =FXMLLoader.load(getClass().getResource("Sucss_Conversion.fxml"));
			stage= (Stage)((Node)e.getSource()).getScene().getWindow();
			scene=new Scene(root);
			stage.setScene(scene);
			stage.show();
		    			
		}

	}

}