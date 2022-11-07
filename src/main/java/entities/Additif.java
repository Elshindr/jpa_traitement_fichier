package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="additif")
public class Additif {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * Nom de l'additif
	 */
	private String libelle;

	@ManyToMany
	@JoinTable(name="LIEN_PRODUIT_ADDITIF",
			joinColumns = @JoinColumn(name="id_additif", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="id_produit", referencedColumnName = "id")
	)
	private List<Produit> lstProduit= new ArrayList<>();



	public Additif() {
	}

	public Additif(Integer id, String libelle) {
		this.id = id;
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
