package application;

	import java.io.IOException;
	
	import javafx.event.ActionEvent;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Node;
	import javafx.scene.Scene;
	import javafx.stage.Stage;

public class MainControler {
	private Stage stage;
	private Scene scene;
	private Parent root;
	

	
	public void CDT(ActionEvent e) {
		try {
			Parent root =FXMLLoader.load(getClass().getResource("Centre_Connexion.fxml"));
			stage= (Stage)((Node)e.getSource()).getScene().getWindow();
			scene=new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void Member(ActionEvent e) {
		try {
			System.out.println("test");
			root = FXMLLoader.load(getClass().getResource("Connexion_Utilisateur.fxml"));
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