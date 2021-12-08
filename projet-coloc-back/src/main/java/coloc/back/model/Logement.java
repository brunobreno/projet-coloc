package coloc.back.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@JsonView(Views.ViewCommon.class)
public class Logement {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY )
	private Long id;
//	@Version
//	private Integer version;
	private String titre;
	private String description;
	private Integer surface;
	private Integer nChambre;
	private Integer nChambreOccup;
	private Integer nSdb;
	private Double loyer;
	private Double charges;
	private Double caution;
	private LocalDate dateDeMiseEnLigne;
	private boolean meuble;
	
	@OneToMany(mappedBy = "logement")
	@JsonView(Views.ViewLogementComplete.class)
	private List<Photo> photos;
	
	@OneToMany(mappedBy = "logement")
	@JsonView(Views.ViewLogementDetail.class)
	private List<Notation> notations;
	
	private LocalDate dateDispo;
	
	@ManyToOne
	private Proprietaire proprietaire;
	
	@Embedded
	private Localisation localisation;
	
	
	@Enumerated(EnumType.STRING)
	private TypeLogement typeLogement;
	
	@OneToMany(mappedBy = "logement")
	@JsonView(Views.ViewLogementDetail.class)
	private List<Chambre> chambres = new ArrayList<Chambre>();

	@ManyToMany
	@JoinTable
	(
		name="commodite_logement"
	)
	//@JsonView(Views.ViewLogementCommodite.class)
	@JsonView(Views.ViewLogementComplete.class)
	private  List<Commodite> commodites = new ArrayList<Commodite>();
	
	@ManyToMany
	@JoinTable
	(
		name="regle_logement"
	)
	@JsonView(Views.ViewLogementComplete.class)
	private List<Regle> regles = new ArrayList<Regle>();
	
	public Logement() {
		super();
	}

	public Logement(Proprietaire proprietaire, String titre, String description, Integer surface, Integer nchambre, Integer nChambreOccup, Integer nSdb, Double loyer, Double charges, Double caution,
			Localisation localisation, TypeLogement typeLogement) {
		super();
		this.proprietaire = proprietaire;
		this.titre = titre;
		this.description = description;
		this.surface = surface;
		this.nChambre = nchambre;
		this.nChambreOccup = nChambreOccup;
		this.nSdb = nSdb;
		this.loyer = loyer;
		this.charges = charges;
		this.caution = caution;
		this.localisation = localisation;
		this.typeLogement = typeLogement;
		this.dateDeMiseEnLigne = LocalDate.now();
	}
	
	public Logement(Proprietaire proprietaire, String titre, String description, boolean meuble, Integer surface, Integer nchambre, Integer nChambreOccup, Integer nSdb, Double loyer, Double charges, Double caution,
			Localisation localisation, TypeLogement typeLogement) {
		super();
		this.proprietaire = proprietaire;
		this.titre = titre;
		this.description = description;
		this.surface = surface;
		this.nChambre = nchambre;
		this.nChambreOccup = nChambreOccup;
		this.nSdb = nSdb;
		this.loyer = loyer;
		this.charges = charges;
		this.caution = caution;
		this.localisation = localisation;
		this.typeLogement = typeLogement;
		this.meuble = meuble;
	}

	public Logement(Proprietaire proprietaire, String titre, String description, Integer surface, Integer nchambre, Integer nChambreOccup, Integer nSdb, Double loyer, Double charges, Double caution,
			Localisation localisation, TypeLogement typeLogement, LocalDate dateDispo, boolean meuble) {
		super();
		this.proprietaire = proprietaire;
		this.titre = titre;
		this.description = description;
		this.surface = surface;
		this.nChambre = nchambre;
		this.nChambreOccup = nChambreOccup;
		this.nSdb = nSdb;
		this.loyer = loyer;
		this.charges = charges;
		this.caution = caution;
		this.localisation = localisation;
		this.typeLogement = typeLogement;
		this.dateDispo = dateDispo;
		this.dateDeMiseEnLigne = LocalDate.now();
		this.meuble = meuble;
	}
	
	public Logement(Proprietaire proprietaire, String titre, String description, Integer surface, Integer nchambre, Integer nChambreOccup, Integer nSdb, Double loyer, Double charges, Double caution,
			Localisation localisation,TypeLogement typeLogement, List<Commodite> commodites,List<Regle> regles) {
		super();
		this.proprietaire = proprietaire;
		this.description = description;
		this.titre = titre;
		this.surface = surface;
		this.nChambre = nchambre;
		this.nChambreOccup = nChambreOccup;
		this.nSdb = nSdb;
		this.loyer = loyer;
		this.charges = charges;
		this.caution = caution;
		this.localisation = localisation;
		this.typeLogement = typeLogement;
		this.commodites = commodites;
		this.regles = regles;
		this.dateDeMiseEnLigne = LocalDate.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSurface() {
		return surface;
	}

	public void setSurface(Integer surface) {
		this.surface = surface;
	}

	public Integer getnChambre() {
		return nChambre;
	}

	public void setnChambre(Integer nChambre) {
		this.nChambre = nChambre;
	}

	public Integer getnChambreOccup() {
		return nChambreOccup;
	}

	public void setnChambreOccup(Integer nChambreOccup) {
		this.nChambreOccup = nChambreOccup;
	}

	public Integer getnSdb() {
		return nSdb;
	}

	public void setnSdb(Integer nSdb) {
		this.nSdb = nSdb;
	}

	public Double getLoyer() {
		return loyer;
	}

	public void setLoyer(Double loyer) {
		this.loyer = loyer;
	}

	public Double getCharges() {
		return charges;
	}

	public void setCharges(Double charges) {
		this.charges = charges;
	}

	public Double getCaution() {
		return caution;
	}

	public void setCaution(Double caution) {
		this.caution = caution;
	}

	
	public boolean isMeuble() {
		return meuble;
	}

	public void setMeuble(boolean meuble) {
		this.meuble = meuble;
	}

	public LocalDate getDateDispo() {
		return dateDispo;
	}

	public void setDateDispo(LocalDate dateDispo) {
		this.dateDispo = dateDispo;
	}

	public Localisation getLocalisation() {
		return localisation;
	}

	public void setLocalisation(Localisation localisation) {
		this.localisation = localisation;
	}

	public TypeLogement getTypeLogement() {
		return typeLogement;
	}

	public void setTypeLogement(TypeLogement typeLogement) {
		this.typeLogement = typeLogement;
	}
	
	

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Chambre> getChambres() {
		return chambres;
	}

	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}

	public List<Commodite> getCommodites() {
		return commodites;
	}

	public void setCommodites(List<Commodite> commodites) {
		this.commodites = commodites;
	}

	public void addCommodite(Commodite commodite) {
		this.commodites.add(commodite);
	}

	public void setRegles(List<Regle> regles) {
		this.regles = regles;
	}

	public void addRegle(Regle regle) {
		this.regles.add(regle);
	}

	public List<Regle> getRegles() {
		return regles;
	}

	public List<Notation> getNotations() {
		return notations;
	}

	public void setNotations(List<Notation> notations) {
		this.notations = notations;
	}

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public LocalDate getDateDeMiseEnLigne() {
		return dateDeMiseEnLigne;
	}

	public void setDateDeMiseEnLigne(LocalDate dateDeMiseEnLigne) {
		this.dateDeMiseEnLigne = dateDeMiseEnLigne;
	}

	@Override
	public String toString() {
		return "Logement [id=" + id + ", description=" + description + ", nChambre=" + nChambre + ", nChambreOccup="
				+ nChambreOccup + ", loyer=" + loyer + ", typeLogement="
				+ typeLogement + "]";
	}
}
