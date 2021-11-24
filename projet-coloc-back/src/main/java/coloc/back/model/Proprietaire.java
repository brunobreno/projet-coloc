package coloc.back.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("proprio")
public class Proprietaire extends Utilisateur {
	
	@OneToMany(mappedBy = "proprietaire" )
	private List<Logement> logements;
	
	public Proprietaire() {
		super();
	}

	public Proprietaire(String nom, String prenom, Civilite civ, String email, String tel, String password, List<Logement> logements) {
		super(nom, prenom, civ, email, tel, password);
		this.logements = logements;
	}

	public Proprietaire(String nom, String prenom, Civilite civ, String email, String tel, String password) {
		super(nom, prenom, civ, email, tel, password);
	}
	
	/*@Override
	public String toString() {
		return "Proprio [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", civ=" + civ
				+ ", email=" + email + ", tel=" + tel + "]";
	}*/
}
