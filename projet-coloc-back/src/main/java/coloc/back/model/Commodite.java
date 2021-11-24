package coloc.back.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonView;

import coloc.back.model.Views.ViewChambre;

@Entity
@JsonView(Views.ViewCommon.class)
public class Commodite {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY )
	private Long id;
	private String libelle;
	@ManyToMany(mappedBy = "commodites")
	@JsonView(Views.ViewCommoditeLogement.class)
	private List<Logement> logements;
	@ManyToMany(mappedBy = "commodites")
	@JsonView(Views.ViewCommoditeChambre.class)
	private List<Chambre> chambres;
	
	public Commodite() {
		super();
	}

	public Commodite(String libelle) {
		super();
		this.libelle = libelle;
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

	public List<Logement> getLogements() {
		return logements;
	}

	public void setLogements(List<Logement> logements) {
		this.logements = logements;
	}

	public List<Chambre> getChambres() {
		return chambres;
	}

	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}

	@Override
	public String toString() {
		return "Commodite [id=" + id + ", libelle=" + libelle + "]";
	}
}
