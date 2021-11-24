package coloc.back.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@JsonView(Views.ViewCommon.class)
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Utilisateur emetteur;
	@OneToOne
	private Utilisateur destinataire;
	private String contenu;
	private LocalDateTime date;
	
	public Message() {
		super();
	}

	public Message(Utilisateur emetteur, Utilisateur destinataire, String contenu) {
		super();
		this.emetteur = emetteur;
		this.destinataire = destinataire;
		this.contenu = contenu;
		this.date = LocalDateTime.now();
	}

	public Message(Utilisateur emetteur, Utilisateur destinataire, String contenu, LocalDateTime date) {
		super();
		this.emetteur = emetteur;
		this.destinataire = destinataire;
		this.contenu = contenu;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utilisateur getEmetteur() {
		return emetteur;
	}

	public void setEmetteur(Utilisateur emetteur) {
		this.emetteur = emetteur;
	}

	public Utilisateur getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(Utilisateur destinataire) {
		this.destinataire = destinataire;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", emetteur=" + emetteur + ", destinataire=" + destinataire + ", contenu="
				+ contenu + "]";
	}
}
