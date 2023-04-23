	package Basic_Class;
	
	import java.sql.Date;
import java.time.LocalDate;
	
	public class Contrat {
		private String CommerceNom;
		private String Commerceadresse;
		private Date date_debut;
		private Date date_fin;
	
		
		public Contrat(String commerceNom, String commerceadresse, Date db, Date df) {
			this.CommerceNom = commerceNom;
			this.Commerceadresse = commerceadresse;
			this.date_debut = db;
			this.date_fin = df;
		}


		public String getCommerceNom() {
			return CommerceNom;
		}


		public void setCommerceNom(String commerceNom) {
			CommerceNom = commerceNom;
		}


		public String getCommerceadresse() {
			return Commerceadresse;
		}


		public void setCommerceadresse(String commerceadresse) {
			Commerceadresse = commerceadresse;
		}


		public java.sql.Date getDate_debut() {
			return date_debut;
		}


		public void setDate_debut(Date date_debut) {
			this.date_debut = date_debut;
		}


		public java.sql.Date getDate_fin() {
			return date_fin;
		}


		public void setDate_fin(Date date_fin) {
			this.date_fin = date_fin;
		}
		
	}
