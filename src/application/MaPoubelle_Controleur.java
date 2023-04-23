package application;

import Basic_Class.Dechet_poids;
import Basic_Class.Historique;
import Basic_Class.Poubelle;
import Basic_Class.Utilisateur;
import Data.PoubelleData;
import Data.Utilisateur_Data;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Basic_Class.Dechet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MaPoubelle_Controleur implements Dechet_poids{
	
	private Utilisateur hu;
	private Poubelle poub;
	private double poids;
	
	private ArrayList<Dechet> ordure;
	
	public void setPoubelle(Poubelle p,Utilisateur hu) {
		poub = p;	
		poids=Dechet_poids.CalculPoids(p);
		ordure= new ArrayList<Dechet>();
		this.hu=hu;
	}
	
	
	@FXML
	private Label ncarton;
	private int n_carton = 0;
	public void Carton(ActionEvent e) {
		if (poids+pc<poub.getCapacite()) {
			n_carton++;
			ncarton.setText(""+n_carton);
			poids+=pc;
			poub.setQuantite_pc(poub.getQuantite_pc()+1);
			Dechet d = new Dechet(CARTON);
			ordure.add(d);
		}
		
	}
	@FXML
	private Label nplastique;
	private int n_plastique=0;
	public void Plastique(ActionEvent e) {
		if (poids+pp<poub.getCapacite()) {
			n_plastique++;
			nplastique.setText(""+n_plastique);
			poids+=pp;
			poub.setQuantite_pp(poub.getQuantite_pp()+1);
			Dechet d = new Dechet(PLASTIQUE);
			ordure.add(d);
		}
	}
	@FXML
	private Label npapier;
	private int n_papier=0;
	public void Papier(ActionEvent e) {
		if (poids+ppp<poub.getCapacite()) {
			n_papier++;
			npapier.setText(""+n_papier);
			poids+=ppp;
			poub.setQuantite_ppp(poub.getQuantite_ppp()+1);
			Dechet d = new Dechet(PAPIER);
			ordure.add(d);
		}
	}
	
	@FXML
	private Label nverre;
	private int n_verre=0;
	public void Verre(ActionEvent e) {
		if (poids+pv<poub.getCapacite()) {
			n_verre++;
			nverre.setText(""+n_verre);
			poids+=pv;
			poub.setQuantite_pv(poub.getQuantite_pv()+1);
			Dechet d = new Dechet(VERRE);
			ordure.add(d);
		}
	}
	
	@FXML
	private Label nmetaux;
	private int n_metaux=0;
	public void Metaux(ActionEvent e) {
		if (poids+pm<poub.getCapacite()) {
			n_metaux++;
			nmetaux.setText(""+n_metaux);
			poids+=pm;
			poub.setQuantite_pm(poub.getQuantite_pm()+1);
			Dechet d = new Dechet(METAUX);
			ordure.add(d);
		}
	}
	@FXML
	private Label nautre;
	private int n_autre=0;
	public void Autre(ActionEvent e) {
		if (poids+pa<poub.getCapacite()) {
			n_autre++;
			nautre.setText(""+n_autre);
			poids+=pa;
			poub.setQuantite_autre(poub.getQuantite_autre()+1);
			Dechet d = new Dechet(AUTRE);
			ordure.add(d);
		}
	}
	private Parent root;
	private Stage stage;
	private Scene scene;
	public void terminer(ActionEvent e) throws IOException {
		int fidelite=0;
		for (int i =0 ;i<ordure.size();i++) {
			if (ordure.get(i).getCategorie()==poub.getType()) {
				System.out.println(hu.getId());
				//ajoute des points de fidelité
				fidelite+=10;
				hu.setPtFidelite(hu.getPtFidelite()+10);
			}
			else {
				if(hu.getPtFidelite()>20) {
					fidelite-=20;
					hu.setPtFidelite(hu.getPtFidelite()-20);
				}
			}
		}
		//update la poubelle
		PoubelleData pd = new PoubelleData();
		pd.updateQuantities(poub);
		//update les pts de fidelité 
		Utilisateur_Data ud = new Utilisateur_Data();
		ud.updatePopularityInDatabase(hu);
		
		
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String formattedDateTime = localDateTime.format(formatter);

		
		Historique h = new Historique(poub.getId(),hu.getId(),formattedDateTime, n_plastique, n_metaux, n_verre, n_autre, n_papier,n_carton,  fidelite);
		try {
			ud.NewHistorique(h);
		} catch (IOException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MemberPage.fxml"));
		root = loader.load();
		Membre_Controleur memb = loader.getController();
		memb.setUtilisateur(hu);
		stage= (Stage)((Node)e.getSource()).getScene().getWindow();
		scene= new Scene(root);
		stage.setScene(scene);	
		stage.show();
	}
}
