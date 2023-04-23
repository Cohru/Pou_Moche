package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import Basic_Class.Historique;
import Basic_Class.Poubelle;
import Data.PoubelleData;
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

public class HistoriqueListe_Controleur {
    private String Centre_Nom;
    
    public void RecupNom(String it) {
    	Centre_Nom=it;
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

    public void initialize() throws IOException, SQLException {
        // Création de l'ObservableList
        ObservableList<Historique> poubelleList = FXCollections.observableArrayList();

        // Remplissage de l'ObservableList avec des objets Poubelle
        ArrayList<Historique> pu = new ArrayList<Historique>();
        Utilisateur_Data pd = new Utilisateur_Data();
        pd.selectHistorique(pu);
        for (int i =0;i<pu.size();i++) {
        	poubelleList.add(pu.get(i));
        }
        // Définition de la source de données de la TableView
        HistoTable.setItems(poubelleList);

        // Configuration des colonnes pour afficher les propriétés de la classe Poubelle

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
    private Parent root;
    private Scene scene;
    private Stage stage;
    public void Retour(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Centre_Controle.fxml"));
		root = loader.load(); 
		Centre_Controle Centre = loader.getController();
		Centre.getName(Centre_Nom);
		stage= (Stage)((Node)e.getSource()).getScene().getWindow();
		scene= new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
}
