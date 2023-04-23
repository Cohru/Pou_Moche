package Basic_Class;


import java.util.ArrayList;

public class Centre_de_tri {
	private String Nom;
	private String adresse;
	private ArrayList<Integer> poubelleID;
	
	public Centre_de_tri(String nom,String adresse,ArrayList<Integer> poubelle) {
		this.Nom= nom;
		this.adresse=adresse;
		this.poubelleID=poubelle;
	}
	public Centre_de_tri(String nom,String adresse) {
		this.Nom= nom;
		this.adresse=adresse;
		this.poubelleID= new ArrayList<Integer>();
	}
	
	public String getName() {
		return Nom;
	}
	
	public void addPoubelle(int p) {
		poubelleID.add(p);
	}
}
