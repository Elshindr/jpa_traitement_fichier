package entities;


/**
 * 
 * @author MyriamAgag
 * 
 * Représente un allerge
 *
 */

public class Allergene {

	/**
	 * Nom de l'allergène
	 */
	
	private String libelle;

	/**
	 * 
	 * @param libelle Nom de l'allergène
	 *
	 */
	public Allergene(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	
	

}
