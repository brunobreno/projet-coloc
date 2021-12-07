package coloc.back.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@JsonView(Views.ViewCommon.class)
public class Photo {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY )
	private Long id;
	private String libelle;
	private String chemin;
	private Integer ordre;
	
	@ManyToOne
	@JsonView(Views.ViewPhotoDetail.class)
	private Logement logement;
	
	@ManyToOne
	@JsonView(Views.ViewPhotoDetail.class)
	private Chambre chambre;
	
	public Photo() {
	}

	public Photo(String libelle, String chemin, Integer ordre) {
		this.libelle = libelle;
		this.chemin = chemin;
		this.ordre = ordre;
	}

	public Photo(String libelle, String chemin, Integer ordre, Logement logement) {
		this.libelle = libelle;
		this.chemin = chemin;
		this.ordre = ordre;
		this.logement = logement;
	}
	
	public Photo(String libelle, String chemin, Integer ordre, Logement logement, Chambre chambre) {
		this.libelle = libelle;
		this.chemin = chemin;
		this.ordre = ordre;
		this.logement = logement;
		this.chambre = chambre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public Integer getOrdre() {
		return ordre;
	}

	public void setOrdre(Integer ordre) {
		this.ordre = ordre;
	}

	public Logement getLogement() {
		return logement;
	}

	public void setLogement(Logement logement) {
		this.logement = logement;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}
	
	
}
