package coloc.back.model;

import javax.persistence.Embeddable;

@Embeddable
public class Dossier {
	
	private Double revenu;
	private Double revenuGarant;
	private Situation situationGarant;
	
	public Dossier() {
		super();
	}

	public Dossier(Double revenu, Double revenuGarant, Situation situationGarant) {
		this.revenu = revenu;
		this.revenuGarant = revenuGarant;
		this.situationGarant = situationGarant;
	}

	public Double getRevenu() {
		return revenu;
	}

	public void setRevenu(Double revenu) {
		this.revenu = revenu;
	}

	public Double getRevenuGarant() {
		return revenuGarant;
	}

	public void setRevenuGarant(Double revenuGarant) {
		this.revenuGarant = revenuGarant;
	}

	public Situation getSituation() {
		return situationGarant;
	}

	public void setSituation(Situation situationGarant) {
		this.situationGarant = situationGarant;
	}
	
	@Override
	public String toString() {
		return "Dossier [revenu=" + revenu + ", revenuGarant=" + revenuGarant + ", situation="
				+ situationGarant + "]";
	}
}
