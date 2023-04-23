package Basic_Class;

public interface Dechet_poids {

	int VERRE=0;
	int PAPIER=1;
	int AUTRE=2;
	int METAUX=3;
	int PLASTIQUE=4;
	int CARTON=5;
	
	
	double pv=10;
	double ppp=1;
	double pa=5;
	double pm=4;
	double pp=3;
	double pc=2;
	
	public static double CalculPoids(Poubelle p) {
		int qc=p.getQuantite_pc();
		int qm = p.getQuantite_pm();
		int qv=p.getQuantite_pv();
		int qa=p.getQuantite_autre();
		int qppp=p.getQuantite_ppp();
		int qp = p.getQuantite_pp();
		
		double P_actuel = qc*pc+qm*pm+qv*pv+qa*pa+qppp*ppp+qp*pp;
		return P_actuel;
	}
}