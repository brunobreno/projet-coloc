package coloc.back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity

public class Notation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Logement logement;

	@OneToOne
	private Locataire locataire;
	
	private Double note;
	
	@Column(columnDefinition = "VARCHAR(75)")
	private String commentaire;
	
	public Notation() {
	}

	public Notation(Logement logement, Locataire locataire, Double note, String commentaire) {
		this.logement = logement;
		this.locataire = locataire;
		this.note = note;
		this.commentaire = commentaire;
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

	public Locataire getLocataire() {
		return locataire;
	}

	public void setLocataire(Locataire locataire) {
		this.locataire = locataire;
	}

	public Double getNote() {
		return note;
	}

	public void setNote(Double note) {
		this.note = note;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Override
	public String toString() {
		return "Notation [id=" + id + ", note=" + note + ", commentaire=" + commentaire + "]";
	}
}
