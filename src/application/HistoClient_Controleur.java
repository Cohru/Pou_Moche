package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import Basic_Class.Historique;
import Basic_Class.Utilisateur;
import Data.Utilisateur_Data;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class HistoClient_Controleur {
	private Utilisateur Idc;
	

	public void getIdc(Utilisateur is) throws IOException, SQLException {
		this.Idc=is;

		
		ObservableList<Historique> poubelleList = FXCollections.observableArrayList();
        ArrayList<Historique> pu = new ArrayList<Historique>();
        Utilisateur_Data pd = new Utilisateur_Data();
        pd.selectHistorique(pu);
        for (int i =0;i<pu.size();i++) {
            if (Idc.getId() == pu.get(i).getIdClient()) {
                poubelleList.add(pu.get(i));
            }
        }
        HistoTable.setItems(poubelleList);

        idPoubCol.setCellValueFactory(new PropertyValueFactory<>("idPoub"));
        idClientCol.setCellValueFactory(new PropertyValueFactory<>("idClient"));

        dateC.setCellValueFactory(new PropertyValueFactory<>("date"));
        quantitePPCol.setCellValueFactory(new PropertyValueFactory<>("n_pp"));
        quantitePMCol.setCellValueFactory(new PropertyValueFactory<>("n_pm"));
        quantitePVCol.setCellValueFactory(new PropertyValueFactory<>("n_pv"));
        quantitePCCol.setCellValueFactory(new PropertyValueFactory<>("n_pc"));
        quantitePPPCol.setCellValueFactory(new PropertyValueFactory<>("n_ppp"));
        quantitePPACol.setCellValueFactory(new PropertyValueFactory<>("n_autre"));
        fideliteCol.setCellValueFactory(new PropertyValueFactory<>("fidelite"));
	}
	
    @FXML
    private TableView<Historique> HistoTable;
    @FXML
    private TableColumn<Historique, Integer> idPoubCol;
    
    @FXML
    private TableColumn<Historique, Integer> idClientCol;

    @FXML
    private TableColumn<Historique, String> dateC;

    @FXML
    private TableColumn<Historique, Integer> quantitePPCol;
    @FXML
    private TableColumn<Historique, Integer> quantitePMCol;
    @FXML
    private TableColumn<Historique, Integer> quantitePVCol;
    @FXML
    private TableColumn<Historique, Integer> quantitePCCol;
    @FXML
    private TableColumn<Historique, Integer> quantitePPPCol;
    @FXML
    private TableColumn<Historique, Integer> quantitePPACol;
    @FXML
    private TableColumn<Historique, Integer> fideliteCol;

    // autres colonnes ici


    
    private Parent root;
    private Stage stage;
    private Scene scene;
    
    
    public void Retour (ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MemberPage.fxml"));
		root = loader.load();
		Membre_Controleur memb = loader.getController();
		memb.setUtilisateur(Idc);
		stage= (Stage)((Node)e.getSource()).getScene().getWindow();
		scene= new Scene(root);
		stage.setScene(scene);	
		stage.show();

    }
}
