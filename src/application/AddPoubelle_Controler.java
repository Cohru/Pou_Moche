package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Basic_Class.Poubelle;
import Data.PoubelleData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;




public class AddPoubelle_Controler implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private String Centre_Name;
	
	@FXML
	private ChoiceBox<String> TypeChooser;
	private String[] type = {"Jaune","Verte","Bleu","Classique"};
	
	@FXML
	TextField IDField;

	@FXML
	TextField AdField;
	
	@FXML
	TextField CapacityField;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TypeChooser.getItems().addAll(type);
	}
	
	public void RecupName(String name) {
		this.Centre_Name=name;
	}
	
	public void submit(ActionEvent e) {
		if(!(AdField.getText().equals("") && CapacityField.getText().equals("")) ) {
				//int ID = Integer.parseInt(IDField.getText());
				String adresse = AdField.getText();
				double Capacite = Double.parseDouble(CapacityField.getText());
				String type = TypeChooser.getValue();
				int vtype=0;
				switch (type)
				{
					case "Jaune":
						vtype=2;
						break;
					case "Verte":
						vtype = 3;
						break;
					case "Bleu":
						vtype = 1;
						break; 
					case "Classique":
						vtype=0;
						break;
				}
				Poubelle poumoche = new Poubelle(Centre_Name,adresse,Capacite,vtype);
				//ajouter a la base de donnée comme ca rien a passé
				PoubelleData pd = new PoubelleData();
				pd.NewPoubelle(poumoche);
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Centre_Controle.fxml"));
			root = loader.load(); 
			Centre_Controle Centre = loader.getController();
			Centre.getName(Centre_Name);
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
