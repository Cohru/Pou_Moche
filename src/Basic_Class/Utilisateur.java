package Basic_Class;

import java.util.ArrayList;

public class Utilisateur {
	private String nom;
	private int id;
	private String prenom;
	private int ptFidelite;
	private String mdp;

	
	public Utilisateur(int id,String nom,String prenom, int ptFidelite, String mdp) {
		this.nom = nom;
		this.id = id;
		this.prenom = prenom;
		this.ptFidelite = ptFidelite;
		this.mdp = mdp;
	}
	
	
	public Utilisateur(String nom, String prenom, String mdp) {
		this.nom = nom;
		this.prenom = prenom;
		this.ptFidelite=0;
		this.mdp = mdp;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getPtFidelite() {
		return ptFidelite;
	}

	public void setPtFidelite(int ptFidelite) {
		this.ptFidelite = ptFidelite;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
}
