package coloc.back.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@JsonView(Views.ViewCommon.class)
public class Chambre {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY )
	private Long id;
	
	@Version
	private Integer version;

	@ManyToOne
	@JsonView(Views.ViewChambre.class)
	private Logement logement;
	
	@OneToOne(mappedBy = "chambre" )
	@JsonView(Views.ViewChambre.class)
	private Locataire locataire;
	
	@JsonView(Views.ViewChambre.class)
	private Integer surface;
	
	@ManyToMany
	@JoinTable
	(
		name="commodite_chambre"
	)
	@JsonView(Views.ViewChambreDetail.class)
	private List<Commodite> commodites = new ArrayList<Commodite>();

	@OneToMany(mappedBy = "chambre")
	@JsonView(Views.ViewChambreDetailCandidature.class)
	private List<Candidature> candidatures = new ArrayList<Candidature>();
	
	public Chambre() {
	}

	public Chambre(Logement logement, int surface) {
		this.logement = logement;
		this.surface = surface;
	}
	
	public Chambre(Logement logement, int surface, List<Commodite> commodites) {
		this.logement = logement;
		this.surface = surface;
		this.commodites = commodites;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Logement getLogement() {
		return logement;
	}

	public void setLogement(Logement logement) {
		this.logement = logement;
	}

	public int getSurface() {
		return surface;
	}
	
	public void setSurface(int surface) {
		this.surface = surface;
	}

	public List<Commodite> getCommodites() {
		return commodites;
	}

	public void setCommodites(List<Commodite> commodites) {
		this.commodites = commodites;
	}

	public void addCommodites(Commodite commodite) {
		this.commodites.add(commodite);
	}

	public Locataire getLocataire() {
		return locataire;
	}

	public void setLocataire(Locataire locataire) {
		this.locataire = locataire;
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

}
