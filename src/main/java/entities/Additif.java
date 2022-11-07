package entities;

public class Additif {
	
	/**
	 * Nom de l'additif
	 */
	
	private String libelle;

	/**
	 * 
	 * @param libelle Nom de l'additif
	 *
	 */
	public Additif(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
