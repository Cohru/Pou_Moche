package application;

import java.io.IOException;

import Basic_Class.Centre_de_tri;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Centre_Connexion {
	@FXML
	TextField UserField;
	@FXML
	TextField PassField;
	@FXML
	Label ErrorLabel;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	public void CoBouton(ActionEvent e) {
		String username = UserField.getText();
		String password = PassField.getText();
		
		Centre_de_tri dd = new Centre_de_tri("cytech","67 avenue Auguste Renoir");
		
		if (username.equals(dd.getName()) && password.equals("oui") || username.equals("Corentin") && password.equals("oui")) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Centre_Controle.fxml"));
				root = loader.load(); 
				Centre_Controle Centre = loader.getController();
				Centre.getName(username);
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
			ErrorLabel.setText("WRONG");
		}
	}
	
	public void NewCompte(ActionEvent e) {
		
	}
}
