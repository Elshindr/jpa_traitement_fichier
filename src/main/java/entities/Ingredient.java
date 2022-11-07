package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ingredient")
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * Nom de l'ingredient
	 */
	private String libelle;

	@ManyToMany
	@JoinTable(name="LIEN_PRODUIT_INGREDIENT",
			joinColumns = @JoinColumn(name="id_ingredient", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="id_produit", referencedColumnName = "id")
	)
	private List<Produit> lstProduit = new ArrayList<>();



	public Ingredient() {
	}

	/**
	 * 
	 * @param libelle Nom de l'ingredient
	 *
	 */
	public Ingredient(String libelle) {
		this.libelle = libelle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Produit> getLstProduit() {
		return lstProduit;
	}

	public void setLstProduit(List<Produit> lstProduit) {
		this.lstProduit = lstProduit;
	}
}
