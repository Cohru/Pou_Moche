package Basic_Class;


import java.util.ArrayList;
import java.util.Date;

public class Historique {
	private int idPoub;
	private int idClient;
	private String date;
	private int n_pp;
	private int n_pm;
	private int n_pv;
	private int n_autre;
	private int n_ppp;
	private int n_pc;
	private int fidelite;
	
	
	public Historique(int idPoub, int idClient, String date, int n_pp, int n_pm, int n_pv, int n_autre, int n_ppp,
			int n_pc, int fidelite) {
		super();
		this.idPoub = idPoub;
		this.idClient = idClient;
		this.date = date;
		this.n_pp = n_pp;
		this.n_pm = n_pm;
		this.n_pv = n_pv;
		this.n_autre = n_autre;
		this.n_ppp = n_ppp;
		this.n_pc = n_pc;
		this.fidelite = fidelite;
	}


	public int getIdPoub() {
		return idPoub;
	}


	public void setIdPoub(int idPoub) {
		this.idPoub = idPoub;
	}


	public int getIdClient() {
		return idClient;
	}


	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getN_pp() {
		return n_pp;
	}


	public void setN_pp(int n_pp) {
		this.n_pp = n_pp;
	}


	public int getN_pm() {
		return n_pm;
	}


	public void setN_pm(int n_pm) {
		this.n_pm = n_pm;
	}


	public int getN_pv() {
		return n_pv;
	}


	public void setN_pv(int n_pv) {
		this.n_pv = n_pv;
	}


	public int getN_autre() {
		return n_autre;
	}


	public void setN_autre(int n_autre) {
		this.n_autre = n_autre;
	}


	public int getN_ppp() {
		return n_ppp;
	}


	public void setN_ppp(int n_ppp) {
		this.n_ppp = n_ppp;
	}


	public int getN_pc() {
		return n_pc;
	}


	public void setN_pc(int n_pc) {
		this.n_pc = n_pc;
	}


	public int getFidelite() {
		return fidelite;
	}


	public void setFidelite(int fidelite) {
		this.fidelite = fidelite;
	}
	
	
}
