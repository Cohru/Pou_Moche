package application;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import Basic_Class.Poubelle;
import Data.PoubelleData;
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

public class PoubelleListe_Controleur {
	
		private String Centre_Nom;
	    @FXML
	    private TableView<Poubelle> poubelleTableView;

	    @FXML
	    private TableColumn<Poubelle, String> centreNomCol;

	    @FXML
	    private TableColumn<Poubelle, Integer> idCol;

	    @FXML
	    private TableColumn<Poubelle, String> adresseCol;

	    @FXML
	    private TableColumn<Poubelle, Double> capaciteCol;

	    @FXML
	    private TableColumn<Poubelle, Integer> quantitePPCol;
	    @FXML
	    private TableColumn<Poubelle, Integer> quantitePMCol;
	    @FXML
	    private TableColumn<Poubelle, Integer> quantitePVCol;
	    @FXML
	    private TableColumn<Poubelle, Integer> quantitePCCol;
	    @FXML
	    private TableColumn<Poubelle, Integer> quantitePPPCol;
	    @FXML
	    private TableColumn<Poubelle, Integer> quantitePPACol;
	    @FXML
	    private TableColumn<Poubelle, Integer> typeCol;

	    // autres colonnes ici
	    
	    public void getCN(String CN) {
	    	Centre_Nom=CN;
	    	
	    	ObservableList<Poubelle> poubelleList = FXCollections.observableArrayList();

	        // Remplissage de l'ObservableList avec des objets Poubelle
	        ArrayList<Poubelle> pu = new ArrayList<Poubelle>();
	        PoubelleData pd = new PoubelleData();
	        pd.SelectPoubelle(pu);
	        
	        for (int i =0;i<pu.size();i++) {
	        	if(Centre_Nom.equals((pu.get(i).getCentreName()))) {
	        		poubelleList.add(pu.get(i));
	        	}
	        }
	        // Définition de la source de données de la TableView
	        poubelleTableView.setItems(poubelleList);

	        // Configuration des colonnes pour afficher les propriétés de la classe Poubelle
	        centreNomCol.setCellValueFactory(new PropertyValueFactory<>("CentreName"));
	        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
	        adresseCol.setCellValueFactory(new PropertyValueFactory<>("adresse"));
	        capaciteCol.setCellValueFactory(new PropertyValueFactory<>("capacite"));
	        quantitePPCol.setCellValueFactory(new PropertyValueFactory<>("quantite_pp"));
	        quantitePMCol.setCellValueFactory(new PropertyValueFactory<>("quantite_pm"));
	        quantitePVCol.setCellValueFactory(new PropertyValueFactory<>("quantite_pv"));
	        quantitePCCol.setCellValueFactory(new PropertyValueFactory<>("quantite_pc"));
	        quantitePPPCol.setCellValueFactory(new PropertyValueFactory<>("quantite_ppp"));
	        quantitePPACol.setCellValueFactory(new PropertyValueFactory<>("quantite_autre"));
	        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
	    }
	    
	    public void getCN() {
	    	
	    	ObservableList<Poubelle> poubelleList = FXCollections.observableArrayList();

	        // Remplissage de l'ObservableList avec des objets Poubelle
	        ArrayList<Poubelle> pu = new ArrayList<Poubelle>();
	        PoubelleData pd = new PoubelleData();
	        pd.SelectPoubelle(pu);
	        
	        for (int i =0;i<pu.size();i++) 
	        	{
	        		poubelleList.add(pu.get(i));
	        	}
	        
	        // Définition de la source de données de la TableView
	        poubelleTableView.setItems(poubelleList);

	        // Configuration des colonnes pour afficher les propriétés de la classe Poubelle
	        centreNomCol.setCellValueFactory(new PropertyValueFactory<>("CentreName"));
	        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
	        adresseCol.setCellValueFactory(new PropertyValueFactory<>("adresse"));
	        capaciteCol.setCellValueFactory(new PropertyValueFactory<>("capacite"));
	        quantitePPCol.setCellValueFactory(new PropertyValueFactory<>("quantite_pp"));
	        quantitePMCol.setCellValueFactory(new PropertyValueFactory<>("quantite_pm"));
	        quantitePVCol.setCellValueFactory(new PropertyValueFactory<>("quantite_pv"));
	        quantitePCCol.setCellValueFactory(new PropertyValueFactory<>("quantite_pc"));
	        quantitePPPCol.setCellValueFactory(new PropertyValueFactory<>("quantite_ppp"));
	        quantitePPACol.setCellValueFactory(new PropertyValueFactory<>("quantite_autre"));
	        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
	    }
	    
	    private Poubelle p_select;
	    public void onLigneSelectionnee() {
	        Poubelle donneeSelectionnee = poubelleTableView.getSelectionModel().getSelectedItem();
	        if (donneeSelectionnee != null) {
	            // Traitement à effectuer lorsqu'une ligne est sélectionnée
	        	
	            p_select=donneeSelectionnee;
	        }
	    }
	    
	    private Parent root;
	    private Scene scene;
	    private Stage stage;
	    
	    public void Retour(ActionEvent e) {
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
	    
	    public void Vider(ActionEvent e) {
	    	PoubelleData pd= new PoubelleData();
	    	pd.viderQuantite(p_select);
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Liste_Poubelle.fxml"));
				root = loader.load(); 
				PoubelleListe_Controleur Centre = loader.getController();
				Centre.getCN(Centre_Nom);
				stage= (Stage)((Node)e.getSource()).getScene().getWindow();
				scene= new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	    }
	    
	    public void Suppr(ActionEvent e) {
	    	PoubelleData pd= new PoubelleData();
	    	pd.deletePoubelle(p_select);
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Liste_Poubelle.fxml"));
				root = loader.load(); 
				PoubelleListe_Controleur Centre = loader.getController();
				Centre.getCN(Centre_Nom);
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

