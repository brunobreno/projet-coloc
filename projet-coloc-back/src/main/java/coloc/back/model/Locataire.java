package coloc.back.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("locataire")
@JsonView(Views.ViewCommon.class)
public class Locataire extends Utilisateur {
	private boolean recherche;
	private String description;

	private LocalDate dateDeNaissance;
	
	@Enumerated(EnumType.STRING)
	private Situation situation;
	
	@Embedded
	@JsonView(Views.ViewLocataireDetail.class)
	private Dossier dossier;
	
	@OneToMany(mappedBy = "locataire")
	@JsonView(Views.ViewLocataireDescription.class)
	private List<Photo> photos;
	
	@ManyToMany
	@JoinTable
	(
		name="hobby_locataire"
	)
	@JsonView(Views.ViewLocataireDescription.class)
	private  List<Hobby> hobbies = new ArrayList<Hobby>();
	
	
	@OneToOne
	@JsonView(Views.ViewLocataireDetail.class)
	private Chambre chambre;
	
	
	
	@OneToMany(mappedBy = "locataire")
	@JsonView(Views.ViewLocataireDetail.class)
	private List<Candidature> candidatures = new ArrayList<Candidature>();
	
	public Locataire() {}
	
	

	public Locataire(String username, String nom, String prenom, Civilite civ, String email, String tel, String password, boolean recherche,
			String description, Situation situation, LocalDate dateDeNaissance, Dossier dossier, Chambre chambre) {
		super(username, nom, prenom, civ, email, tel, password);
		this.recherche = recherche;
		this.description = description;
		this.situation = situation;
		this.dateDeNaissance = dateDeNaissance;
		this.dossier = dossier;
		this.chambre = chambre;
	}

	public Locataire(String username, String nom, String prenom, Civilite civ, String email, String tel, String password, boolean recherche,
			String description, Situation situation, LocalDate dateDeNaissance) {
		super(username, nom, prenom, civ, email, tel, password);
		this.recherche = recherche;
		this.description = description;
		this.situation = situation;
		this.dateDeNaissance = dateDeNaissance;
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

	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
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
	
	

	public List<Hobby> getHobbies() {
		return hobbies;
	}



	public void setHobbies(List<Hobby> hobbies) {
		this.hobbies = hobbies;
	}


	public void addHobby(Hobby hobby) {
		this.hobbies.add(hobby);
	}
	
	public List<Photo> getPhotos() {
		return photos;
	}



	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}



	@Override
	public String toString() {
		return "Locataire [recherche=" + recherche + ", description=" + description + ", situation=" + situation
				+ ", dossier=" + dossier + ", chambre=" + chambre + "]";
	}
}
