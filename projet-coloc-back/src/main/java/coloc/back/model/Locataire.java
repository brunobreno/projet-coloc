package coloc.back.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("locataire")
@JsonView(Views.ViewCommon.class)
public class Locataire extends Utilisateur {
	private boolean recherche;
	private String description;
	@Enumerated(EnumType.STRING)
	
	@JsonView(Views.ViewLocataireDetail.class)
	private Situation situation;
	
	@Embedded
	@JsonView(Views.ViewLocataireDetail.class)
	private Dossier dossier;
	
	@OneToOne
	@JsonView(Views.ViewLocataireDetail.class)
	private Chambre chambre;

	@OneToMany(mappedBy = "locataire")
	@JsonView(Views.ViewLocataireDetail.class)
	private List<Candidature> candidatures = new ArrayList<Candidature>();
	
	public Locataire() {}

	public Locataire(String nom, String prenom, Civilite civ, String email, String tel, String password, boolean recherche,
			String description, Situation situation, Dossier dossier, Chambre chambre) {
		super(nom, prenom, civ, email, tel, password);
		this.recherche = recherche;
		this.description = description;
		this.situation = situation;
		this.dossier = dossier;
		this.chambre = chambre;
	}

	public Locataire(String nom, String prenom, Civilite civ, String email, String tel, String password, boolean recherche,
			String description, Situation situation) {
		super(nom, prenom, civ, email, tel, password);
		this.recherche = recherche;
		this.description = description;
		this.situation = situation;
	}

	public Situation getSituation() {
		return situation;
	}

	public void setSituation(Situation situation) {
		this.situation = situation;
	}

	public Dossier getDossier() {
		return dossier;
	}

	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public boolean isRecherche() {
		return recherche;
	}

	public void setRecherche(boolean recherche) {
		this.recherche = recherche;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Candidature> getCandidatures() {
		return candidatures;
	}

	public void setCandidatures(List<Candidature> candidatures) {
		this.candidatures = candidatures;
	}

	public void addCandidatures(Candidature candidature) {
		this.candidatures.add(candidature);
	}

	@Override
	public String toString() {
		return "Locataire [recherche=" + recherche + ", description=" + description + ", situation=" + situation
				+ ", dossier=" + dossier + ", chambre=" + chambre + "]";
	}
}
