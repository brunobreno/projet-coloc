package coloc.back.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("proprio")
@JsonView(Views.ViewCommon.class)
public class Proprietaire extends Utilisateur {
	
	@OneToMany(mappedBy = "proprietaire" )
	@JsonView(Views.ViewProprietaireDetail.class)
	private List<Logement> logements;
	
	public Proprietaire() {
		super();
	}

	public Proprietaire(String username, String nom, String prenom, Civilite civ, String email, String tel, String password, List<Logement> logements) {
		super(username, nom, prenom, civ, email, tel, password);
		this.logements = logements;
	}

	public Proprietaire(String username, String nom, String prenom, Civilite civ, String email, String tel, String password) {
		super(username, nom, prenom, civ, email, tel, password);
	}
	
	/*@Override
	public String toString() {
		return "Proprio [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", civ=" + civ
				+ ", email=" + email + ", tel=" + tel + "]";
	}*/
}
