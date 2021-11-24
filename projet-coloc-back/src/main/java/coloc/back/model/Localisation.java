package coloc.back.model;

import javax.persistence.Embeddable;

@Embeddable
public class Localisation {
	
	private String departement;
	private String ville;
	private String codePostal;
	private String voie;
	private Integer num;
	
	public Localisation() {
	}

	public Localisation(String departement, String ville, String codePostal, String voie, Integer num) {
		super();
		this.departement = departement;
		this.ville = ville;
		this.codePostal = codePostal;
		this.voie = voie;
		this.num = num;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Localisation [departement=" + departement + ", ville=" + ville + ", codePostal="
				+ codePostal + ", voie=" + voie + ", num=" + num + "]";
	}
}
