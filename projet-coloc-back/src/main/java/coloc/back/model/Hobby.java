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
public class Hobby {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY )
	private Long id;
	private String libelle;
	private String chemin;
	
	@ManyToMany(mappedBy = "hobbies")
	@JsonView(Views.ViewHobbyDetail.class)
	private List<Locataire> Locataires;

	
	public Hobby() {
		super();
	}

	public Hobby(String libelle,String chemin) {
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


	public List<Locataire> getLocataires() {
		return Locataires;
	}

	public void setLocataires(List<Locataire> locataires) {
		Locataires = locataires;
	}

	@Override
	public String toString() {
		return "Hobby [id=" + id + ", libelle=" + libelle + "]";
	}
}
