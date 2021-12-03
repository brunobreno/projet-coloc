package coloc.back.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="type_utilisateur",columnDefinition = ("ENUM('locataire','proprio')"))
@JsonView(Views.ViewCommon.class)
public abstract class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	@Version
	private Integer version;
	private String username;
	protected String nom;

	protected String prenom;
	@Enumerated(EnumType.STRING)

	protected Civilite civ;
	@Column(unique = true)

	protected String email;

	protected String tel;
	@JsonView(Views.ViewPassword.class)
	protected String password;
	@JsonView(Views.ViewProprietaireDetail.class)
	@OneToMany(mappedBy = "user")
	private Set<UtilisateurRole> roles;	

	public Utilisateur() {
		super();
	}

	public Utilisateur(String username, String nom, String prenom, Civilite civ, String email, String tel, String password, Set<UtilisateurRole> roles) {
		this.username = username;
		this.nom = nom;
		this.prenom = prenom;
		this.civ = civ;
		this.email = email;
		this.tel = tel;
		this.password = password;
		this.roles = roles;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Civilite getCiv() {
		return civ;
	}

	public void setCiv(Civilite civ) {
		this.civ = civ;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<UtilisateurRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UtilisateurRole> roles) {
		this.roles = roles;
	}
	
	public List<String> getStringRoles() {
		List<String> stringRoles = new ArrayList<>();
		for (UtilisateurRole role : roles) {
			stringRoles.add("ROLE_" + role.getRole().name());
		}
		return stringRoles;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", civ=" + civ + ", email=" + email
				+ ", tel=" + tel + "]";
	}

}
