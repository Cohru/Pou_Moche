package Basic_Class;


import java.util.ArrayList;

public  class Poubelle {
	private String CentreName;
	private int id;
	private String adresse;
	private double capacite;
	private int quantite_pp;
	private int quantite_pm;
	private int quantite_pv;
	private int quantite_autre;
	private int quantite_ppp;
	private int quantite_pc;
	private int type;
	public Poubelle(String centreName, int id, String adresse, double capacite, int quantite_pp, int quantite_pm,
			int quantite_pv, int quantite_autre, int quantite_ppp, int quantite_pc, int type) {

		CentreName = centreName; 
		this.id = id;
		this.adresse = adresse;
		this.capacite = capacite;
		this.quantite_pp = quantite_pp;
		this.quantite_pm = quantite_pm;
		this.quantite_pv = quantite_pv;
		this.quantite_autre = quantite_autre;
		this.quantite_ppp = quantite_ppp;
		this.quantite_pc = quantite_pc;
		this.type = type;
	}
	
	//id=0 poubelle classique
	//id=1 poubelle bleu
	//id=2 poubelle jaune
	//id=3 poubelle verte

	public Poubelle(String centreName, int id, String adresse, double capacite, int type) {

		CentreName = centreName;
		this.id = id;
		this.adresse = adresse;
		this.capacite = capacite;
		this.quantite_pp = 0;
		this.quantite_pm = 0;
		this.quantite_pv = 0;
		this.quantite_autre = 0;
		this.quantite_ppp = 0;
		this.quantite_pc = 0;
		this.type = type;
	}

	public Poubelle(String centreName, String adresse, double capacite, int type) {

		CentreName = centreName;
		//this.id = id;
		this.adresse = adresse;
		this.capacite = capacite;
		this.quantite_pp = 0;
		this.quantite_pm = 0;
		this.quantite_pv = 0;
		this.quantite_autre = 0;
		this.quantite_ppp = 0;
		this.quantite_pc = 0;
		this.type = type;
	}
	
	
	public String getCentreName() {
		return CentreName;
	}

	public void setCentreName(String centreName) {
		CentreName = centreName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public double getCapacite() {
		return capacite;
	}

	public void setCapacite(double capacite) {
		this.capacite = capacite;
	}

	public int getQuantite_pp() {
		return quantite_pp;
	}

	public void setQuantite_pp(int quantite_pp) {
		this.quantite_pp = quantite_pp;
	}

	public int getQuantite_pm() {
		return quantite_pm;
	}

	public void setQuantite_pm(int quantite_pm) {
		this.quantite_pm = quantite_pm;
	}

	public int getQuantite_pv() {
		return quantite_pv;
	}

	public void setQuantite_pv(int quantite_pv) {
		this.quantite_pv = quantite_pv;
	}

	public int getQuantite_autre() {
		return quantite_autre;
	}

	public void setQuantite_autre(int quantite_autre) {
		this.quantite_autre = quantite_autre;
	}

	public int getQuantite_ppp() {
		return quantite_ppp;
	}

	public void setQuantite_ppp(int quantite_ppp) {
		this.quantite_ppp = quantite_ppp;
	}

	public int getQuantite_pc() {
		return quantite_pc;
	}

	public void setQuantite_pc(int quantite_pc) {
		this.quantite_pc = quantite_pc;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
}
	