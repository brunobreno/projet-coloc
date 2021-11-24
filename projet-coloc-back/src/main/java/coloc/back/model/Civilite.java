package coloc.back.model;

public enum Civilite {
	
	Mr("Monsieur"),Mme("Madame"),NB("Non Binaire");
	
	private String libelle;

	private Civilite(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
}
