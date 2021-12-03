package coloc.back.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@JsonView(Views.ViewCommon.class)
public class Commodite {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY )
	private Long id;
	private String libelle;
	private String chemin;
	@ManyToMany(mappedBy = "commodites")
	@JsonView(Views.ViewCommoditeLogement.class)
	private List<Logement> logements;
	@ManyToMany(mappedBy = "commodites")
	@JsonView(Views.ViewCommoditeChambre.class)
	private List<Chambre> chambres;
	
	public Commodite() {
		super();
	}

	public Commodite(String libelle,String chemin) {
		super();
		this.libelle = libelle;
		this.chemin = chemin;	}

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
