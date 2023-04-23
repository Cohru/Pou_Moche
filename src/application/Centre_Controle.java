package application;

import java.io.IOException;

import Basic_Class.Centre_de_tri;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Centre_Controle {
	private String name;
	private Centre_de_tri ctt;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	

	public void getName(String name) {
		this.name = name; 
	}
	
	
	public void NewPoubelle(ActionEvent e) {
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AddPoubelle.fxml"));
			root = loader.load(); 
			AddPoubelle_Controler Centre = loader.getController();
			Centre.RecupName(name);
			stage= (Stage)((Node)e.getSource()).getScene().getWindow();
			scene= new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}
	
	
	public void ListeP(ActionEvent e) {
		System.out.println("le b marche");
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Liste_Poubelle.fxml"));
			root = loader.load(); 
			PoubelleListe_Controleur Centre = loader.getController();
			Centre.getCN(name);
			stage= (Stage)((Node)e.getSource()).getScene().getWindow();
			scene= new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	public void Historic(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Liste_Historique.fxml"));
		root = loader.load(); 
		HistoriqueListe_Controleur Centre = loader.getController();
		Centre.RecupNom(name);
		stage= (Stage)((Node)e.getSource()).getScene().getWindow();
		scene= new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void Contract(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutContrat.fxml"));
		root = loader.load(); 
		Contrat_Controler Centre = loader.getController();
		Centre.getN(name);
		stage= (Stage)((Node)e.getSource()).getScene().getWindow();
		scene= new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
