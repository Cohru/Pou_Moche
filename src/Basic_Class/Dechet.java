package Basic_Class;


	
public class Dechet implements Dechet_poids {
	private int type;
	private double poids;
	private int categorie;

	public Dechet(int type) {
		
		this.type = type;
		switch (type){
			case VERRE:
				this.categorie=3;
				poids=pv;
				break;
			case PAPIER:
				this.categorie=1;
				poids=ppp;
				break;
			case AUTRE:
				this.categorie=0;
				poids=pa;
				break;
			case METAUX:
				this.categorie=2;
				poids=pm;
			case PLASTIQUE:
				this.categorie=2;
				poids=pp;
			case CARTON:
				this.categorie=2;
				poids=pc;
		}
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public int getCategorie() {
		return categorie;
	}

	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}
	
	
}
