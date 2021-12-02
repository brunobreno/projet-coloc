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
public class Regle {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY )
	private Long id;
	private String libelle;
	
	@ManyToMany(mappedBy = "regles")
	@JsonView(Views.ViewRegleLogement.class)
	private List<Logement> logements;
	
	public Regle() {
		super();
	}

	public Regle(String libelle) {
		this.libelle = libelle;
	}
	
	public Regle(Long id, String libelle) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Regle [id=" + id + ", libelle=" + libelle + "]";
	}
}
