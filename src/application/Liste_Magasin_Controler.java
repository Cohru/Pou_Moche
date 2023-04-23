package application;

import java.sql.Date;
import java.util.ArrayList;

import Basic_Class.Contrat;
import Basic_Class.Utilisateur;
import Data.ContratData;
import Data.PoubelleData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Liste_Magasin_Controler {
	private Utilisateur Centre_Nom;
    @FXML
    private TableView<Contrat> MagasinTableView;

    @FXML
    private TableColumn<Contrat, String> CommerceNomCol;

    @FXML
    private TableColumn<Contrat, String> CommerceAdresseCol;

    @FXML
    private TableColumn<Contrat, Date> D_debutCol;

    @FXML
    private TableColumn<Contrat, Date> D_finCol;
    
    public void getCN(Utilisateur CN) {
    	Centre_Nom=CN;
    	
    	ObservableList<Contrat> contratList = FXCollections.observableArrayList();
    		
        // Remplissage de l'ObservableList avec des objets Poubelle
        ArrayList<Contrat> pu = new ArrayList<Contrat>();
        ContratData pd = new ContratData();
        pd.getAllContrats(pu);
        
        for (int i =0;i<pu.size();i++) {

        	contratList.add(pu.get(i));
        	
        }
        // Définition de la source de données de la TableView
        MagasinTableView.setItems(contratList);

        // Configuration des colonnes pour afficher les propriétés de la classe Poubelle
        CommerceNomCol.setCellValueFactory(new PropertyValueFactory<>("CommerceNom"));
        CommerceAdresseCol.setCellValueFactory(new PropertyValueFactory<>("Commerceadresse"));
}
}