package entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author MyriamAgag
 * 
 * Représente un allerge
 *
 */
@Entity
@Table(name="allergene")
public class Allergene {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToMany
	@JoinTable(name="LIEN_PRODUIT_ALLERGENE",
			joinColumns = @JoinColumn(name="id_allergene", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="id_produit", referencedColumnName = "id")
	)
	private List<Produit> lstProduit= new ArrayList<>();

	private String libelle;


	// CONSTRUCTOR
	public Allergene() {
	}

	public Allergene(Integer id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	public Allergene(String libelle) {
		this.libelle = libelle;
	}


	// GETTER & SETTER
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
