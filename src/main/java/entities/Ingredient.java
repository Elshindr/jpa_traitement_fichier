package entities;

public class Ingredient {

	/**
	 * Nom de l'ingredient
	 */
	
	private String libelle;

	/**
	 * 
	 * @param libelle Nom de l'ingredient
	 *
	 */
	public Ingredient(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
