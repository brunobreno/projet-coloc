package coloc.back.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import coloc.back.model.Views.ViewCandidature;
import coloc.back.model.Views;

@Entity
@JsonView(Views.ViewCommon.class)
public class Candidature {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY )
	private Long id;
	
	@Version
	private Integer version;

	@ManyToOne
	@JsonView(Views.ViewCandidature.class)
	private Locataire locataire;
	
	@ManyToOne
	@JsonView(Views.ViewCandidature.class)
	private Chambre chambre;

	@JsonView(Views.ViewCandidature.class)
	private boolean validation;

	@JsonView(Views.ViewCandidature.class)
	private boolean enAttente;
	
	public Candidature() {
	}

	public Candidature(boolean validation, boolean enAttente) {
		this.validation = validation;
		this.enAttente = enAttente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Locataire getLocataire() {
		return locataire;
	}

	public void setLocataire(Locataire locataire) {
		this.locataire = locataire;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setLocataire(Chambre chambre) {
		this.chambre = chambre;
	}

	public boolean getValidation() {
		return validation;
	}

	public void setValidation(boolean validation) {
		this.validation = validation;
	}

	public boolean getEnAttente() {
		return enAttente;
	}

	public void setEnAttente(boolean enAttente) {
		this.enAttente = enAttente;
	}
}
