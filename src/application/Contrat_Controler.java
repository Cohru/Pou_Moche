package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;


import Basic_Class.Contrat;
import Data.ContratData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Contrat_Controler {
	
	private String Centre_Nom; 
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void getN(String n) {
		Centre_Nom=n;
	}
	@FXML
	TextField CommerceName;
	
	@FXML
	TextField CommerceAdresse;

	@FXML
	DatePicker date_debut;
	
	@FXML
	DatePicker date_fin;
	
	public void submit(ActionEvent e) {
		if(!(CommerceName.getText().equals("") && CommerceAdresse.getText().equals("")) ) {
				String nom = CommerceName.getText();
				String adresse = CommerceAdresse.getText();
				LocalDate db = date_debut.getValue();
				java.sql.Date sqlDate = java.sql.Date.valueOf(db);
				LocalDate df = date_fin.getValue();
				java.sql.Date sqlDate2 = java.sql.Date.valueOf(df);
				Contrat pp = new Contrat(nom,adresse,sqlDate,sqlDate2);

				ContratData pd = new ContratData();
				pd.NewContrat(pp);
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Centre_Controle.fxml"));
			root = loader.load(); 
			Centre_Controle Centre = loader.getController();
			Centre.getName(Centre_Nom);
			stage= (Stage)((Node)e.getSource()).getScene().getWindow();
			scene= new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
	}
	
	
}
